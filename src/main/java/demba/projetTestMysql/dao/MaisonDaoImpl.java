package demba.projetTestMysql.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import demba.projetTestMysql.model.Maison;

@Repository
public class MaisonDaoImpl implements MaisonDao {
	
	static RowMapper<Maison> rowMapperMaison = (rs, nr) -> {
		Maison maison = new Maison();
		maison.setIdMaison(rs.getInt("idMaison"));
		maison.setAdresse(rs.getString("adresse"));
		maison.setSuperficie(rs.getString("superficie"));
		return maison;
	};
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Maison findMaisonByID(long idMaison) {
		String requeteSQL = "select* from maison where idMaison = ?;";
		return jdbcTemplate.queryForObject(requeteSQL, new Object[] {idMaison}, rowMapperMaison);
	}

	@Override
	public List<Maison> findAllMaisons() {
		return jdbcTemplate.query("select* from maison;", rowMapperMaison);
	}

}
