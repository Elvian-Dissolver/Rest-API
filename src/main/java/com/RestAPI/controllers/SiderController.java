package com.RestAPI.controllers;


import com.RestAPI.models.User;
import com.RestAPI.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class SiderController {
    private UserRepository userRepository;

    @Autowired
    public SiderController(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @GetMapping("/listuser")
    public List<User> getAllUser() {
        List<User> users = this.userRepository.findAll();
        return this.userRepository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<User> create(@RequestBody User user) {
        userRepository.save(user);
        return userRepository.findAll();
    }

    @PostMapping("/insert")
    public String insert(@RequestBody User user){
        this.userRepository.insert(user);
        user.setAction("Post");
        return "Post successfully";
    }

    @PutMapping("/update")
    public String update(@RequestBody User user){
        this.userRepository.save(user);
        user.setAction("Update");
        return "Update successfully";
    }

    @GetMapping(value = "/delete/{id}")
    public String remove(@PathVariable int id, User user){
        user = this.userRepository.findById(id);
        user.setAction("Delete");
        this.userRepository.deleteById(id);
        return "Delete successfully";
    }

    @RequestMapping(value = "/affordable/{age}", method = RequestMethod.GET)
    public List<User> getAffordable(@PathVariable int age) {
        //return bookings.stream().filter(x -> x.getPricePerNight() <= price).collect(Collectors.toList());
        return userRepository.findByAgeLessThan(age);
    }

}
