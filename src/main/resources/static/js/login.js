var $waning = $("#warning");
var $inputEmail = $("#inputEmail");
var $inputPassword = $("#inputPassword");

$(function () {
    $("#btnLogin").click(function () {
        var email = $inputEmail.val();
        var password = $inputPassword.val();
        login(email, password);
    });
});

function login(email, password) {
    if (!email) {
        $("#groupEmail").addClass("has-error");
        $waning.empty().append("请输入邮箱地址。").show();
        return;
    }

    if (!password) {
        $("#groupPassword").addClass("has-error");
        $waning.empty().append("请输入密码。").show();
        return;
    }

    $.ajax({
        type: "POST",
        url: "/api/users/",
        data: 1,
        dataType: "json",
        success: function (res) {
            console.log(res);
        },
        error: function (e) {
            console.error(e);
        }
    });
}