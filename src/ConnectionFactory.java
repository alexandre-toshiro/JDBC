import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource dataSource;// interface do java que exp�es as info do pool

	public ConnectionFactory() {

		ComboPooledDataSource comboPool = new ComboPooledDataSource();
		comboPool.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPool.setUser("root");
		comboPool.setPassword("123456");
		
		comboPool.setMaxPoolSize(15);// define o m�ximo de conex�es dispon�veis
		// j� carrega o pool com 15 conex�es dispon�veis.

		this.dataSource = comboPool;// Exp�e as configura��o de conex�o.
	}

	public Connection recuperarConexao() throws SQLException {

		return this.dataSource.getConnection(); // retorna a conex�o que est� dispon�vel no pool de conex�es.
	}
}
