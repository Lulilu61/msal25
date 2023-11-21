package com.urbanisationsi.microservices_assure.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.urbanisationsi.microservices_assure.entity.Assure;

public interface AssureRepository extends CrudRepository<Assure, Integer>{
	
	List<Assure> findByNomAndPrenom(String nom, String prenom);
	List<Assure> findByNumeroPersonne(Long numeroPersonne);


}
