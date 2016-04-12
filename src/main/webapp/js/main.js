function login(){
	var email = $('#emailLogin');
	var password = $('#passLogin');
	
	var credentials = {
		email: email,
		password: password
	};
	
	$.ajax({
		type: 'POST',
		url: 'login',
		data: JSON.stringify(credentials), //what send to server
		contentType: 'application/json',
		success: function(data) {
				alert('Credentials sent!');
		},
		error:function(data,status,er) {
			alert('error');
		}		
	});
}

