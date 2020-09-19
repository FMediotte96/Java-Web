function revisar() {
	var input_pass = document.getElementById('password');
	var input_pass2 = document.getElementById('password2');
	
	if(input_pass.value != input_pass2.value) {
		document.getElementById("info").innerHTML = 'Las claves no coinciden';
	} else {
		document.getElementById("info").innerHTML = 'Las claves coinciden';
	}
}

function cifrar() {
	var input_pass = document.getElementById('password');
	var input_pass2 = document.getElementById('password2');
	
	input_pass.value = hex_md5(input_pass.value);
	input_pass2.value = hex_md5(input_pass2.value);
}