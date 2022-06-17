/**
 * validar os campos obrigatórios
 */
 
/** function validar(){
	let matricula = frmCadastro.id.value;
	let matricula = frmCadastro.nome.value;
	let matricula = frmCadastro.email.value;
	
	if(matricula === ""){
		alert('Preencha o campo Matricula!')
		formCadastro.id.focus()	
		return false
	} else if (nome === ""){
		alert('Preencha o campo Nome!')
		formCadastro.nome.focus()
		return false
	} else if (email === ""){
		alert('Preencha o campo E-mail!')
		formCadastro.email.focus()
		return false
	} else {
		document.forms["formCadastro"].submit()
	}
	
}

*/

 function validar(){
	let matricula = frmCadastro.id.value;
	let nome = frmCadastro.nome.value;
	let email= frmCadastro.email.value;
	
	if(matricula === ""){
		alert('Preencha o campo Matricula!')
		frmCadastro.id.focus()
		return false
	}else if(nome === ""){
		alert('Preencha o campo Nome!')
		frmCadastro.nome.focus()
		return false
	}else if(email === ""){
		alert('Preencha o campo E-mail!')
		frmCadastro.email.focus()
		return false
	}else {
		document.forms["frmCadastro"].submit()
	}	
}