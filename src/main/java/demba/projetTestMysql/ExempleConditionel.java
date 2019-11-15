package demba.projetTestMysql;

public class ExempleConditionel {

	private int valeur = 0;
	private IRien rien;
	
	public ExempleConditionel(int valeur, IRien rien) {
		this.valeur = valeur;
		this.rien = rien;
	}
	
	public int getValeur() {
		return valeur;
	}
	
	public void setValeurZero() {
		if (valeur != 0) {
			rien.rien();
			valeur = 0;
		}
	}

}
