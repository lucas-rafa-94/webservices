package com.fiap.webservices.repository;

import com.fiap.webservices.models.canonical.Carro;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends CrudRepository<Carro, String> {
    @Query("{ 'status' :  ?0  }")
    List<Carro> findCarrosByStatusEquals(String status);
    Carro findByChassi(int chassi);
}
