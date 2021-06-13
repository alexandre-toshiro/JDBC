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
		//Por�m no INSERT isso n�o faz sentido para n�s, sendo melhor, por exemplo, que ele retorn o n�mero do ID
		//Gerado pelo novo produto, ent�o AP�S a query, passamos um novo par�metro, do pr�prio statement
		//que retorna esse key.

		ResultSet rst = stm.getGeneratedKeys();
		//Aqui pegamos esse key retornada, que tamb�m devolve um resultSet.
		
		while(rst.next()) {//Fazmos o la�o para saber qual ID foi gerado.
			Integer id = rst.getInt(1);//Utilizando o index.
			System.out.println("O ID criado foi: " + id);
		}
	}

}
