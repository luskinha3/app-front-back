package br.com.wl.cafezinho.modelo;

public class ColaboradorModelo {
	
	private int id_colaborador;
	private String nome_colaborador;
	private String cpf_colaborador;
	private String colaboracao;
	
	public ColaboradorModelo(int id_colaborador, String nome_colaborador, String cpf_colaborador, String colaboracao){
		this.id_colaborador = id_colaborador;
		this.nome_colaborador = nome_colaborador;
		this.cpf_colaborador = cpf_colaborador;
		this.colaboracao = colaboracao;
	}
	public ColaboradorModelo( String nome_colaborador, String cpf_colaborador, String colaboracao){
		this.nome_colaborador = nome_colaborador;
		this.cpf_colaborador = cpf_colaborador;
		this.colaboracao = colaboracao;
	}
	
	public int getId_colaborador() {
		return id_colaborador;
	}
	public void setId_colaborador(int id_colaborador) {
		this.id_colaborador = id_colaborador;
	}
	public String getNome_colaborador() {
		return nome_colaborador;
	}
	public void setNome_colaborador(String nome_colaborador) {
		this.nome_colaborador = nome_colaborador;
	}
	public String getCpf_colaborador() {
		return cpf_colaborador;
	}
	public void setCpf_colaborador(String cpf_colaborador) {
		this.cpf_colaborador = cpf_colaborador;
	}
	public String getColaboracao() {
		return colaboracao;
	}
	public void setColaboracao(String colaboracao) {
		this.colaboracao = colaboracao;
	}
	
	@Override
	public String toString() 
	{
		return String.format(" %03d | %30s |%15s|%20s  " , this.id_colaborador,this.nome_colaborador, this.cpf_colaborador,this.colaboracao);
	}
	

}
