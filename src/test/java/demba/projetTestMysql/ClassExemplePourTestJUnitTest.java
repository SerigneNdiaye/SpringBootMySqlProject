package demba.projetTestMysql;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class ClassExemplePourTestJUnitTest {
	

	@Test
	public void testGetNbJourMois_janvier() {
		Calendar cal = new GregorianCalendar();
		cal.set(2019, Calendar.JANUARY, 1);
		Date date = cal.getTime();
		assertEquals("Le de jours du mois n est pas correct", 31, ClassExemplePourTestJUnit.getNbJourMois(date));
	}
	
	@Test
	public void testGetNbJourMois_fevrier() {
		Calendar cal = new GregorianCalendar();
		cal.set(2019, Calendar.FEBRUARY, 1);
		Date date = cal.getTime();
		assertEquals("Le de jours du mois n est pas correct", 28, ClassExemplePourTestJUnit.getNbJourMois(date));
	}
	
	@Test
	public void testGetNbJourMois_fevrier_bissextile() {
		Calendar cal = new GregorianCalendar();
		cal.set(2020, Calendar.FEBRUARY, 1);
		Date date = cal.getTime();
		assertEquals("Le de jours du mois n est pas correct", 29, ClassExemplePourTestJUnit.getNbJourMois(date));
	}
	
	@Test
	public void testGetNbJourMois_mars() {
		Calendar cal = new GregorianCalendar();
		cal.set(2019, Calendar.MARCH, 1);
		Date date = cal.getTime();
		assertEquals("Le de jours du mois n est pas correct", 31, ClassExemplePourTestJUnit.getNbJourMois(date));
	}
	
	@Test
	public void testGetNbJourMois_avril() {
		Calendar cal = new GregorianCalendar();
		cal.set(2019, Calendar.APRIL, 1);
		Date date = cal.getTime();
		assertEquals("Le de jours du mois n est pas correct", 30, ClassExemplePourTestJUnit.getNbJourMois(date));
	}
	
	@Test
	public void testGetNbJourMois_mai() {
		Calendar cal = new GregorianCalendar();
		cal.set(2019, Calendar.MAY, 1);
		Date date = cal.getTime();
		assertEquals("Le de jours du mois n est pas correct", 31, ClassExemplePourTestJUnit.getNbJourMois(date));
	}
	
	@Test
	public void testGetNbJourMois_jun() {
		Calendar cal = new GregorianCalendar();
		cal.set(2019, Calendar.JUNE, 1);
		Date date = cal.getTime();
		assertEquals("Le de jours du mois n est pas correct", 30, ClassExemplePourTestJUnit.getNbJourMois(date));
	}
	
	@Test
	public void testGetNbJourMois_juillet() {
		Calendar cal = new GregorianCalendar();
		cal.set(2019, Calendar.JULY, 1);
		Date date = cal.getTime();
		assertEquals("Le de jours du mois n est pas correct", 31, ClassExemplePourTestJUnit.getNbJourMois(date));
	}
	
	@Test
	public void testGetNbJourMois_aout() {
		Calendar cal = new GregorianCalendar();
		cal.set(2019, Calendar.AUGUST, 1);
		Date date = cal.getTime();
		assertEquals("Le de jours du mois n est pas correct", 31, ClassExemplePourTestJUnit.getNbJourMois(date));
	}
	
	@Test
	public void testGetNbJourMois_septembre() {
		Calendar cal = new GregorianCalendar();
		cal.set(2019, Calendar.SEPTEMBER, 1);
		Date date = cal.getTime();
		assertEquals("Le de jours du mois n est pas correct", 30, ClassExemplePourTestJUnit.getNbJourMois(date));
	}
	
	@Test
	public void testGetNbJourMois_octobre() {
		Calendar cal = new GregorianCalendar();
		cal.set(2019, Calendar.OCTOBER, 1);
		Date date = cal.getTime();
		assertEquals("Le de jours du mois n est pas correct", 31, ClassExemplePourTestJUnit.getNbJourMois(date));
	}
	
	@Test
	public void testGetNbJourMois_novembre() {
		Calendar cal = new GregorianCalendar();
		cal.set(2019, Calendar.NOVEMBER, 1);
		Date date = cal.getTime();
		assertEquals("Le de jours du mois n est pas correct", 30, ClassExemplePourTestJUnit.getNbJourMois(date));
	}
	
	@Test
	public void testGetNbJourMois_decembre() {
		Calendar cal = new GregorianCalendar();
		cal.set(2019, Calendar.DECEMBER, 1);
		Date date = cal.getTime();
		assertEquals("Le de jours du mois n est pas correct", 31, ClassExemplePourTestJUnit.getNbJourMois(date));
	}
}
