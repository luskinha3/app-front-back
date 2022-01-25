function doPut(url,body) {
	console.log('body')
	let request = new XMLHttpRequest()
	request.open("PUT",url,true)
	request.setRequestHeader("Content-type", "application/json")
	request.send(JSON.stringify(body))
	
	request.onload = function(){
		console.log(this.responseText)
	}
	
	return request.responseText
}

function fazGet(url) {
	let request = new XMLHttpRequest()
	request.open("GET",url,false)
	request.send()
	return request.responseText
}

function editaUsuario() {

	event.preventDefault()
	const urlParams = new URLSearchParams(window.location.search);
	const id = urlParams.get('id');
	let url = "http://localhost:8080/Cafezinho/api/cafezinho/atualizar"
	let nome = document.getElementById("nome").value
	let cpf = document.getElementById("cpf").value
	let contribuicao = document.getElementById("contribuicao").value
	
	body = {
		 "id_colaborador": id,
		 "nome_colaborador": nome,
	     "cpf_colaborador": cpf,
	     "colaboracao": contribuicao
	}
	
	doPut(url,body)
}


window.onload = function doGetColab(){
	const urlParams = new URLSearchParams(window.location.search);
	const id = urlParams.get('id');
	let data = fazGet("http://localhost:8080/Cafezinho/api/cafezinho/get/"+id)
	let colaborador = JSON.parse(data);
	document.getElementById("nome").value = colaborador.nome_colaborador;
	document.getElementById("cpf").value = colaborador.cpf_colaborador;
	document.getElementById("contribuicao").value = colaborador.colaboracao ;
	
}


