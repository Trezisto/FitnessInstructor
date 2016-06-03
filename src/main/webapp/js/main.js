function register(){
	var username = $('#usernameRegister').val();
	var password = $('#passRegister').val();
	var credentials = {
			username: username,
			password: password
	};
	var errorMsg;
	if(isEmpty(username) || !isValid(username)){
		errorMsg = "Please enter a valid username.";
	} else {
		if(isEmpty(password) || !isValid(password)){
			errorMsg = "Please enter a valid password.";
		}
	}
	
	if(isEmpty(errorMsg)){
		console.log(JSON.stringify(credentials));
		loginValidation.css('visibility','hidden');
		$.ajax({
			type: 'POST',
			url: '/register',
			data: JSON.stringify(credentials), //what send to server
			contentType: 'application/json',
			success: function(data) {
				console.log('Credentials sent to register!');
			},
			error:function(data,status,er) {
				console.log('error');
			}		
		});
		errorMsg = "User was registered successfully.";
		var registerValidation = $("#validationSignUp");
		registerValidation.text(errorMsg); 
		if(registerValidation.css('visibility') != 'visible')
			registerValidation.css('visibility','visible');
	} else {
		var registerValidation = $("#validationSignUp");
		registerValidation.text(errorMsg); 
		if(registerValidation.css('visibility') != 'visible')
			registerValidation.css('visibility','visible');
	}
}

function login(){
	var username = $('#usernameLogin').val();
	console.log(username);
	var password = $('#passLogin').val();
	console.log(password);
	var credentials = {
		username: username,
		password: password
	};
	var errorMsg;
	if(isEmpty(username) || !isValid(username)){
		errorMsg = "Please enter a valid username.";
	} else {
		if(isEmpty(password) || !isValid(password)){
			errorMsg = "Please enter a valid password.";
		}
	}
	
	if(isEmpty(errorMsg)){
		console.log(JSON.stringify(credentials));
		loginValidation.css('visibility','hidden');
		$.ajax({
			type: 'POST',
			url: '/login',
			data: JSON.stringify(credentials), //what send to server
			contentType: 'application/json',
			success: function(data) {
				console.log('Credentials sent to login!');
			},
			error:function(data,status,er) {
				console.log('error');
			}		
		});
	} else {
		var loginValidation = $("#validationLogIn");
		loginValidation.text(errorMsg); 
		if(loginValidation.css('visibility') != 'visible')
			loginValidation.css('visibility','visible');
	}
}

function isEmpty(str) {
    return (!str || 0 === str.length || !str.trim());
}

function isValid(str) {
	return /^[a-zA-Z0-9_-]{3,15}$/.test(str);
}
