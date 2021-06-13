import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
	
	public static void main(String[] args) throws SQLException {
		String nome = "Mouse";
		String descricao = "Mouse sem fio";
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();

		PreparedStatement stm = connection.prepareStatement // Passamos a responsabilidade para o JDBC
				("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES(?,?)",// os par�metros s�o interroga��es
				Statement.RETURN_GENERATED_KEYS);
		
		stm.setString(1, nome);//seta no 1� atributo a variavel nome
		stm.setString(2, descricao);
		
		stm.execute();

		ResultSet rst = stm.getGeneratedKeys();
		
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O ID criado foi: " + id);
		}
		
		//dessa forma evitamos erros de compila��o/interpreta��o caso o usu�rio insira aspas simples, sql injection
	}

}
