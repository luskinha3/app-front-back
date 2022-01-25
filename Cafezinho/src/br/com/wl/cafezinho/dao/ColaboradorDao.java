package br.com.wl.cafezinho.dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import br.com.wl.cafezinho.config.ConnectionDataBase;
import br.com.wl.cafezinho.modelo.ColaboradorModelo;


public class ColaboradorDao {
	
	private ConnectionDataBase  conection; 
	private Connection con ;
	
	
	
	public ColaboradorDao() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException 
	{
		this.conection = new ConnectionDataBase();
		this.con = conection.getConexao();
	}
	
	
	public boolean Cadastrar(ColaboradorModelo colaborador) throws SQLException 
	{
			
		con.setAutoCommit(false);
		try (PreparedStatement pst = con.prepareStatement("INSERT INTO colaboradores (nome_colaborador,cpf_colaborador,colaboracao) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS))
		{
			pst.setString(1, colaborador.getNome_colaborador());
			pst.setString(2, colaborador.getCpf_colaborador());
			pst.setString(3, colaborador.getColaboracao());
			pst.execute();
				
			con.commit();
			return true;
			
		}
		catch (Exception e) {
			e.getStackTrace();
			con.rollback();
			return false;
		}
	}

	public List<ColaboradorModelo> listar() throws SQLException 
	{
		
		 List<ColaboradorModelo> colaboradores = new  ArrayList<ColaboradorModelo>();
		 
		 try (PreparedStatement pst = con.prepareStatement("SELECT id_colaborador,nome_colaborador,cpf_colaborador,colaboracao FROM colaboradores"))
		{
			pst.execute();		
			try (ResultSet rst = pst.getResultSet())
			{			
				while(rst.next()) 
				{						
					ColaboradorModelo colaborador = new ColaboradorModelo(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4));
					colaboradores.add(colaborador);							
				}
			}
		}
		 
		 return colaboradores;
		 
	}
	
	public boolean deletar(int id) throws SQLException 
	{
		try (PreparedStatement pst = con.prepareStatement("DELETE FROM colaboradores WHERE id_colaborador = ?", Statement.RETURN_GENERATED_KEYS))
		{
			pst.setInt(1, id );
			pst.execute();
			
			return true;
		}
		
	}
	
	
	public boolean Atualizar (ColaboradorModelo colaborador) throws SQLException 
	{
		try (PreparedStatement pst = con.prepareStatement("UPDATE colaboradores SET nome_colaborador=?,cpf_colaborador=?,colaboracao=? WHERE id_colaborador = ?", Statement.RETURN_GENERATED_KEYS))
		{
			
			pst.setString(1, colaborador.getNome_colaborador());
			pst.setString(2, colaborador.getCpf_colaborador());
			pst.setString(3, colaborador.getColaboracao());
			pst.setInt(4, colaborador.getId_colaborador());
			pst.execute();
			
			return true;
		}
	}


	public ColaboradorModelo BuscarCidade(int id) throws SQLException {
		ColaboradorModelo colaborador = null;
		 try (PreparedStatement pst = con.prepareStatement("SELECT id_colaborador,nome_colaborador,cpf_colaborador,colaboracao FROM colaboradores where id_colaborador = ?"))
			{
			 	pst.setInt(1, id);
				pst.execute();
				
				try (ResultSet rst = pst.getResultSet())
				{			
					while(rst.next()) 
					{						
						colaborador = new ColaboradorModelo(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4));			
					}
				}
			}
		 return colaborador;
	}
	
}
