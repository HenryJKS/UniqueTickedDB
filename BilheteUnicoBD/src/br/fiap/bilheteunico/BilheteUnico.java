package br.fiap.bilheteunico;

public class BilheteUnico {
	
	private int numero;
	private String cpfUsuario;
	private double saldo;
	public static double valorDaPassagem = 4.40;
	
	public BilheteUnico(String cpfUsuario) {
		super();
		this.cpfUsuario = cpfUsuario;
	}
	
	

	public BilheteUnico(int numero, String cpfUsuario, double saldo) {
		super();
		this.numero = numero;
		this.cpfUsuario = cpfUsuario;
		this.saldo = saldo;
	}



	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCpfUsuario() {
		return cpfUsuario;
	}

	public void setCpfUsuario(String cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public static double getValorDaPassagem() {
		return valorDaPassagem;
	}

	public static void setValorDaPassagem(double valorDaPassagem) {
		BilheteUnico.valorDaPassagem = valorDaPassagem;
	}

	public void passarNaCatraca() {
		
	}
	
	public void carregarBilhete(double valor) {
		
	}
	
	
	
	
	

}
