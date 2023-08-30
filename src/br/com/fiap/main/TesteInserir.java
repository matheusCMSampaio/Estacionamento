package br.com.fiap.main;

import java.sql.Connection;

import br.com.fiap.bean.Carro;
import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.Conexao;

public class TesteInserir {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Carro cb = new Carro();
		CarroDAO cd = new CarroDAO(con);

		// TESTEEE

		cb.setPlaca("DDU1323");
		cb.setCor("Vermelho");
		cb.setDescricao("Carro 4");

		System.out.println(cd.inserir(cb));

		// NÃO ESQUECERRRR... DE FECHARR
		Conexao.fecharConexao(con);
	}

}
