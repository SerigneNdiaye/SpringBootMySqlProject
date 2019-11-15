package demba.projetTestMysql.model;

import java.sql.Date;

public class Possession {
	
	private long idPossession;
	private long codePersonne;
	private long codeMaison;
	private Date datePossession; // private String datePossession;
	
	public long getIdPossession() {
		return idPossession;
	}
	public void setIdPossession(long idPossession) {
		this.idPossession = idPossession;
	}
	public long getCodePersonne() {
		return codePersonne;
	}
	public void setCodePersonne(long codePersonne) {
		this.codePersonne = codePersonne;
	}
	public long getCodeMaison() {
		return codeMaison;
	}
	public void setCodeMaison(long codeMaison) {
		this.codeMaison = codeMaison;
	}
	public Date getDatePossession() { // String
		return datePossession;
	}
	public void setDatePossession(Date datePossession) { // String
		this.datePossession = datePossession;
	}
	
	
}
