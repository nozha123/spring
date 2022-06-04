package com.nozha.etudiant.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.nozha.etudiant.entities.Etudiant;
import com.nozha.etudiant.entities.Formation;
import com.nozha.etudiant.service.EtudiantService;
import com.nozha.etudiant.service.FormationService;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EtudiantController {

	@Autowired
	EtudiantService etudiantService;

	@Autowired
	FormationService formationService;
	
	@RequestMapping("/create-etudiant")
	public String showCreate(ModelMap modelMap) {
		List<Formation> formations = formationService.findAll();
		Etudiant etudiant = new Etudiant();
		Formation formation = new Formation();
		formation = formations.get(0);
		etudiant.setFormation(formation);
		
		modelMap.addAttribute("etudiant", etudiant);
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("formations", formations);

		return "formEtudiant";
	}
	
	
	@RequestMapping("/search-by-name")
	public String doSearchEtudiant(@ModelAttribute("etudiantSearchFormData")Etudiant formData,Model model, @RequestParam("nomEn") String nomEn) {
		List<Etudiant> etudiants = etudiantService.findByNomEtudiantContains(nomEn);
		model.addAttribute("etudiants",etudiants);
		List<Formation> formations = formationService.findAll();
		model.addAttribute("formations", formations);
		return "listEtudiant";
	}
	
	@RequestMapping("/search-by-formation")
	public String doSearchEtudiant1(@ModelAttribute("etudiantSearchFormData")Etudiant formData,Model modelMap, @RequestParam("s") Long s) {
		List<Formation> formations = formationService.findAll();
		modelMap.addAttribute("formations", formations);
		
		List<Etudiant> etudiants = etudiantService.findByFormationIdFormation(s);
		modelMap.addAttribute("etudiants",etudiants);

		return "listEtudiant";
	}


	@RequestMapping("/saveEtudiant")
	public String saveEtudiant(@Valid Etudiant etudiant,
			 BindingResult bindingResult) 
	{
		if (bindingResult.hasErrors()) return "formEtudiant";
	 etudiantService.saveEtudiant(etudiant);
	 return "redirect:/list-etudiant";
	}

	@RequestMapping("/list-etudiant")
	public String listeEtudiants(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Etudiant> etudiants = etudiantService.getAllEtudiantsParPage(page, size);
		
		List<Formation> formations = formationService.findAll();
		modelMap.addAttribute("formations", formations);
		
		modelMap.addAttribute("etudiants", etudiants);
		modelMap.addAttribute("pages", new int[etudiants.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listEtudiant";
	}

	@RequestMapping("/supprimerEtudiant")
	public String supprimerEtudiant(@RequestParam("id") Long id, ModelMap modelMap,

		@RequestParam(name = "page", defaultValue = "0") int page,
		@RequestParam(name = "size", defaultValue = "4") int size) {

		etudiantService.deleteEtudiantById(id);
		Page<Etudiant> ensi = etudiantService.getAllEtudiantsParPage(page,
				size);
		modelMap.addAttribute("etudiants", ensi);
		modelMap.addAttribute("pages", new int[ensi.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		List<Formation> formations = formationService.findAll();
		modelMap.addAttribute("formations", formations);
		return "listEtudiant";
	}

	@RequestMapping("/modifier-etudiant")
	public String editerEtudiant(@RequestParam("id") Long id, ModelMap modelMap) {
		
		Etudiant etudiant = etudiantService.getEtudiant(id);
		List<Formation> formations = formationService.findAll();
		modelMap.addAttribute("etudiant", etudiant);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("formations", formations);


		return "formEtudiant";
	}

	@RequestMapping("/updateEtudiant")
	public String updateProduit(@ModelAttribute("etudiant") Etudiant etudiant, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateEmbauche = dateformat.parse(String.valueOf(date));
		etudiant.setDate(dateEmbauche);

		etudiantService.updateEtudiant(etudiant);
		List<Etudiant> ensi = etudiantService.getAllEtudiants();
		modelMap.addAttribute("etudiants", ensi);
		return "listeEtudiants";
	}

}
