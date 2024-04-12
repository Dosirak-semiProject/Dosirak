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