package demba.projetTestMysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demba.projetTestMysql.dao.MaisonDao;
import demba.projetTestMysql.model.Maison;

@Controller
public class MaisonController {
	
	@Autowired
	private MaisonDao maisonDao;
	
	@RequestMapping(value = "/maison/idMaison={idMaison}", method = RequestMethod.GET)
	public String affichageMaison(Model model, @PathVariable("idMaison") long idMaison) { //......
		
		Maison maison = maisonDao.findMaisonByID(idMaison);
		//List<Maison> lstMaisons = maisonDao.findAllMaisons();
		
		model.addAttribute("maison", maison);
		//model.addAttribute("lstMaisons", lstMaisons);
		
		return "pageMaison";
	}

}
