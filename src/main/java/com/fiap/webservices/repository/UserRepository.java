package com.fiap.webservices.repository;

import com.fiap.webservices.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, String> {
    User findByEmailEqualsAndPassword(String email, String password);

}
