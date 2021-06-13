import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection recuperarConexao() throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC",
				"root", "123456");
		//abstraindo a criaçõ de conex]ao para uma classe a parte.
	}

}
