package com.urbanisationsi.microservices_contrat_mongoDB_correction.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.urbanisationsi.microservices_contrat_mongoDB_correction.dao.ContratRepository;
import com.urbanisationsi.microservices_contrat_mongoDB_correction.entity.Contrat;


@RestController
@RequestMapping(path="/contrat")
public class ContratController {

	@Autowired
	private ContratRepository contratRepo;
	
	@PostMapping(path="/ajouter")
	public ResponseEntity<Void> creerContrat(@RequestBody Contrat contrat) {
		Contrat contratAjout = contratRepo.save(contrat);
		
		if(contratAjout == null) {
			return ResponseEntity.noContent().build();
		} else {
			URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(contratAjout.getId()).toUri();
			
			return ResponseEntity.created(uri).build();
		}
	}
	
	@GetMapping(path="/listerContrats")
	public @ResponseBody Iterable<Contrat> getAllContrats() {
		return contratRepo.findAll();
	}
	
	@GetMapping(path="/chercherNumAssure/{numeroAssure}")
	public @ResponseBody Iterable<Contrat> getByNumAssure(@PathVariable Long numeroAssure) {
		return contratRepo.findByNumeroAssure(numeroAssure);
	}
}