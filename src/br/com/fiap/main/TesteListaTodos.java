package br.com.fiap.main;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.fiap.bean.Carro;
import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.Conexao;

public class TesteListaTodos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = Conexao.abrirConexao();
		CarroDAO cd = new CarroDAO(con);

		ArrayList<Carro> lista = cd.listarTodos();

		if (lista != null) {
			for (var carro : lista) {
				System.out.println("Placa: " + carro.getPlaca());
				System.out.println("Cor: " + carro.getCor());
				System.out.println("Descricao: " + carro.getDescricao() + "\n");
			}
		}

		Conexao.fecharConexao(con);
	}

}
