package com.urbanisationsi.microservices_assure.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import org.hibernate.validator.constraints.Length;

@Entity
public class Assure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
//	@Length(min=3, max=15, message = "Le nombre de caractères du nom de la personne doit être compris entre 3 et 15 caractères.")
//	private String nom;
//	
//	private String prenom;
//	
//	private Long numeroPersonne;
	
	private String dossierMedical;
	
	private Long numeroAssure;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDossierMedical() {
		return dossierMedical;
	}

	public void setDossierMedical(String dossierMedical) {
		this.dossierMedical = dossierMedical;
	}

	public Long getNumeroAssure() {
		return numeroAssure;
	}

	public void setNumeroAssure(Long numeroAssure) {
		this.numeroAssure = numeroAssure;
	}

//	public String getNom() {
//		return nom;
//	}
//
//	public void setNom(String nom) {
//		this.nom = nom;
//	}
//
//	public String getPrenom() {
//		return prenom;
//	}
//
//	public void setPrenom(String prenom) {
//		this.prenom = prenom;
//	}
//
//	public Long getNumeroPersonne() {
//		return numeroPersonne;
//	}
//
//	public void setNumeroPersonne(Long numeroPersonne) {
//		this.numeroPersonne = numeroPersonne;
//	}
	
	
	
	

}
