package com.urbanisationsi.microservices_assure.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.urbanisationsi.microservices_assure.configuration.ApplicationPropertiesConfiguration;
import com.urbanisationsi.microservices_assure.dao.AssureRepository;
import com.urbanisationsi.microservices_assure.entity.Assure;

@RestController
@RequestMapping(path = "/previt")
public class AssureController {

	@Autowired
	AssureRepository assureRepository;

	@Autowired
	ApplicationPropertiesConfiguration appProperties;

	@PostMapping(path = "/ajouterAssure")
	public ResponseEntity<Void> creerAssure(@Valid @RequestBody Assure assure) {
		Assure assureAjoute = assureRepository.save(assure);

		if (assureAjoute == null) {
			return ResponseEntity.noContent().build();
		} else {
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(assureAjoute.getId()).toUri();

			return ResponseEntity.created(uri).build();
		}
	}

//	@GetMapping(path="/listerAssure")
//	public @ResponseBody Iterable<Assure> getAllAssures(){
//	return assureRepository.findAll();
//	}

	@GetMapping(path="/listerAssure")
	public @ResponseBody Iterable<Assure> getAllAssures(){
	List<Assure> assureList = (List<Assure>) assureRepository.findAll();
	return assureList.subList(0, appProperties.getLimiteNombreAssure());
}

//	@GetMapping(path = "/listerLesAssures")
//	public List<Assure> getAllAssures() {
//
//		Iterable<Assure> assuresIterable = assureRepository.findAll();
//		List<Assure> assuresList = StreamSupport.stream(assuresIterable.spliterator(), false)
//				.collect(Collectors.toList());
//		List<Assure> listeLimitee = assuresList.subList(0, appProperties.getLimiteNombreAssure());
//		return listeLimitee;
//	}

	@DeleteMapping(path = "/Assure/{id}")
	public void supprimerAssurer(@PathVariable Integer id) {
		assureRepository.deleteById(id);
		System.out.println("Assuré supprimé");
	}

	@PutMapping(path = "/modifierAssure")
	public void modifierAssure(@RequestBody Assure assure) {
		assureRepository.save(assure);
		System.out.println("Assuré modifié");
	}

	@GetMapping(path = "/chercherNomPrenom/{nom}/{prenom}")
	public @ResponseBody Iterable<Assure> getByNomPrenom(@PathVariable String nom, @PathVariable String prenom) {
		return assureRepository.findByNomAndPrenom(nom, prenom);
	}

}
