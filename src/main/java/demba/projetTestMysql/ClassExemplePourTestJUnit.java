package demba.projetTestMysql;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ClassExemplePourTestJUnit {
	
	private ClassExemplePourTestJUnit() {}
	
	public static int getNbJourMois(Date date) {
		int mois = date.getMonth();
		if (Calendar.JANUARY == mois || Calendar.MARCH == mois || Calendar.MAY == mois || Calendar.JULY == mois
				|| Calendar.AUGUST == mois || Calendar.OCTOBER == mois || Calendar.DECEMBER == mois) {
			return 31;
		} else if (Calendar.APRIL == mois || Calendar.JUNE == mois || Calendar.SEPTEMBER == mois
				|| Calendar.NOVEMBER == mois) {
			return 30;
		}
		Date dateFevrier = new Date(date.getTime());
		int jour = dateFevrier.getDate();
		while (Calendar.FEBRUARY == dateFevrier.getMonth()) {
			jour = dateFevrier.getDate();
			Calendar cal = new GregorianCalendar();
			cal.setTime(dateFevrier);
			cal.add(Calendar.DAY_OF_MONTH, 1);
			dateFevrier = cal.getTime();
		}
		return jour;
	}

}
