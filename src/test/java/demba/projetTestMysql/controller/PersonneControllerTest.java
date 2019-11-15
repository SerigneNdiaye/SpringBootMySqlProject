package demba.projetTestMysql.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import demba.projetTestMysql.dao.PersonneDao;
import demba.projetTestMysql.model.Personne;

//@BeforeClass --- Roule une seule fois pour la classe en premier
//@Before --- Roule avant chaque test
//@Test --- Roule
//@After --- Roule apres chaque test
//@AfterClass --- Roule une fois apres que tous les tests soient roules

@RunWith(BlockJUnit4ClassRunner.class)
public class PersonneControllerTest {
	
	@InjectMocks // permet d injecter l ensemble des mocks de la classe 
	@Spy
	private PersonneController personneController = new PersonneController();
	
	@Mock
	private PersonneDao personneDao;
	
	@BeforeClass // chose que l on veut faire une seule fois pour les tests --- meme principe que @AfterClass
	public static void setUpClass() {
		
	}
	
	@Before // Roule avant chaque test
	public void setUp() { 
		MockitoAnnotations.initMocks(this);
	}
	
	@After
	public void tearDown() {
		//Non plus pour ce cas
	}
	
	@Test
	public void testAfficherPage() {
		
		//Personne ayant comme ID = 1
		Personne personneUne = new Personne();
		personneUne.setIdPersonne(new Long(1));
		personneUne.setNom("tall");
		personneUne.setPrenom("amdy");
		personneUne.setTelephone("514-456-9999");
		
		//Personne ayant comme ID = 2
		Personne personneDeux = new Personne();
		personneDeux.setIdPersonne(new Long(2));
		personneDeux.setNom("talla");
		personneDeux.setPrenom("ady");
		personneDeux.setTelephone("514-456-2999");
		
		//Personne ayant comme ID = 3
		Personne personneTrois = new Personne();
		personneTrois.setIdPersonne(new Long(3));
		personneTrois.setNom("dia");
		personneTrois.setPrenom("astou");
		personneTrois.setTelephone("514-459-2990");
	
		List<Personne> lstPersonnes = Arrays.asList(personneUne, personneDeux, personneTrois);
		
		when(personneDao.findPersonneByID(personneUne.getIdPersonne())).thenReturn(personneUne);
		when(personneDao.findAllPersonnes()).thenReturn(lstPersonnes);
		
		Model model = new ExtendedModelMap();
		
		String resultat = personneController.afficherPage(model);
		
		assertEquals("L attribut personne ne correspond pas a l attendue", personneUne, model.asMap().get("personne"));
		assertEquals("L attribut lstPersonnes ne correspond pas a l attendue", lstPersonnes, model.asMap().get("lstPersonnes"));
		assertEquals("Le resultat est incorrect", "page", resultat);
		
	}
	
	

}
