window.onload = function() {

    if(document.getElementById("duplicationCheck")) {
        const $duplication = document.getElementById("duplicationCheck");

        $duplication.onclick = function() {
            let email = document.getElementById("inputEmail").value.trim();

            fetch("/admin/member/idDupCheck", {
                method: "POST",
                headers: {
                    'Content-Type': 'application/json;charset=UTF-8'
                },
                body: JSON.stringify({email: email})
            })
                .then(result => result.text())
                .then(result => alert(result))
                .catch((error) => error.text().then((res) => alert(res)));
        }
    }
}

$(function(){

})

function noSpace(obj){
    let str_space = /\s/;
    if(str_space.exec(obj.value)){
        alert("공백 입력 불가");
        obj.focus();
        obj.value = obj.value.replace(' ', '');
        return false;
    }
}
function passwordCondition(){
    let password = $("#inputPwd").val();
    let pwNum = password.search(/[0-9]/g);
    let pwEng = password.search(/[a-z]/ig);
    let pwSpe = password.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

    if(password.length < 8){
        alert("8자리 이상 입력해주세요");
        return false;
    }else if(pwNum<0 || pwEng<0 || pwSpe<0){
        alert("영문자, 숫자, 특수기호가 반드시 포함되어야 합니다");
        return false;
    }
}
function passwordCheck(){
    if($("#inputPwd").val() == $("#inputPwdConfirm").val()){
        $("#pwdCheckMsg").text('※ 비밀번호 일치').css('color', 'blue');
        $(".joinBtn").removeAttr("disabled");
    }else{
        $("#pwdCheckMsg").text('※ 비밀번호 불일치').css('color', 'red');
    }
}

function sendCode(){
    let email = document.getElementById("inputEmail").value;
    let hiddenCode = document.getElementById("hiddenCode").value;

    if(!email.includes("@")){
        alert("올바른 이메일 주소를 입력해주세요");
        return;
    }

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/sendVerificationCode", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            alert("인증코드가 이메일로 전송되었습니다.");
        }
    };
    xhr.send(JSON.stringify({"email": email, "hiddenCode": hiddenCode}));
}

function verifyCode(){
    let inputCode = document.getElementById("inputCode").value;
    let hiddenCode = document.getElementById("hiddenCode").value;
    if(inputCode == null || inputCode == ""){
        alert("인증코드를 입력해주세요");
        return;
    }

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/verifyVerificationCode", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onreadystatechange = function (){
        if(xhr.readyState === 4){
            if(xhr.status === 200){
                let response = JSON.parse(xhr.responseText);
                if(response.valid){
                    alert("인증되었습니다.");
                }else{
                    alert("인증코드가 올바르지 않습니다.");
                }
            }else{
                alert("인증코드 확인 중 오류가 발생했습니다.");
            }
        }
    }
    xhr.send(JSON.stringify({"inputCode":inputCode, "hiddenCode":hiddenCode}));
}