package br.fiap.usuario;

public class Usuario {
	
	private String nome;
	private String cpf;
	private String tipo;
	
	public Usuario(String nome, String cpf, String tarifa) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.tipo = tarifa;
	}
	
	@Override
	public String toString() {
		String aux = "";
		aux += nome + "Nome: " + "\n";
		aux += cpf + "CPF: " + "\n";
		aux += tipo + "Tipo: " + "\n";
		return aux;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTarifa() {
		return tipo;
	}

	public void setTarifa(String tarifa) {
		this.tipo = tarifa;
	}
	
	
	
	

}
