package demba.projetTestMysql.dao;

import java.util.List;

import demba.projetTestMysql.model.Personne;

public interface PersonneDao {

	Personne findPersonneByID(Long id);  
	List<Personne> findAllPersonnes() ;
	
	//int savePersonne(String nom, String prenom, String telephone);
	
	//long savePersonne(Personne personne);
	
	void savePersonne(Personne personne);
	
	int updatePersonne(Personne personne);
	
	int deletePersonne(Long id);
	
	List<Personne> searchPerson(String query);

}