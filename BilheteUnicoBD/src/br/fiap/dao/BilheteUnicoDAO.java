package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.fiap.bilheteunico.BilheteUnico;
import br.fiap.conexao.Conexao;
import br.fiap.usuario.Usuario;

public class BilheteUnicoDAO {

	private PreparedStatement ps; // configurar o sql que será executado
	private Connection connection; // armazena a conexão estabelecida com o banco de dados
	private ResultSet rs; // armazena o resultado da pesquisa no banco de dados
	private String sql; // utilizada para montar as instruções sql
	
	public BilheteUnicoDAO() {
		connection = new Conexao().conectar();
	}
	
	public BilheteUnico pesquisarCPF(String cpf) {
		BilheteUnico bilhete = null;
		sql = "select * from java_bilhete where cpf = ?";
	
	
	try {
		ps = connection.prepareStatement(sql);
		ps.setString(1, cpf);
		rs = ps.executeQuery();
		if(rs.next()) {
			bilhete = new BilheteUnico(rs.getInt("numero"), rs.getString("cpf"), rs.getDouble("saldo"));
		}
	} catch(SQLException e) {
		System.out.println("Erro ao pesquisar o bilhete pelo cpf \n" + e);
	}
	
	return bilhete;
	}
	
	
	public boolean pesquisarNumero(int numero) {
		boolean aux = false;
		sql = "select numero from java_bilhete where numero = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, numero);
			rs = ps.executeQuery();
			aux = rs.next();
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar o numero\n " + e);
		}
		
		return aux;
	}

	public void emitir(Usuario usuario, BilheteUnico bilhete) {
		sql = "insert into java_bilhete(numero, cpf, saldo, valorPassagem) values(?, ?, ?, ?)";
		
		try {
			new UsuarioDAO().inserir(usuario);
			ps = connection.prepareStatement(sql);
			ps.setInt(1, bilhete.getNumero());
			ps.setString(2, bilhete.getCpfUsuario());
			ps.setDouble(3, bilhete.getSaldo());
			ps.setDouble(4, bilhete.getValorDaPassagem());
			ps.execute();
		} catch(SQLException e) {
			System.out.println("Erro ao emitir o bilhete\n" + e);
		}
		
		
		
		
	}
	
	public boolean delete(int numero) {
		boolean aux = false;
		sql = "delete numero from java_bilhete where numero = ?";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, numero);
			rs = ps.executeQuery();
			aux = rs.next();
		} catch (SQLException e) {
			System.out.println("Erro ao deletar o numero\n   " + e);
		}
		
		return aux;
	
	}
	
}
