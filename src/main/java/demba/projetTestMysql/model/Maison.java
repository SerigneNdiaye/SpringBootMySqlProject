package demba.projetTestMysql.model;

public class Maison {
	
	private long idMaison;
	private String adresse;
	private String superficie;
	
	public long getIdMaison() {
		return idMaison;
	}
	public void setIdMaison(long idMaison) {
		this.idMaison = idMaison;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getSuperficie() {
		return superficie;
	}
	public void setSuperficie(String superficie) {
		this.superficie = superficie;
	}	
	
}
