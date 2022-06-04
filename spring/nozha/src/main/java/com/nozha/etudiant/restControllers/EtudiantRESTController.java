package com.nozha.etudiant.restControllers;

import java.util.List;

import com.nozha.etudiant.entities.Etudiant;
import com.nozha.etudiant.service.EtudiantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EtudiantRESTController {
	@Autowired
	EtudiantService etudiantService;
	
	
		@RequestMapping(method=RequestMethod.GET)
		List<Etudiant>getAllEtudiants(){ 
			return etudiantService.getAllEtudiants();
		}
		
		@RequestMapping(value="/{id}",method = RequestMethod.GET)
		public Etudiant getEtudiantById(@PathVariable("id") Long id) 
		{ 
			return etudiantService.getEtudiant(id);
		}
		
		@RequestMapping(value="/recherche/{nom}",method = RequestMethod.GET)
		public List<Etudiant> getEtudiantByNomContains(@PathVariable("nom") String nom) 
		{ 
			return etudiantService.findByNomEtudiantContains(nom);
		}

		@RequestMapping(method = RequestMethod.POST)
		public Etudiant createEtudiant(@RequestBody Etudiant Etudiant) {
		return etudiantService.saveEtudiant(Etudiant);
		}
		
		
		@RequestMapping(method = RequestMethod.PUT)
		public Etudiant updateEtudiant(@RequestBody Etudiant Etudiant) {
		return etudiantService.updateEtudiant(Etudiant);
		}
		
		@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
		public void deleteEtudiant(@PathVariable("id") Long id)
		{
			etudiantService.deleteEtudiantById(id);
		}
		
		@RequestMapping(value="/ensispe/{idSpe}",method = RequestMethod.GET)
		public List<Etudiant> getEtudiantsByFormationId(@PathVariable("idSpe") Long idSpe) 
		{
		return etudiantService.findByFormationIdFormation(idSpe);
		}
}
