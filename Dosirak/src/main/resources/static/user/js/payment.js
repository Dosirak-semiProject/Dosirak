const IMP = window.IMP
IMP.init("imp87822476")

const today = new Date();
const hours = today.getHours();
const minutes = today.getMinutes();
const second = today.getSeconds();
const milliseconds = today.getMilliseconds();
const makeMerchantUid = `${hours}` + `${minutes}` + `${second}` + `${milliseconds}`;

function payment() {
    IMP.request_pay({
        pg : 'kakaopay',
        merchant_uid : "IMP" + makeMerchantUid,
        name : '도시락',
        amount : 4500,
        buyer_email : 'dosirak@gmail.com',
        buyer_name : '홍길동',
        buyer_tel : '010-1234-5678',
        buyer_addr : '서울특별시 종로구 종로3가',
        buyer_postcode : '123-456'
    }, (rsp) => {
        if (rsp.success) {
            console.log(rsp);
            window.location.href='/user/orderDone'
        } else {}
        console.log(rsp)
    })
}