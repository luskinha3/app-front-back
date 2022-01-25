package br.com.wl.cafezinho.config;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import br.com.wl.cafezinho.dao.ColaboradorDao;
import br.com.wl.cafezinho.modelo.ColaboradorModelo;

public class Testing {
	
	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException 
	{
		//ColaboradorModelo c = new ColaboradorModelo("juca","123.213.231-14","saco de fava");
		ColaboradorDao cd = new ColaboradorDao();
		//cd.Cadastrar(c);
		List<ColaboradorModelo> lista = cd.listar();
		lista.stream().forEach(System.out::print);
	}

}
