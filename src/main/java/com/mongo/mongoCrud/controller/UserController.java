package com.mongo.mongoCrud.controller;

import com.mongo.mongoCrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mongo.mongoCrud.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/create")
    public String create(@RequestParam int id, @RequestParam String name, @RequestParam int age , @RequestParam String address){
        User u=userService.create(id, name, age, address);
        return u.toString();
    }

    @RequestMapping("/get")
    public User getUser(@RequestParam String name){
        return userService.getByName(name);
    }

    @RequestMapping("/getAll")
    public List<User> getAll(){
        return userService.getAll();
    }

    @RequestMapping("/update")
    public String update(@RequestParam String name, @RequestParam int age , @RequestParam String address){
        User u=userService.update(name, age, address);
        return u.toString();
    }

   @RequestMapping("/delete")
    public String delete(@RequestParam String name) {
        userService.delete(name);
        return name+" was deleted";
   }

   @RequestMapping("/deleteAll")
    public String deleteAll(){
        userService.deleteAll();
        return "All records were deleted";
   }
}
