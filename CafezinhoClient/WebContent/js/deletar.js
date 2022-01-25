function doDelet(url) {

	let request = new XMLHttpRequest()
	request.open("DELETE",url,true)
	request.send()
	
	request.onload = function(){
		console.log(this.responseText)
	}
	
	return request.responseText
}

function delataUsuario(){

	const urlParams = new URLSearchParams(window.location.search);
	const id = urlParams.get('id');
	console.log(id)
	let url = "http://localhost:8080/Cafezinho/api/cafezinho/excluir/"+id;
	
	doDelet(url)
}


