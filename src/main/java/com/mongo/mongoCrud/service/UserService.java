package com.mongo.mongoCrud.service;

import com.mongo.mongoCrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mongo.mongoCrud.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(int id, String name, int age, String address) {
        return userRepository.save(new User (id, name, age, address));
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getByName(String name) {
        return userRepository.findByName(name);
    }

    public User update(String name, int age, String adress) {
        User u=userRepository.findByName(name);
        u.setName(name);
        u.setAddress(adress);
        u.setAge(age);
        return userRepository.save(u);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public void delete(String name){
        User u= userRepository.findByName(name);
        userRepository.delete(u);
    }
}
