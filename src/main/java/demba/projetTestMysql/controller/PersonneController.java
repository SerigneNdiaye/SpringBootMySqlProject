package demba.projetTestMysql.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import demba.projetTestMysql.dao.PersonneDao;
import demba.projetTestMysql.model.Personne;

@Controller
public class PersonneController {
	
	@Autowired
	private PersonneDao personneDao;
	
	@RequestMapping("/")
	public String afficherPage(Model model) {
		List<Personne> lstPersonnes = personneDao.findAllPersonnes(); 
		model.addAttribute("lstPersonnes", lstPersonnes);
		return "page";
	}
	
	@RequestMapping(value="/createPerson", method=RequestMethod.POST)
	public String createPerson(Personne personne) {

		personneDao.savePersonne(personne);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/registerPerson", method=RequestMethod.GET)
	public String showCreatePersonForm(Model model) {
		
		Personne personne = new Personne();
		model.addAttribute("personne", personne);
		
		return "createPerson";
	}
	
	@RequestMapping(value="/editPerson/{id}", method=RequestMethod.GET)
	public String editPersonForm(Model model, @PathVariable("id") Long idPersonne) {
		Personne personne = personneDao.findPersonneByID(idPersonne); 
		model.addAttribute("personne", personne);
		return "updatePerson";
	}
	
	@RequestMapping(value="/updatePerson", method=RequestMethod.POST)
	public String updatePerson(Personne personne) {
		personneDao.updatePersonne(personne);
		return "redirect:/";
	}
	
	@RequestMapping(value="/deletePerson/{id}", method=RequestMethod.GET)
	public String deletePerson(@PathVariable("id") Long idPersonne) {
		personneDao.deletePersonne(idPersonne);
		return "redirect:/";
	}
	
	@RequestMapping(value="/searchPerson", method=RequestMethod.GET)
	public String searchPerson(@RequestParam("query") String query, Model model) {
		List<Personne> lstPersonne = personneDao.searchPerson(query);
		model.addAttribute("lstPersonnes", lstPersonne);
		model.addAttribute("query", query);
		return "page";
	}

}
