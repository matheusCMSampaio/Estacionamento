package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.bean.Cliente;

public class ClienteDAO {
	private Connection con;

	public ClienteDAO(Connection con) {
		this.con = con;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public String inserir(Cliente cliente) {
		String sql = "insert into cliente values (?,?,?)";

		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setInt(1, cliente.getIdCliente());
			ps.setString(2, cliente.getNomeCliente());
			ps.setString(3, cliente.getPlaca());

			if (ps.executeUpdate() > 0) {
				return "Executado com sucesso";
			} else {
				return "Erro ao executar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String alterar(Cliente cliente) {
		String sql = "update cliente set nomeCliente = ?, placa = ? where idCliente = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, cliente.getNomeCliente());
			ps.setString(2, cliente.getPlaca());
			ps.setInt(3, cliente.getIdCliente());

			if (ps.executeUpdate() > 0) {
				return "Atualização com sucesso";
			} else {
				return "Erro ao atualizar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String excluir(Cliente cliente) {
		String sql = "delete from cliente where idcliente = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setInt(1, cliente.getIdCliente());

			if (ps.executeUpdate() > 0) {
				return "Deletado com sucesso";
			} else {
				return "Erro ao deletar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	public ArrayList<Cliente> listarTodos(){
		String sql = "select * from cliente";
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setIdCliente(rs.getInt(1));
					cliente.setNomeCliente(rs.getString(2));
					cliente.setPlaca(rs.getString(3));
				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}
