package com.urbanisation.demomssecurite.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.urbanisation.demomssecurite.entity.Role;


public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByRole(String role);
}

