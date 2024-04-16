
$(function(){
    // 전체동의
    $(".bl_checkBxAll__input").click(function(){
        let isCheckAll = $(".bl_checkBxAll__input").is(":checked");
        if(isCheckAll){
            $(".bl_checkBx__input").prop("checked", true);
        }else{
            $(".bl_checkBx__input").prop("checked", false);
        }
    })
    // 전체동의 풀기
    $(".bl_checkBxS__input").click(function(){
        for(let i=0; i<$(".bl_checkBxS__input").length; i++){
            let isCheck = $(".bl_checkBxS__input").eq(i).is(":checked");
            if(!isCheck) $(".bl_checkBxAll__input").prop("checked", false);
        }
    })

    // 필수동의 확인 > 버튼 활성화
    $(".bl_checkBx__input").change(function(){
        let isTrue = true;

        for(let i=0; i<$(".bl_checkBxRequired__input").length; i++){
            let requiredCheck = $(".bl_checkBxRequired__input").eq(i).is(":checked");
            if(!requiredCheck) isTrue = false;
        }

        if(isTrue){
            $("#btnJoin01").attr("disabled", false);
        }else{
            $("#btnJoin01").attr("disabled", true);
        }
    })

    $("#btnJoin01").click(function(){
        // 선택동의 파라미터 전달
        if($(".bl_checkBxM__input").is(":checked")){
            location.href = "/user/join/join02?type=mkAgree";
        }else{
            location.href = "/user/join/join02";
        }
    })
})