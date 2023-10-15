package br.fiap.form;
import static javax.swing.JOptionPane.*;

import java.util.Random;

import br.fiap.bilheteunico.BilheteUnico;
import br.fiap.dao.BilheteUnicoDAO;
import br.fiap.usuario.Usuario;

import static java.lang.Integer.parseInt;

public class FormAdmin {

	public void menuAdmin() {
		int opcao = 0;
		
		do {
			try {
				opcao = parseInt(showInputDialog(gerarMenuAdmin()));
				switch(opcao) {
				   case 1:
					   emitirBilhete();
					   break;
				   case 2:
					
				}
				
			} catch (NumberFormatException e) {
				showMessageDialog(null, "A opção deve ser um número\n" + e);
			}
			
		} while(opcao != 4);

	}

	private void emitirBilhete() {
		BilheteUnicoDAO dao = new BilheteUnicoDAO();
		Random gerador = new Random();
		String cpf;
		int numero, tipo;
		String nome;
		String opcao[] = {"Estudante", "Professor", "Normal"};
		
		cpf = showInputDialog("CPF do usuário");
		if(dao.pesquisarCPF(cpf) == null) {
			//gerar um numero que não pode ser repetido
			do {
				numero = gerador.nextInt(1000, Integer.MAX_VALUE );
			} while(dao.pesquisarNumero(numero));
			
			nome = showInputDialog("Nome do usuario");
			tipo = showOptionDialog(null, "Tipo de tarifa", "Tarifas: ", 0, 0, null, opcao, opcao[0]);
			
			Usuario usuario = new Usuario(nome, cpf, opcao[tipo]);
			BilheteUnico bilhete = new BilheteUnico(numero, cpf, 0);
			dao.emitir(usuario, bilhete);
			
		} else {
			showMessageDialog(null, "Usuário com bilhete ja cadastrado");
		}

	}

	private String gerarMenuAdmin() {
		String menu = "Escolha uma operação:\n";
		menu += "1. Emitir Bilhete\n";
		menu += "2. Imprimir Bilhete\n";
		menu += "3. Consultar Bilhete\n";
		menu += "4. Sair";
		return menu;
				
	}
	
	
	
	
	
	
}
