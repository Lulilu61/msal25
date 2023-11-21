package com.urbanisationsi.microservices_produit.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.urbanisationsi.microservices_produit.entity.Produit;


public interface ProduitRepository extends CrudRepository<Produit, Integer>{

	List<Produit> findByNumeroProduit(Long numeroProduit);
	
}
