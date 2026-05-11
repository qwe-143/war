function validateRegister() {

    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    if (name == "") {
        alert("Enter Name");
        return false;
    }

    if (email == "") {
        alert("Enter Email");
        return false;
    }

    if (!email.includes("@")) {
        alert("Invalid Email");
        return false;
    }

    if (password.length < 6) {
        alert("Password must be minimum 6 characters");
        return false;
    }

    alert("Registration Successful");

    window.location.href = "catalog.html";

    return false;
}