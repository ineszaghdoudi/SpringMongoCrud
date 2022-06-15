package com.mongo.mongoCrud.repository;

import com.mongo.mongoCrud.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    public User findByName(String name);
    public List<User> findByAge(int age);
}
