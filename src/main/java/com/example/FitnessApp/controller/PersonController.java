package com.example.FitnessApp.controller;

import com.example.FitnessApp.dao.PersonDao;
import com.example.FitnessApp.model.Person;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/profile")
public class PersonController {

    private PersonDao dao;

    public PersonController(PersonDao dao) {
        this.dao = dao;
    }

    @RequestMapping(path="/all", method = RequestMethod.GET)
    public List<Person> getAllUsers() {
        return dao.getAllUsers();
    }

    @RequestMapping(path="/new/{id}", method = RequestMethod.POST)
    public void addNewUser(@Valid @RequestBody Person newPerson, @PathVariable int id, Principal principal){
        dao.AddUser(newPerson, id);
    }

    @RequestMapping(path="/update/{id}", method = RequestMethod.PUT)
    public void updateUser(@RequestBody Person updatedPerson, @PathVariable int id){
        dao.updateUser(updatedPerson, id);
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public Person getUserById(@PathVariable int id){
        return dao.getUserById(id);
    }

    @RequestMapping(path="/delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id){
        dao.removeUser(id);
    }
}
