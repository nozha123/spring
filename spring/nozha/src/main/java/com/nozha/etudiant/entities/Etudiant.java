package com.nozha.etudiant.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Etudiant {
	
     	@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY) 
	    private Long idEtudiant;
     	@NotNull
     	@Size (min = 4,max = 40)
	    private String nomEtudiant ;
		@NotNull
		@Size (min = 4,max = 40)
	    private String niveauEtudiant ;
	    @Temporal(TemporalType.DATE)
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    @PastOrPresent
	    private Date date;
	    
	    @ManyToOne
	    private Formation formation;
	    
	    
		
		public Etudiant() {
			super();
		}

		
		public Etudiant(Long idEtudiant, @NotNull @Size(min = 4, max = 40) String nomEtudiant,
				@NotNull @Size(min = 4, max = 40) String niveauEtudiant, @PastOrPresent Date date,
				Formation formation) {
			this.idEtudiant = idEtudiant;
			this.nomEtudiant = nomEtudiant;
			this.niveauEtudiant = niveauEtudiant;
			this.date = date;
			this.formation = formation;
		}







		public Long getIdEtudiant() {
			return idEtudiant;
		}



		public void setIdEtudiant(Long idEtudiant) {
			this.idEtudiant = idEtudiant;
		}



		public String getNomEtudiant() {
			return nomEtudiant;
		}



		public void setNomEtudiant(String nomEtudiant) {
			this.nomEtudiant = nomEtudiant;
		}



		public String getNiveauEtudiant() {
			return niveauEtudiant;
		}



		public void setNiveauEtudiant(String niveauEtudiant) {
			this.niveauEtudiant = niveauEtudiant;
		}



		public Date getDate() {
			return date;
		}



		public void setDate(Date date) {
			this.date = date;
		}



		public Formation getFormation() {
			return formation;
		}



		public void setFormation(Formation formation) {
			this.formation = formation;
		}


		@Override
		public String toString() {
			return "Etudiant [date=" + date + ", formation=" + formation + ", idEtudiant=" + idEtudiant
					+ ", niveauEtudiant=" + niveauEtudiant + ", nomEtudiant=" + nomEtudiant + "]";
		}
		    
}
