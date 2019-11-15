package demba.projetTestMysql.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;

import com.zaxxer.hikari.util.DriverDataSource;

import demba.projetTestMysql.model.Personne;

@Repository
public class PersonneDaoImpl implements PersonneDao {
	
	private Logger logger = LoggerFactory.getLogger(Logger.class);
	
	static RowMapper<Personne> rm = (rs, rowNum) -> {
		Personne personne = new Personne();
		personne.setIdPersonne(rs.getLong("idPersonne"));
		personne.setNom(rs.getString("nom"));
		personne.setPrenom(rs.getString("prenom"));
		personne.setTelephone(rs.getString("telephone"));
		return personne;
	};
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private SimpleJdbcInsert simpleJdbcInsert;
	
	
	
	public PersonneDaoImpl(DataSource dataSource) {
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("personne").usingGeneratedKeyColumns("idPersonne");
	}

	@Override
	public Personne findPersonneByID(Long idPersoone) { // ... A revoir si l id n existe pas
		return jdbcTemplate.queryForObject("select* from personne where idPersonne=?;", new Object[] {idPersoone}, rm); //Si la personne n est pas trouvee une exception runtime sera lancee (c est pourquoi pas de throws ni try catch)
		
		//return jdbcTemplate.query("select* from personne where idPersonne=?;", new Object[] {idPersoone}, rm); //.... return list personne
		
		//return jdbcTemplate.queryForObject("select* from personne where id=?;", new Object[] {id}, new PersonneRowMapper());
	}

	@Override
	public List<Personne> findAllPersonnes() {
		return jdbcTemplate.query("select* from personne;", rm); 
	}
	
	@Override
	public List<Personne> searchPerson(String query) { //.... A completer (personnes : concat; une seule personne -recherche par id-)
		List<Personne> lstPersons = new ArrayList<>();
		
		String[] queryWithoutBlank = query.split(" ");
		List<String> queryTokens = Arrays.asList(queryWithoutBlank);
		
		List<Personne> persons = new ArrayList<>();
		int taille = queryTokens.size();
		switch(taille) {
			case 1: {
				String token = queryTokens.get(0);
				if(isNombre(token)) { // StringUtils.isNumeric(token)
					lstPersons.add(findPersonneByID(Long.parseLong(queryTokens.get(0))));
				} else {
					persons = jdbcTemplate.query("select* from personne where nom=? OR prenom=? or telephone=?", new Object[] {token, token, token}, rm);
					lstPersons.addAll(persons);
				}
			}
			break;
			case 2: {
					List<String> lstTokens = new ArrayList<>();
					for(String queryToken : queryTokens) {
						if(isNombre(queryToken)) { 
							lstPersons.add(findPersonneByID(Long.parseLong(queryToken)));
						}
						else { // ... A completer : combinaison avec telephone
							lstTokens.add(queryToken);
							//continue;
						}
					}
					
					if(lstTokens.size() == 2) {
						String token0 = lstTokens.get(0);
						String token1 = lstTokens.get(1);
						 persons = jdbcTemplate.query("select* from personne where (nom=? AND prenom=?) OR (prenom=? AND nom=?);", new Object[] {token0, token1, token0, token1}, rm);
						 lstPersons.addAll(persons);
					}
			}
			break;
			case 3: {
				
			}
			break;
			case 4 : {
				
			}
			break;
		}
		
		/*if(!CollectionUtils.isEmpty(queryTokens)) {
			for(String queryToken : queryTokens) {
				List<Personne> persons = jdbcTemplate.query("select* from personne where nom=? OR prenom=? or telephone=?", new Object[] {queryToken, queryToken, queryToken}, rm);
				lstPersons.addAll(persons);
			}
		}*/
		
		return lstPersons;
	}

	/*@Override
	public int savePersonne(String nom, String prenom, String telephone) {
		try {
			return jdbcTemplate.update("insert into personne(nom, prenom, telephone) values(?, ?, ?);",
					new Object[] {nom, prenom, telephone}, 
					new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR});
		} catch(DataAccessException dae) {
			logger.error("Probleme d insertion");
		}
		return -1;
	}*/

	@Override
	//public long savePersonne(Personne personne) {
    public void savePersonne(Personne personne) {	
		/*return jdbcTemplate.update("insert into personne(nom, prenom, telephone) values(?, ?, ?);", 
				new Object[] {personne.getNom(), personne.getPrenom(), personne.getTelephone()}, 
				new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR});*/
		
		Map<String, Object> parametresPersonne = new HashMap<>();
		parametresPersonne.put("nom", personne.getNom());
		parametresPersonne.put("prenom", personne.getPrenom());
		parametresPersonne.put("telephone", personne.getTelephone());
		
		Number idPersonne = simpleJdbcInsert.executeAndReturnKey(parametresPersonne);
		
		personne.setIdPersonne(idPersonne.longValue());
		
		//return idPersonne.longValue();
	}

	@Override
	public int updatePersonne(Personne personne) {
		//test
		System.out.println("\nIDPersonne Loadee : " + personne.getIdPersonne());
		
		return jdbcTemplate.update("UPDATE personne SET nom=?, prenom=?, telephone=? where idPersonne=?", 
				new Object[] {personne.getNom(), personne.getPrenom(), personne.getTelephone(), personne.getIdPersonne()},
				new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.BIGINT});
	}

	@Override
	public int deletePersonne(Long id) {
		return jdbcTemplate.update("DELETE from personne where idPersonne=?", 
				new Object[] {id},
				new int[] {Types.BIGINT});		
	}
	
	
	private boolean isNombre(String chaine) {
		return chaine != null && chaine.matches("[0-9]+");
	}


}

//class PersonneRowMapper implements RowMapper<Personne>{
//
//	@Override
//	public Personne mapRow(ResultSet rs, int rowNum) throws SQLException {
//		Personne personne = new Personne();
//		personne.setId(rs.getLong("id"));
//		personne.setNom(rs.getString("nom"));
//		personne.setPrenom(rs.getString("prenom"));
//		personne.setTelephone(rs.getString("telephone"));
//		return personne;
//		//return new Personne(rs.getLong("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("telephone"));
//	}
//	
//}
