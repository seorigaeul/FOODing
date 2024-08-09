var passwordChecked = false;
/* 회원가입 & 개인정보 수정 창의 비밀번호 확인*/
function validatePassword() {
    var password = document.getElementById("mpass").value;
    var confirmPassword = document.getElementById("mpassConfirm").value;
    var message = document.getElementById("confirmMessage");
    if (password === confirmPassword) {
        message.style.color = "green";
        message.innerHTML = "비밀번호가 일치합니다.";
        passwordChecked = true;
    } else {
        message.style.color = "red";
        message.innerHTML = "비밀번호가 일치하지 않습니다.";
        passwordChecked = false;
    }
}


function validatePassForm() {
    if (!passwordChecked) {
        alert("비밀번호 확인을 완료해주세요.");
        return false;
    }
    return true;
}



/* 회원가입 시 값을 아무것도 입력하지 않으면 뜨는 경고창 */
function validateForm() {
    var fields = ["mid", "mname", "mpass", "mpassConfirm", "mnick", "mbirth", "mphone", "memail"];
    var fieldLabels = {
        "mid": "ID",
        "mname": "성명",
        "mpass": "비밀번호",
        "mpassConfirm": "비밀번호 확인",
        "mnick": "닉네임",
        "mbirth": "생년월일",
        "mphone": "전화번호",
        "memail": "이메일"
    };
    var valid = true;

    fields.forEach(function(field) {
        var value = document.forms["registrationForm"][field].value;
        if (value === null || value === "") {
            alert(fieldLabels[field] + "를(을) 입력해 주세요.");
            valid = false;
        }
    });
    if (!passwordChecked) {
        alert("비밀번호 확인을 완료해주세요.");
        return false;
    }
    return valid;
}

