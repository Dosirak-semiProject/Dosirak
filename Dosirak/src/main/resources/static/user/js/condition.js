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
    let password = $(".el_pwdInput").val();
    let pwNum = password.search(/[0-9]/g);
    let pwEng = password.search(/[a-z]/ig);
    let pwSpe = password.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

    if(password.length < 8){
        alert("8자리 이상 입력해주세요");
        $(".el_pwdInput").focus();
        $(".pwdMessage").text('부적합').css('color', 'red');
        $(".pwdHidden").val(false);
        return false;
    }else if(pwNum<0 || pwEng<0 || pwSpe<0){
        alert("영문자, 숫자, 특수기호가 반드시 포함되어야 합니다");
        $(".el_pwdInput").focus();
        $(".pwdMessage").text('부적합').css('color', 'red');
        $(".pwdHidden").val(false);
        return false;
    }

    $(".pwdMessage").text('적합').css('color', 'blue');
    $(".pwdHidden").val(true);
}
function passwordCheck(){
    if($(".el_pwdInput").val() == $(".el_pwdCheckInput").val()){
        $(".pwdCheckMessage").text('일치').css('color', 'blue');
        $(".pwdCheckHidden").val(true);
    }else{
        $(".pwdCheckMessage").text('불일치').css('color', 'red');
        $(".pwdCheckHidden").val(false);
    }
}


// 이메일인증
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
                    document.getElementById("verifyVerificationCode").value = "pass";
                }else{
                    alert("인증코드가 올바르지 않습니다.");
                    document.getElementById("verifyVerificationCode").value = "";
                }
            }else{
                alert("인증코드 확인 중 오류가 발생했습니다.");
                document.getElementById("verifyCode").value = "";
            }
        }
    }
    xhr.send(JSON.stringify({"inputCode":inputCode, "hiddenCode":hiddenCode}));
}