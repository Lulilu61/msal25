package com.urbanisationsi.microservices_contrat.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

import com.urbanisationsi.microservices_contrat.config.ApplicationPropertiesConfiguration;
import com.urbanisationsi.microservices_contrat.dao.ContratRepository;
import com.urbanisationsi.microservices_contrat.entity.Contrat;

@RestController
@RequestMapping(path = "/contrat")
public class ContratController {

	@Autowired
	private ContratRepository contratRepo;

	@Autowired
	ApplicationPropertiesConfiguration appProperties;

	@PostMapping(path = "/ajouter")
	public ResponseEntity<Void> creerContrat(@RequestBody Contrat contrat) {
		Contrat contratAjout = contratRepo.save(contrat);

		if (contratAjout == null) {
			return ResponseEntity.noContent().build();
		} else {
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(contratAjout.getId()).toUri();

			return ResponseEntity.created(uri).build();
		}
	}

//	@GetMapping(path = "/listerContrats")
//	public @ResponseBody Iterable<Contrat> getAllContrats() {
//		return contratRepo.findAll();
//	}
	
	@GetMapping(path="/listerLesContrats")
    public List<Contrat> getAllContrats() {

        Iterable<Contrat> contratsIterable = contratRepo.findAll();
        List<Contrat> contratsList = StreamSupport 
                .stream(contratsIterable.spliterator(), false) 
                .collect(Collectors.toList()); 
        List<Contrat> listeLimitee = contratsList.subList(0, appProperties.getLimiteNombreContrat());
        return listeLimitee;
    }

	@GetMapping(path = "/chercherNumContrat/{numeroContrat}")
	public @ResponseBody Iterable<Contrat> getByNumContrat(@PathVariable Long numeroContrat) {
		return contratRepo.findByNumeroAssure(numeroContrat);
	}
}