package br.com.wl.cafezinho.config;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBase {
	
	
	public Connection getConexao() throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		 
		Connection conexao = null;
		try 
		{
			conexao = DriverManager.getConnection("jdbc:mysql://exbodcemtop76rnz.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/fn1q0e5065kdncjj", "rdjossin3b8airig", "jomzy05a0e65vb59");
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		return conexao;
	}

}
//
