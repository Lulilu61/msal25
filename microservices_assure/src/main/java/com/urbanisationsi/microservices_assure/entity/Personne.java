package com.urbanisationsi.microservices_assure.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Personne {

	@Id
	@GeneratedValue
	protected Integer id;
	
	protected String nom;
	
	protected String prenom;
	
	protected Long numeroPersonne;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	protected Date dateNaissance;
}
