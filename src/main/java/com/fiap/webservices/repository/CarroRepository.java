package com.fiap.webservices.repository;

import com.fiap.webservices.models.canonical.Carro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends MongoRepository<Carro, String> {

}
