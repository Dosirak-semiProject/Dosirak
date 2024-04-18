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