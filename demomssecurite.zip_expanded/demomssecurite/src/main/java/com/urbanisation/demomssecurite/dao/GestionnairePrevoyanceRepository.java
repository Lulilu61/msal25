package com.urbanisation.demomssecurite.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.urbanisation.demomssecurite.entity.GestionnairePrevoyance;

public interface GestionnairePrevoyanceRepository extends MongoRepository<GestionnairePrevoyance, String> {
    GestionnairePrevoyance findByMail(String mail);
}

