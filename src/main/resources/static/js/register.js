var inputs;
var data = {};

$(function () {
    $("#register").click(function () {
        var valid = validForm();
        if (valid) register();
    });

    $("#mainForm").find("input").each(function () {
        $(this).focus(function () {
            $("#" + this.id + "Group").removeClass("has-error");
        });
    });
});

function register() {
    data = {
        "email": "qiaowenhao@gmail.com",
        "name": "文昊",
        "password": md5("hao1128"),
        "school": "建大",
        "sex": "男",
        "experience": "老牛逼了"
    };

    $.ajax({
        type: "POST",
        url: "/api/users/",
        data: data,
        dataType: "json",
        success: function (res) {
            console.log(res);
        },
        error: function (e) {
            console.error(e);
        }
    });
}

function validForm() {
    inputs = {
        "email": $("#inputEmail"),
        "name": $("#inputName"),
        "password": $("#inputPassword"),
        "school": $("#inputSchool"),
        "sex": $("#selectSex"),
        "experience": $("#inputExperience")
    };

    for (var key in inputs) {
        var input = inputs[key];
        if (!input.val()) {
            var group = "#" + input[0].id + "Group";
            location.hash = group;
            $(group).addClass("has-error");
            return false;
        }
        if (key === "password") input[key] = md5(input.val());
        data[key] = input.val();
    }
    return true;
}