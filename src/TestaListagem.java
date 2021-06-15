import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFaactory = new ConnectionFactory();
		Connection con = connectionFaactory.recuperarConexao();
		
		PreparedStatement stm = con.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		// select * from, dentro do mundo JAVA é considerado um Statement
		//A conexão com o banco, pode criar um, que devolve uma variavel do mesmo tipo
		//A partir dele podemos recuperar resultados do banco.
		
		
		//boolean resultado = stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		// O STM retorn um booleano, quando for TRUE, retornará uma lista.
		// Quando for um insert, ou um delete que n retorna nada, retornará FALSE.
		
		
		stm.execute();
		ResultSet resultSet = stm.getResultSet();
		// Com o ResultSet conseguimos pegar o conteudo que está dentro da tabela.
		
		//Para trazer os resultados, temos que verificar se "tem um próximo" para isso devemos
		//utilizar um laço.
		while(resultSet.next()) {// O próprio resultSet ja fornece o método next
			Integer id = resultSet.getInt("ID");
			System.out.println(id);
			String nome = resultSet.getString("NOME");
			System.out.println(nome);
			String descricao = resultSet.getString("DESCRICAO");
			System.out.println(descricao);
			System.out.println();
			
			//Dentro do resultSet, utilizando nesse caso o getInt e getString, podemos buscar pelo Index(1, 2, 3) 
			// Ou pelo nome da da própria coluna, o que é mais recomendado, já que deixa o código mais legível.
		}	
		con.close();
	}

}
