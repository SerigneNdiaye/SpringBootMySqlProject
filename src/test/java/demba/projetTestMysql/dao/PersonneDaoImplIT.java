package demba.projetTestMysql.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import demba.projetTestMysql.model.Personne;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class PersonneDaoImplIT {
	
	private static final Long ID_PERSONNE_EXISTANTE = new Long(1);
	private static final Long ID_PERSONNE_NON_EXISTANTE = new Long(-1);

	@Autowired
	private PersonneDao personneDao;
	
	@Test
	public void testFindPersonneByID_personneExiste() {
		Personne personne = personneDao.findPersonneByID(ID_PERSONNE_EXISTANTE);
		Personne personneAttendue = new Personne();
		personneAttendue.setIdPersonne(ID_PERSONNE_EXISTANTE);
		personneAttendue.setNom("tall");
		personneAttendue.setPrenom("amdy");
		personneAttendue.setTelephone("514-456-9999");
		Assert.assertEquals("La personne trouvee ne correspond pas a la personne attendue", personneAttendue, personne);
		
		//Assert.fail(); // a enlever apres que le  test soit termine
		
	}
	
	@Test(expected = EmptyResultDataAccessException.class)
	public void testFindPersonneByID_personneExistePas() {
		personneDao.findPersonneByID(ID_PERSONNE_NON_EXISTANTE);
		//Assert.fail();
	}
	
	@Test
	public void testFindAllPersonnes() { // Avoir deux BD (une pour le test, l autre pour la production)
		List<Personne> lstPersonnes = personneDao.findAllPersonnes();
		
		//Personne ayant comme ID = 1
		Personne personneAttendueUne = new Personne();
		personneAttendueUne.setIdPersonne(ID_PERSONNE_EXISTANTE);
		personneAttendueUne.setNom("tall");
		personneAttendueUne.setPrenom("amdy");
		personneAttendueUne.setTelephone("514-456-9999");
		
		//Personne ayant comme ID = 2
		Personne personneAttendueDeux = new Personne();
		personneAttendueDeux.setIdPersonne(new Long(2));
		personneAttendueDeux.setNom("talla");
		personneAttendueDeux.setPrenom("ady");
		personneAttendueDeux.setTelephone("514-456-2999");
		
		//Personne ayant comme ID = 3
		Personne personneAttendueTrois = new Personne();
		personneAttendueTrois.setIdPersonne(new Long(3));
		personneAttendueTrois.setNom("dia");
		personneAttendueTrois.setPrenom("astou");
		personneAttendueTrois.setTelephone("514-459-2999");
		
		//Verification
		Assert.assertTrue("La liste des personnes ne contient pas la personne ayant comme Id egal a 1", lstPersonnes.contains(personneAttendueUne));
		Assert.assertTrue("La liste des personnes ne contient pas la personne ayant comme Id egal a 2", lstPersonnes.contains(personneAttendueDeux));
		Assert.assertTrue("La liste des personnes ne contient pas la personne ayant comme Id egal a 3", lstPersonnes.contains(personneAttendueTrois));
		Assert.assertEquals("La liste des personnes a pour taille differente de 3", 3, lstPersonnes.size());
		//Assert.fail();
	}
}
