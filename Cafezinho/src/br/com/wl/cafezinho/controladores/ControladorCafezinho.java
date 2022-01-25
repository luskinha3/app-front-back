package br.com.wl.cafezinho.controladores;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import br.com.wl.cafezinho.dao.ColaboradorDao;
import br.com.wl.cafezinho.modelo.ColaboradorModelo;

@Path ("cafezinho")
public class ControladorCafezinho {
	@GET
    @Produces("application/json")
	@Path("get")
    public String ListarColaboradores() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException {
        ColaboradorDao cd = new ColaboradorDao();
        List<ColaboradorModelo> colaboradores = cd.listar();    
        Gson gson = new Gson();
        return gson.toJson(colaboradores);
	}
	
	@GET
	@Produces("application/json")
	@Path("get/{id}")
	public String BuscarColaborador (@PathParam ("id") int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException {
		
		ColaboradorDao colaboradorDao = new ColaboradorDao();
        ColaboradorModelo colaborador = colaboradorDao.BuscarCidade(id);
        Gson gson = new Gson();
        return gson.toJson(colaborador);
	}
	
	
	@DELETE
	@Path ("excluir/{id}")
	public boolean DeletarColaborador (@PathParam ("id") int id) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, URISyntaxException {
		ColaboradorDao cd = new ColaboradorDao();
		if(cd.deletar(id)) 
		{
			return true;
		};
		return false;
	}
	

	@POST
	@Consumes("application/json")
	@Path ("inserir")
	public boolean InserirColaborador (String content) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, URISyntaxException {
		Gson g = new Gson();
		ColaboradorModelo e = (ColaboradorModelo) g.fromJson(content, ColaboradorModelo.class);
		ColaboradorDao dao = new ColaboradorDao();
		if (dao.Cadastrar(e)) 
		{
			return true;
		};
		return false;
	}
	
	
	@PUT
	@Consumes("application/json")
	@Path("atualizar")
	public boolean AtualizarCidade (String content) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException 
	{
		Gson g = new Gson();
		ColaboradorModelo cm = (ColaboradorModelo) g.fromJson(content, ColaboradorModelo.class);
		ColaboradorDao cDao = new ColaboradorDao();
		if (cDao.Atualizar(cm)) 
		{
			return true;
		};
		return false;
	}
	
	
}
