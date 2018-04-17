package be.vdab.frituurfrida.repositories;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@JdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(JdbcSnackRepository.class)
@Sql("/insertSnack.sql")
public class JdbcSnackRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests{
	private JdbcSnackRepository repository;
	
	private Long getIdVanTestSnack() {
		return super.jdbcTemplate.queryForObject("select id from frituurfrida where naam='test'",Long.class);
	}
	
}
