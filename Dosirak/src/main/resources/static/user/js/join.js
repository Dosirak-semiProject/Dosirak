window.onload = function() {

    if(document.getElementById("userDuplCheck")) {
        const $duplication = document.getElementById("userDuplCheck");

        $duplication.onclick = function() {
            let id = document.getElementById("id").value.trim();

            fetch("/user/join/idDupCheck", {
                method: "POST",
                headers: {
                    'Content-Type': 'application/json;charset=UTF-8'
                },
                body: JSON.stringify({id: id})
            })
                .then(result => result.text())
                .then(result => alert(result))
                .catch((error) => error.text().then((res) => alert(res)));
        }
    }
}