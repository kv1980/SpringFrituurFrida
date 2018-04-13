package be.vdab.frituurfrida.repositories;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@JdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class DataSourceTest {
	@Autowired
	private DataSource datasource;
	
	@Test
	public void getConnection() throws SQLException {
		try (Connection connection = datasource.getConnection()){
		}
	}
}