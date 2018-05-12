package com.fiap.webservices.repository;

import com.fiap.webservices.models.canonical.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<Usuario, String> {
    Usuario findByEmailEqualsAndPassword(String email, String password);
}
