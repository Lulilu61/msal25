package com.urbanisationsi.microservices_produit.controller;

import java.net.URI;
import java.util.List;

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

import com.urbanisationsi.microservices_produit.dao.ProduitRepository;
import com.urbanisationsi.microservices_produit.entity.Produit;

@RestController
@RequestMapping("/produit")
public class ProduitController {

	@Autowired
	private ProduitRepository produitRepo;
	
	@PostMapping(path="/ajouterProduit")
	public ResponseEntity<Void> creerProduit(@RequestBody Produit produit){
		Produit produitAjout = produitRepo.save(produit);
		
		if(produitAjout == null) {
			return ResponseEntity.noContent().build();
		} else {
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(produitAjout.getId()).toUri();
				return ResponseEntity.created(uri).build();
		}
	}
	
	@GetMapping(path="/listerProduits")
	public @ResponseBody Iterable<Produit> getAllProduits(){
		return produitRepo.findAll();
	}
	
	@GetMapping(path="/chercherNumProduit/{numeroProduit}")
	public Produit rechrecherNumProduit(@PathVariable Long numeroProduit) {
		List<Produit> produits = produitRepo.findByNumeroProduit(numeroProduit);
		
		if(produits.isEmpty()) {
			throw new RuntimeException("Le produit n'existe pas");
		}
		return produits.get(0);
	}
	
	
}
