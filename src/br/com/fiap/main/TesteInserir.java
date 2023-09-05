package br.com.fiap.main;

import java.sql.Connection;

import br.com.fiap.bean.Carro;
import br.com.fiap.bean.Cliente;
import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.Conexao;

public class TesteInserir {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Carro cb = new Carro();
		CarroDAO cd = new CarroDAO(con);
		Cliente cliente = new Cliente();
		ClienteDAO clientedao = new ClienteDAO(con);
		// TESTEEE
		
		cliente.setIdCliente(1);
		cliente.setNomeCliente("Matheus");
		cliente.setPlaca("DDU1323");
		
		cb.setPlaca("DDU1323");
		cb.setCor("Vermelho");
		cb.setDescricao("Carro 4");
		
		

		System.out.println(clientedao.inserir(cliente));

		// NÃO ESQUECERRRR... DE FECHARR
		Conexao.fecharConexao(con);
	}

}
