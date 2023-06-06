// Validate the customer update form
function validateForm() {
    var email = document.getElementById("email").value;
    var phone = document.getElementById("phone").value;
    var emailOTP = document.getElementById("emailOTP").value;
    var phoneOTP = document.getElementById("phoneOTP").value;

    // Perform validation logic here
    // You can use regular expressions or other validation methods

    if (email === "") {
        alert("Email is required.");
        return false;
    }

    if (phone === "") {
        alert("Phone is required.");
        return false;
    }

    if (emailOTP === "") {
        alert("Email OTP is required.");
        return false;
    }

    if (phoneOTP === "") {
        alert("Phone OTP is required.");
        return false;
    }

    return true;
}
