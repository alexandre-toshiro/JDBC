
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import modelo.Produto;

public class TestaInsercaoComProduto {

	public static void main(String[] args) throws SQLException {
		Produto comoda = new Produto("Comoda", "Comoda Vertical");

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO dao = new ProdutoDAO(connection);
			dao.salvar(comoda);
			List<Produto> listaProdutos = dao.listar();
			
			for (Produto produto : listaProdutos) {
				System.out.println(produto);
			}
		}
	}
}
