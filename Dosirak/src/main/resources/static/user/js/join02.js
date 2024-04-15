$(function(){
    // 마케팅동의 상태 넘겨받아서 체크박스 표시
    const urlType = new URL(location.href).searchParams.get("type");
    if(urlType == "mkAgree") $(".bl_checkBx__input").prop("checked", true);

    // 아이디 중복확인
    $(".el_idDupliBtn").click(function(){
        let id = $(".el_idInput").val();
        if(id == null || id == ""){
            alert("아이디를 입력해주세요");
            return false;
        }

        if($(".idHidden").val() == "true"){
            $.ajax({
                url:"/user/join/idCheck",
                type: "post",
                data: {id:id},
                success:function(result){
                    if(result){
                        alert("중복된 아이디가 존재합니다.");
                        $(".idCheckHidden").val(false);
                        $(".el_idInput").focus();
                    }else{
                        alert("사용 가능한 아이디 입니다.");
                        $(".idCheckHidden").val(true);
                    }
                },
                error:function(){
                    alert("에러발생");
                }
            });
        }else if($(".idHidden").val() == "false"){
            alert("영문소문자, 숫자로 이루어진 4 ~ 15자 이내의 아이디를 입력해주세요");
            $(".el_idInput").focus();
            return false;
        }
    })

    // 비밀번호 생성 확인 후 비밀번호 확인 입력 허용
    $(".el_pwdCheckInput").focus(function(){
        if($(".pwdHidden").val() == "false"){
            alert("비밀번호를 먼저 생성해 주세요.");
            $(".el_pwdInput").focus();
            return false;
        }
    })

    // 회원가입 버튼 활성화
    $("input").on("propertychange change", function(){
        let isTrue = true;

        for(let i=0; i<$("input[type=hidden]").length; i++){
            let hiddenInput = $("input[type=hidden]").eq(i).val();
            console.log(hiddenInput);
            if(hiddenInput == "false"){
                isTrue = false;
            }
        }
        console.log("isTrue : " + isTrue);

        if(isTrue){
            $("#btnJoin02").attr("disabled", false);
        }else{
            $("#btnJoin02").attr("disabled", true);
        }
    })
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
function idCondition(){
    let id = $(".el_idInput").val();
    let Num = id.search(/[0-9]/g);
    let Eng = id.search(/[a-z]/ig);
    let Special = id.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

    if(id.length < 4 || id.length > 15){
        alert("4 ~ 15자 이내로 입력해주세요");
        $(".idHidden").val(false);
        return false;
    }else if(Num<0 || Eng<0){
        alert("영문자와 숫자가 반드시 포함되어야 합니다");
        $(".idHidden").val(false);
        return false;
    }else if(Special>0){
        alert("특수기호는 사용할 수 없습니다");
        $(".idHidden").val(false);
        return false;
    }

    $(".idHidden").val(true);
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

function onlyKorFunc(txt){
    var regexp = /[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g;
    if(regexp.exec(txt.value)){
        alert("한글만 입력할 수 있습니다.");
        txt.focus();
        txt.value = txt.value.replace(regexp, '');
        return false;
    }
}
