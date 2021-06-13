import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
	public static void main(String[] args) throws SQLException {

		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();

		Statement stm = connection.createStatement();
		stm.execute("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES('MOUSE', 'MOUSE SEM FIO')",
				Statement.RETURN_GENERATED_KEYS);
		// Vimos anteriormente que o "execute" retorna uma boolean, sendo true quando retorna uma lista
		//Porém no INSERT isso não faz sentido para nós, sendo melhor, por exemplo, que ele retorn o número do ID
		//Gerado pelo novo produto, então APÓS a query, passamos um novo parâmetro, do próprio statement
		//que retorna esse key.

		ResultSet rst = stm.getGeneratedKeys();
		//Aqui pegamos esse key retornada, que também devolve um resultSet.
		
		while(rst.next()) {//Fazmos o laço para saber qual ID foi gerado.
			Integer id = rst.getInt(1);//Utilizando o index.
			System.out.println("O ID criado foi: " + id);
		}
	}

}
