package com.nozha.etudiant.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Formation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFormation;
	private String nomFormation;
	private String descriptionFormation;
	
	
	@OneToMany(mappedBy="formation")
	@JsonIgnore
	private List<Etudiant> etudiants;


	public Long getIdFormation() {
		return idFormation;
	}


	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}


	public String getNomFormation() {
		return nomFormation;
	}


	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
	}


	public String getDescriptionFormation() {
		return descriptionFormation;
	}


	public void setDescriptionFormation(String descriptionFormation) {
		this.descriptionFormation = descriptionFormation;
	}


	public List<Etudiant> getEtudiants() {
		return etudiants;
	}


	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	} 
	
}	
	
	