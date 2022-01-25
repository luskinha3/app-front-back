

function fazGet(url) {
	let request = new XMLHttpRequest()
	request.open("GET",url,false)
	request.send()
	return request.responseText
}

function criaLinha(colaborador) {

	linha = document.createElement("tr");
	
	tdNome = document.createElement("td");
	tdCpf = document.createElement("td");
	tdContribuicao = document.createElement("td");
		
	aEditar = document.createElement("a");
	aRemover = document.createElement("a");
	
	id = colaborador.id_colaborador;
	
	tdNome.innerHTML = colaborador.nome_colaborador;
	tdCpf.innerHTML = colaborador.cpf_colaborador;
	tdContribuicao.innerHTML = colaborador.colaboracao;
	
	aEditar.innerText = 'editar';
	aRemover.innerText = 'remover';
	
	aEditar.href = '../html/editar.html?id='+id;
	aRemover.href = '../html/excluir.html?id=' + id;
	
	 
	
	linha.appendChild(tdNome);
	linha.appendChild(tdCpf);
	linha.appendChild(tdContribuicao);
	linha.appendChild(aEditar);
	linha.appendChild(aRemover);
		
	return linha;
	

}

function main() {

	let data = fazGet("http://localhost:8080/Cafezinho/api/cafezinho/get")
	let usuarios = JSON.parse(data);
	let tabela = document.getElementById("tabela");
	usuarios.forEach(element => {
		let linha = criaLinha(element);
		tabela.appendChild(linha);
	});
	
}

main()