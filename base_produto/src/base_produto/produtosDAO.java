package base_produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

	public class produtosDAO {
		public void inserirUNI(String cigla, int cod_unidade) {
			String sql = "INSERT INTO unidades(cigla, unidade) VALUES (?,?)";
			try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1, cigla);
				stmt.setInt(2, cod_unidade);
				stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		public void inserirProd(String nome_produto, int quantidade, int cod_unidade, double preco_unitario) {
			String sql = "INSERT INTO produtos(nome_produto, quantidade, cod_unidade, preco_unitario) VALUES (?,?,?,?)";
			try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1, nome_produto);
				stmt.setInt(2, quantidade);
				stmt.setInt(3, cod_unidade);
				stmt.setDouble(4, preco_unitario);
				stmt.executeUpdate();
				System.out.println("Produto inserido com sucesso!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public List<String> listarProd() {
			List<String> prod = new ArrayList<>();
			String sql = "SELECT * FROM produtos";
			try (Connection conn = Conexao.getConnection();
					java.sql.Statement stms = conn.createStatement();
					ResultSet rs = stms.executeQuery(sql)) {
				while (rs.next()) {
					prod.add("id: " + rs.getInt("id_produto") + " - " + "Produto: " + rs.getString("nome_produto") + " - "
							+ "Quantidade: " + rs.getInt("quantidade") + " - " + "Código da unidade: " + rs.getInt("cod_unidade") + " - "
							+ "Preço unitário: " + rs.getDouble("preco_unitario"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Falhas na consulta de produtos! ");
			}
			return prod;
		}

		public List<String> listarUni() {
			List<String> prod = new ArrayList<>();
			String sql = "SELECT * FROM unidades";
			try (Connection conn = Conexao.getConnection();
					java.sql.Statement stms = conn.createStatement();
					ResultSet rs = stms.executeQuery(sql)) {
				while (rs.next()) {
					prod.add("Id: " + rs.getInt("id_unidade") + " - " + "Ciglas: " + rs.getString("cigla") + " - " + "Unidade: " + rs.getInt("unidade"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Falhas na consulta das unidades! ");
			}
			return prod;
		}

		public void atualizarUni(int id_unidade, String novaCigla, int novaUnidade) {
			String sql = "UPDATE unidades SET cigla = ?, unidade = ? WHERE id_unidade = ?";
			try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1, novaCigla);
				stmt.setInt(2, novaUnidade);
				stmt.setInt(3, id_unidade);
				stmt.executeUpdate();
				System.out.println("Unidade atualizada com sucesso!");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Falhas na atualização da unidade!");
			}
		}

		public void atualizarProd(int id_produtos, String nome_produto, int quantidade, int cod_unidade,
				double preco_unitario) {
			String sql = "UPDATE produtos SET nome_produto = ?, quantidade = ?, cod_unidade = ?, preco_unitario = ?  WHERE id_produto = ?";
			try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setString(1, nome_produto);
				stmt.setInt(2, quantidade);
				stmt.setInt(3, cod_unidade);
				stmt.setDouble(4, preco_unitario);
				stmt.setInt(5, id_produtos);
				stmt.executeUpdate();
				System.out.println("Produto atualizada com sucesso!");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Falhas na atualização da Produto!");
			}
		}

		public void deletarUni(int id_unidade) {
			String sql = "DELETE FROM unidades WHERE id_unidade = ?";
			try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, id_unidade);
				stmt.executeUpdate();
				System.out.println("Unidade deletada com sucesso! ");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Falha na exclusão da unidade! ");
			}
		}

		
		public void deletarProd(int id_produtos) {
			String sql = "DELETE FROM produtos WHERE id_produto = ?";
			try (Connection conn = Conexao.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
				stmt.setInt(1, id_produtos);
				stmt.executeUpdate();
				System.out.println("Produto deletado com sucesso! ");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Falha na exclusão do produto! ");
			}
		}
	}
