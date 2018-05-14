package com.fiap.webservices.repository;


import com.fiap.webservices.models.canonical.Viagem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViagemRepository extends MongoRepository<Viagem, String> {

}
