package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.fiap.conexao.Conexao;
import br.fiap.usuario.Usuario;

public class UsuarioDAO {

	private PreparedStatement ps; // configurar o sql que será executado
	private Connection connection; // armazena a conexão estabelecida com o banco de dados
	private ResultSet rs; // armazena o resultado da pesquisa no banco de dados
	private String sql; // utilizada para montar as instruções sql
	
	public UsuarioDAO() {
		connection = new Conexao().conectar();
	}
	
	public void inserir(Usuario usuario) {
		sql = "insert into java_usuario(nome, cpf, tipo) = (?, ?, ?)";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getCpf());
			ps.setString(3, usuario.getTarifa());
			ps.execute();
			
		} catch (SQLException e) {
        System.out.println("Erro ao inserir dados do usuario" + e);
		}
		
	}
}
