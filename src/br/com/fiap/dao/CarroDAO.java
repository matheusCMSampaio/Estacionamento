package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.bean.Carro;

public class CarroDAO {
	private Connection con;

	// construtor - obriga usuário passar uma conexão para acessar
	public CarroDAO(Connection con) {
		this.con = con;
	}
	// gets e sets

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	// métodos
	// inserir valores na tabela
	public String inserir(Carro carro) {
		String sql = "insert into carro(placa,cor,descricao) values(?,?,?)"; // valores serão preenchidos posteriormente
		try {
			PreparedStatement ps = getCon().prepareStatement(sql); // prepara o comando sql acima, dizendo quem são as
																	// ???
			// insere os valores (serão obtidos por passagem de parâmetro)
			ps.setString(1, carro.getPlaca());
			ps.setString(2, carro.getCor());
			ps.setString(3, carro.getDescricao());
			// Se o método execute, que retorna o nr de linhas afetadas, retornar maior que
			// 0.
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String alterar(Carro carro) {
		String sql = "update carro "; // valores serão preenchidos posteriormente
		sql += "set cor = ?, descricao = ? ";
		sql += "where placa = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql); // prepara o comando sql acima, dizendo quem são as
																	// ???
			// insere os valores (serão obtidos por passagem de parâmetro)
			ps.setString(1, carro.getCor());
			ps.setString(2, carro.getDescricao());
			ps.setString(3, carro.getPlaca());
			// Se o método execute, que retorna o nr de linhas afetadas, retornar maior que
			// 0.
			if (ps.executeUpdate() > 0) {
				return "Atualização com sucesso";
			} else {
				return "Erro ao atualizar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String excluir(Carro carro) {
		String sql = "delete from carro where placa = ?"; // valores serão preenchidos posteriormente

		try {
			PreparedStatement ps = getCon().prepareStatement(sql); // prepara o comando sql acima, dizendo quem são as
																	// ???
			// insere os valores (serão obtidos por passagem de parâmetro)
			ps.setString(1, carro.getPlaca());

			// Se o método execute, que retorna o nr de linhas afetadas, retornar maior que
			// 0.
			if (ps.executeUpdate() > 0) {
				return "Deletado com sucesso";
			} else {
				return "Erro ao deletar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public ArrayList<Carro> listarTodos() {
		String sql = "Select * from carro";
		ArrayList<Carro> listaCarro = new ArrayList<Carro>();

		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Carro cb = new Carro();
					cb.setPlaca(rs.getString(1));
					cb.setCor(rs.getString(2));
					cb.setDescricao(rs.getString(3));
					listaCarro.add(cb);
				}
				return listaCarro;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

}