function doPost(url,body) {
	console.log(body)
	let request = new XMLHttpRequest()
	request.open("POST",url,true)
	request.setRequestHeader("Content-type", "application/json")
	request.send(JSON.stringify(body))
	
	request.onload = function(){
		console.log(this.responseText)
	}
	
}

function cadastroUsuario() {
	event.preventDefault()
	let url = "http://localhost:8080/Cafezinho/api/cafezinho/inserir"
	let nome = document.getElementById("nome").value
	let cpf = document.getElementById("cpf").value
	let contribuicao = document.getElementById("contribuicao").value
	
	body = {
		 "nome_colaborador": nome,
	     "cpf_colaborador": cpf,
	     "colaboracao": contribuicao
	}
	
	doPost(url,body)
}