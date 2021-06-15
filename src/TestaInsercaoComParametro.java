import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		connection.setAutoCommit(false);// JDBC n controla mais a transa��o.Devemos fazer o controle

		try {
			PreparedStatement stm = connection.prepareStatement // Passamos a responsabilidade para o JDBC
			("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES(?,?)", // os par�metros s�o interroga��es
					Statement.RETURN_GENERATED_KEYS);

			adicionarVariavel("SmartTV", "45 polegadas", stm);
			adicionarVariavel("Radio", "Radio da bateria", stm);

			connection.commit();
			stm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ROLLBACK EXECUTADO");
			connection.rollback();
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);// seta no 1� atributo a variavel nome
		stm.setString(2, descricao);

		if(nome.equals("Radio")) {
			throw new RuntimeException("N�o foi poss�vel adicionar o produto");
		}

		stm.execute();

		ResultSet rst = stm.getGeneratedKeys();

		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O ID criado foi: " + id);
		}
		rst.close();

		// dessa forma evitamos erros de compila��o/interpreta��o caso o usu�rio insira
		// aspas simples, sql injection
	}

}
