function login(){
	var username = $('#usernameLogin').val();
	console.log(username);
	var password = $('#passLogin').val();
	console.log(password);
	var credentials = {
		username: username,
		password: password
	};
	console.log(JSON.stringify(credentials));
	$.ajax({
		type: 'POST',
		url: '/login',
		data: JSON.stringify(credentials), //what send to server
		contentType: 'application/json',
		success: function(data) {
			console.log('Credentials sent!');
		},
		error:function(data,status,er) {
			console.log('error');
		}		
	});
}

