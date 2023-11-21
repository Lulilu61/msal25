package com.urbanisationsi.microservices_contrat_mongoDB_correction.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.urbanisationsi.microservices_contrat_mongoDB_correction.entity.Contrat;


public interface ContratRepository extends MongoRepository<Contrat, String>{
	List<Contrat> findByNumeroAssure(Long numeroAssure);
}
