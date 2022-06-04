package com.nozha.etudiant.controllers;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import com.nozha.etudiant.entities.Etudiant;
import com.nozha.etudiant.entities.Formation;
import com.nozha.etudiant.service.FormationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormationController {
	
	@Autowired
	FormationService formationService;
	
	
	@RequestMapping("/create-formation")
	public String showCreate(ModelMap modelMap) {
		Formation formation = new Formation();
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("formation", formation);
		return "formFormation";
	}
	
	
	@RequestMapping("/list-formation")
	public String listeSpecilates(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "4") int size) {
		Page<Formation> spe = formationService.getAllFormationsParPage(page, size);
		
		
		modelMap.addAttribute("formations", spe);
		modelMap.addAttribute("pages", new int[spe.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listFormation";
	}
	
	
	@RequestMapping("/saveFormation")
	public String saveFormation(@Valid Formation formation,
			 BindingResult bindingResult) 
	{
		if (bindingResult.hasErrors()) return "formFormation";
	 formationService.saveFormation(formation);
	 return "redirect:/list-formation";
	}
	
	@RequestMapping("/supprimerFormation")
	public String supprimerSpecilate(@RequestParam("id") Long id, ModelMap modelMap,

		@RequestParam(name = "page", defaultValue = "0") int page,
		@RequestParam(name = "size", defaultValue = "4") int size) {

		formationService.deleteFormationById(id);
		Page<Formation> formations = formationService.getAllFormationsParPage(page,
				size);
		modelMap.addAttribute("formations", formations);
		modelMap.addAttribute("pages", new int[formations.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listFormation";
	}
	
	
	@RequestMapping("/modifier-formation")
	public String editerSpecilate(@RequestParam("id") Long id, ModelMap modelMap) {
		
		Formation formation = formationService.getFormation(id);
		modelMap.addAttribute("formation", formation);
		modelMap.addAttribute("mode", "edit");
		return "formFormation";
	}

	@RequestMapping("/updateFormation")
	public String updateSpecilate(@ModelAttribute("formation") Formation formation, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		formationService.updateFormation(formation);
		List<Formation> formations = formationService.findAll();
		modelMap.addAttribute("formations", formations);
		return "listFormation";
	}

}
