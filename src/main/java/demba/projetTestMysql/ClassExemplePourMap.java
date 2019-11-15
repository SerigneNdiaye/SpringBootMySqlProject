package demba.projetTestMysql;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

public class ClassExemplePourMap {
	
	public static void main(String[] args) {
		
		Map<String, Membre> map = new HashMap<>();
		
		Membre membre1 = new Membre();
		membre1.setNom("Talla");
		membre1.setPrenom("Moda");
		
		Membre membre2 = new Membre();
		membre2.setNom("Sarre");
		membre2.setPrenom("Ady");
		
		map.put("cleMembre1", membre1);
		map.put("cleMembre2", membre2);
		
		StringBuilder sb = new StringBuilder();
		for(Entry<String, Membre> mapEntry : map.entrySet()) {
			sb.append("Cle : " + mapEntry.getKey() + "\nNom : " + mapEntry.getValue().getNom() 
					+ "\nPrenom : " +mapEntry.getValue().getPrenom() +  "\n\n********************\n\n");
		}
		JOptionPane.showMessageDialog(null, sb);
		
	}

}

class Membre {
	private String nom;
	private String prenom;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
}
