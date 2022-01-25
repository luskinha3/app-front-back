# app-front-back
 
ApiRest utilizando bibliotecas do jersey + mysql/ aplicação js/html 

## EndPoints: 

Os EndPoints se encontram na classe controladores, porem a realizão das ações são feitas nas classes DAO

### ListarColaboradores() @GET 
	retorno = arquivo Json com lista de colaboradores do café.
	path = http://localhost:8080/Cafezinho/api/cafezinho/get

### BuscarColaborador(int id) @GET
	recebe = id do colaborador
	retorno = arquivo Json contendo colaborador buscado
	ex = http://localhost:8080/Cafezinho/api/cafezinho/get/1

### DeletarColaborador(int id) @DELETE
	recebe = parametro inteiro indicando id do colaborador a ser deletado
	retorno = true caso cidade seja deletado ou false quando cidade nao seja deletada
	ex = http://localhost:8080/Cafezinho/api/cafezinho/excluir/1

### InserirCidade(String content) @POST
	recebe = arquivo Json contendo as informações para cadastro nome(String), cpf(String), colaboracao(String)
	ex =
	{
		 "nome_colaborador": icaro,
	     "cpf_colaborador": 123.456.789-32,
	     "colaboracao": bolo de cenoura
	}
	retorno = true caso estado seja cadastrado com sucesso e false quando não for possivel cadastrar
	path = http://localhost:8080/Cafezinho/api/cafezinho/inserir

### AtualizarCidade(String Content) @PUT
	recebe = arquivo Json contendo as informações  nome(String), cpf(String), colaboracao(String) do colaborador a ser modificado (obs: id é o identificador para fazer a mudança)
	ex =
	{
		"id_colaborador": 1,
		"nome_colaborador": icaro,
	    "cpf_colaborador": 123.456.789-32,
	    "colaboracao": bolo de chocolate
	}
	retorno = true caso estado seja cadastrado com sucesso e false quando não for possivel cadastrar
	path = http://localhost:8080/WebServiceEC/api/controlador/atualizar/cidades

Observações:
* Cafezinho: api rest
* CafezinhoClient: cliente que utiliza html + js para consumir as informações da api
* testes feitos utilizando postman
* a api só aceita uma contribuição por usuario, me ocupei um pouco com o front pois não utiliza o js a muito tempo,
porem poderia ser implementado inserindo uma lista no modelo e criando mais um tabela no banco que se comunica com chave estrangeira
e realiza a iteração das contribuições do usuario.

Informações do banco:
user: rdjossin3b8airig
senha: jomzy05a0e65vb59
provedor: exbodcemtop76rnz.cbetxkdyhwsb.us-east-1.rds.amazonaws.com
nome do banco: fn1q0e5065kdncjj
