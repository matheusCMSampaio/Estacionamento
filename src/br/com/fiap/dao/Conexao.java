package br.com.fiap.dao;

import java.sql.*;		//importa todas as classes de java.sql

public class Conexao {
	// método abrindo conexão
	//static - útil para retornar objeto conexao sem criar instancia do mesmo
	public static Connection abrirConexao(){
		Connection con = null;
		try {			
			Class.forName("oracle.jdbc.driver.OracleDriver");	//passando nome da classe de conexão
			
			String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";	//passando endereço do servidor
			
			final String USER = "rm550489";
			final String PASS = "140704";
			
			con = DriverManager.getConnection(url, USER, PASS);		//ABRE CONEXÃO USANDO URL, USER E PASS
			System.out.println("Conexao aberta!");
		}catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;		//retornou objeto de Connection
	}
	//fechando conexão
	public static void fecharConexao(Connection con) {
		try {
			con.close();
			System.out.println("Conexao fechada!");

		} catch (SQLException e) {			//cai nessa exceção se a conexão: estiver fechada, não existir, estiver incorreta.
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}