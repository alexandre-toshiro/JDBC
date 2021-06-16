import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource dataSource;// interface do java que expões as info do pool

	public ConnectionFactory() {

		ComboPooledDataSource comboPool = new ComboPooledDataSource();
		comboPool.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPool.setUser("root");
		comboPool.setPassword("123456");
		
		comboPool.setMaxPoolSize(15);// define o máximo de conexões disponíveis
		// já carrega o pool com 15 conexões disponíveis.

		this.dataSource = comboPool;// Expõe as configuração de conexão.
	}

	public Connection recuperarConexao() throws SQLException {

		return this.dataSource.getConnection(); // retorna a conexão que está disponível no pool de conexões.
	}
}
