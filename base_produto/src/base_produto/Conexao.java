package base_produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

	private static final String URL = "jdbc:postgresql://localhost:5432/base_produtos";
	private static final String USER = "postgres";
	private static final String SENHA = "12345678";

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, SENHA);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha na conexão! " + e.getMessage());
			return null;
		}
	}
}


