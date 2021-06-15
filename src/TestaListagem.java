import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFaactory = new ConnectionFactory();
		Connection con = connectionFaactory.recuperarConexao();
		
		PreparedStatement stm = con.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		// select * from, dentro do mundo JAVA � considerado um Statement
		//A conex�o com o banco, pode criar um, que devolve uma variavel do mesmo tipo
		//A partir dele podemos recuperar resultados do banco.
		
		
		//boolean resultado = stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		// O STM retorn um booleano, quando for TRUE, retornar� uma lista.
		// Quando for um insert, ou um delete que n retorna nada, retornar� FALSE.
		
		
		stm.execute();
		ResultSet resultSet = stm.getResultSet();
		// Com o ResultSet conseguimos pegar o conteudo que est� dentro da tabela.
		
		//Para trazer os resultados, temos que verificar se "tem um pr�ximo" para isso devemos
		//utilizar um la�o.
		while(resultSet.next()) {// O pr�prio resultSet ja fornece o m�todo next
			Integer id = resultSet.getInt("ID");
			System.out.println(id);
			String nome = resultSet.getString("NOME");
			System.out.println(nome);
			String descricao = resultSet.getString("DESCRICAO");
			System.out.println(descricao);
			System.out.println();
			
			//Dentro do resultSet, utilizando nesse caso o getInt e getString, podemos buscar pelo Index(1, 2, 3) 
			// Ou pelo nome da da pr�pria coluna, o que � mais recomendado, j� que deixa o c�digo mais leg�vel.
		}	
		con.close();
	}

}
