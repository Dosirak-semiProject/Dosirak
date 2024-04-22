
// 체크박스 전체 선택/해제
const checkAll = document.querySelector('.checkAll');
const checkboxes = document.querySelectorAll('.checkOne');

checkAll.addEventListener('click', () => {
    const isChecked = checkAll.checked;

    for(const checkbox of checkboxes) {
        checkbox.checked = isChecked;
    }
});

// 구매하기 블록 스티키
window.addEventListener('scroll', () => {
    const element = document.querySelector('.sticky');
    const offset = window.pageYOffset;

    if(offset >= 200) {
        element.style.position = 'fixed';
        element.style.top = '35px';
        element.style.right = '341px';
    } else {
        element.style.position = 'absolute';
        element.style.top = '0';
        element.style.right = '0';
    }
});

// 수량 조절 버튼
const buttons = document.querySelectorAll('.decrease, .increase')
Array.from(buttons).forEach(function(button) {
    button.addEventListener('click', ButtonClick);
});

function ButtonClick(e) {
    const button = e.currentTarget;
    const input = button.parentElement.querySelector('.quantity');
    const value = parseInt(input.value, 10);
    let newValue = value;

    if (button.classList.contains('decrease')) {
        if (value > 1) {
            newValue = value -1;
            input.value = newValue;
        }
    } else if (button.classList.contains('increase')) {
        newValue = value + 1;
        input.value = newValue;
    }
    console.log(input.value);

    const productCode = button.closest('tr').getAttribute('data-product-code');

    axios.post('/user/cart/update-quantity', {
        productCode: productCode,
        cartitemCount: newValue
    }, {
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then(res => {
            console.log('성공:', res.data);

            const singleTotalPrices = res.data.singleTotalPrices;

            const priceElements  = document.querySelectorAll('.price')

            if (singleTotalPrices.length !== priceElements.length) {
                console.error('배열 길이와 요소 수가 일치하지 않습니다.');
                return;
            }

            priceElements.forEach((priceElement, index) => {
                if (singleTotalPrices[index] !== undefined) {
                    priceElement.textContent = `${ singleTotalPrices[index] } 원`;
                } else {
                    console.error(`인덱스 ${index}의 값이 정의되지 않았습니다.`);
                }
            });
        })
        .catch(err => console.log('오류:', err.response.message))
}

// 이미지 드래그 방지
document.querySelectorAll('.di_btn img').forEach(function(img) {
    img.addEventListener('dragstart', function() {
        event.preventDefault();
    });
});

// 장바구니 상품 여부 표시
document.addEventListener('DOMContentLoaded', () => {
    const cartItems = document.querySelectorAll('.hidden_block');
    const cartEmptyMessage = document.querySelector('.bl_TBList__empty');

    if (cartItems.length === 0) {
        cartEmptyMessage.parentNode.classList.add('hide-empty-row');
        cartEmptyMessage.classList.add('show_empty_message');
    }
});