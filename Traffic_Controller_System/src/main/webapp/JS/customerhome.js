const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});


// validations 
function validate() {
	var customerid = document.getElementById("customerid").value;
	var customername = document.getElementById("customername").value;
	var customerpswd = document.getElementById("customerpswd").value;
	var customermobnum = document.getElementById("customermobnum").value;
	var customeremail = document.getElementById("customeremail").value;

	var customeridPattern = /^[A-Z0-9]+$/; // Only capital letters and numbers
	if (!customeridPattern.test(customerid)) {
		alert("Customer ID should contain only capital letters and numbers.");
		return false;
	}

	if (customerid.length <= 3) {
		alert("Customer ID should be greater than 3 characters.");
		return false;
	}

	if (customername === "") {
		alert("Customer Name cannot be empty");
		return false;
	}

	var passwordPattern = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@#$%^&*!])[A-Za-z\d@#$%^&*!]+$/;
	if (!passwordPattern.test(customerpswd)) {
		alert("Customer Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special symbol (@#$%^&*!)");
		return false;
	}

	if (customerpswd.length <= 6) {
		alert("Customer Password should be greater than 6 characters.");
		return false;
	}

	var mobnumPattern = /^\d+$/;
	if (!mobnumPattern.test(customermobnum)) {
		alert("Customer Mobile Number should contain only numeric values.");
		return false;
	}

	if (customermobnum.length != 10) {
		alert("Customer Mobile Number should have only 10 characters.");
		return false;
	}

	if (customeremail === "") {
		alert("Customer Email cannot be empty");
		return false;
	}

	
	return true;
}

