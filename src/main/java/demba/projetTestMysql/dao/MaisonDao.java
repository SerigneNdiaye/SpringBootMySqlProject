package demba.projetTestMysql.dao;

import java.util.List;

import demba.projetTestMysql.model.Maison;

public interface MaisonDao {
	Maison findMaisonByID(long idMaison);
	List<Maison> findAllMaisons();
}
