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
	var adminid = document.getElementById("adminid").value;
	var adminname = document.getElementById("adminname").value;
	var adminpswd = document.getElementById("adminpswd").value;
	var adminmobnum = document.getElementById("adminmobnum").value;
	var adminemail = document.getElementById("adminemail").value;

	var adminidPattern = /^[A-Z0-9]+$/; // Only capital letters and numbers
	if (!adminidPattern.test(adminid)) {
		alert("Admin ID should contain only capital letters and numbers.");
		return false;
	}

	if (adminid.length <= 6) {
		alert("Admin ID should be greater than 6 characters.");
		return false;
	}

	if (adminname === "") {
		alert("Admin Name cannot be empty");
		return false;
	}

	var passwordPattern = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[@#$%^&*!])[A-Za-z\d@#$%^&*!]+$/;
	if (!passwordPattern.test(adminpswd)) {
		alert("Admin Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special symbol (@#$%^&*!)");
		return false;
	}

	if (adminpswd.length <= 6) {
		alert("Admin Password should be greater than 6 characters.");
		return false;
	}

	var mobnumPattern = /^\d+$/;
	if (!mobnumPattern.test(adminmobnum)) {
		alert("Admin Mobile Number should contain only numeric values.");
		return false;
	}

	if (adminmobnum.length != 10) {
		alert("Admin Mobile Number should have only 10 characters.");
		return false;
	}

	if (adminemail === "") {
		alert("Admin Email cannot be empty");
		return false;
	}

	
	return true;
}










