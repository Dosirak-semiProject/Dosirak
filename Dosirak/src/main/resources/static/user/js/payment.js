function orderCancel() {
    if (confirm("주문을 취소하시겠습니까?")) {
        window.history.back();
    }
}

function updateProductSum() {
    let productSum = 0;

    const $totalPrice = document.querySelectorAll('.js_totalPrice')
    $totalPrice.forEach(currentPrice=>{
        const priceInt = parseInt(currentPrice.textContent.replace(/원 \/$/, ''), 10)
        productSum = productSum + priceInt
    })
    console.log(productSum)
    $finalTotalPrice = document.querySelector('.js_productSum')
    $finalTotalPrice.innerText=productSum + ' 원'

    let charge = 0;

    if(productSum < 30000){
        charge = 3000
    }

    const $charge = document.querySelector('.js_charge')

    $charge.textContent = charge + ' 원'

    const $totalAmount = document.querySelector('.js_amount')
    $totalAmount.innerText = (productSum + charge) + ' 원'
}

updateProductSum();

const IMP = window.IMP
IMP.init("imp87822476")

const today = new Date();
const hours = today.getHours();
const minutes = today.getMinutes();
const second = today.getSeconds();
const milliseconds = today.getMilliseconds();
const makeMerchantUid = `${hours}` + `${minutes}` + `${second}` + `${milliseconds}`;


const $postCode = document.querySelector('.buyerAddr1')

function payment() {
    const $payMethod = document.querySelector('.bl_radioCircle__input')
    if (!$payMethod.checked) {
        alert("결제 방법을 선택해주세요.");
        return;
    }

    const $totalAmount = document.querySelector('.js_amount');
    const totalAmountText = $totalAmount.textContent;
    const totalAmount = parseInt(totalAmountText.replace(/원/g, ''), 10);
    const $buyName = document.querySelector('.pay_buyerName')
    const $buyTel = document.querySelector('.pay_buyerTel')
    const $addr2 = document.querySelector('.buyerAddr2')
    const $addr3 = document.querySelector('.buyerAddr3')
    const addr =  $addr2 + $addr3
    console.log("구매자 주소: ", $addr2);
    console.log("구매자 주소: ", $addr3);
    console.log("구매자 주소: ", addr);

    function getBuyerName() {
        const buyerNameInput = document.querySelector('.pay_buyerName');
        const buyerName = buyerNameInput.value.trim();
        if (buyerName !== '') {
            return buyerName;
        } else {
            return buyerNameInput.defaultValue;
        }
    }

    const buyerName = getBuyerName();
ㅌ

    IMP.request_pay({
        pg : 'kakaopay',
        merchant_uid : "IMP" + makeMerchantUid,
        name : 'Dosirak',
        amount : totalAmount,
        buyer_name : buyerName,
        buyer_tel : `${$buyTel}`,
        buyer_addr : `${addr}`,
        buyer_postcode : `${$addr3}`
    }, (rsp) => {
        if (rsp.success) {
            console.log(rsp);
            window.location.href='/user/orderDone'
        } else {}
        console.log(rsp)
    })
}

const postCodeButton = document.querySelector('#postCode')
postCodeButton.addEventListener('click', () => {
    new daum.Postcode({
        oncomplete: function(data) {
            document.getElementById("address1").value = data.zonecode;
            document.getElementById("address2").value = data.address;
            document.getElementById("address3").focus();
        }
    }).open();
})