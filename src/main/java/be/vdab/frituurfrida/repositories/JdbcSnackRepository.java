package be.vdab.frituurfrida.repositories;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import be.vdab.frituurfrida.entities.Snack;
import be.vdab.frituurfrida.exceptions.SnackNietGevondenException;

@Repository
public class JdbcSnackRepository implements SnackRepository {
	private NamedParameterJdbcTemplate template;
	private final RowMapper<Snack> snackRowMapper = (resultSet,rowNum) -> 
		new Snack(resultSet.getLong("id"),resultSet.getString("naam"),resultSet.getBigDecimal("prijs"));
	private static final String READ = "select id, naam, prijs from snacks where id=:id";
	private static final String UPDATE = "update snacks set naam=:naam, prijs=:prijs where id=:id";
	private static final String SELECT_BY_NAAM = "select id, naam, prijs from snacks where naam=:naam";
	
	public JdbcSnackRepository(NamedParameterJdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public Optional<Snack> read(long id) {
		try {
			return Optional.of(template.queryForObject(READ, Collections.singletonMap("id",id),snackRowMapper));
		} catch (IncorrectResultSizeDataAccessException ex) {
			return Optional.empty();
		}
	}

	@Override
	public void update(Snack snack) {
		Map<String,Object> parameters = new HashMap<>();
		parameters.put("id",snack.getId());
		parameters.put("naam",snack.getNaam());
		parameters.put("prijs",snack.getPrijs());
		if (template.update(UPDATE,parameters) == 0) {
			throw new SnackNietGevondenException();
		};
	}

	@Override
	public List<Snack> findByNaam(String naam) {
		return template.query(SELECT_BY_NAAM, Collections.singletonMap("naam",naam),snackRowMapper);
	}
}
