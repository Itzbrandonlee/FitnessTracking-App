package com.example.FitnessApp.dao;

import com.example.FitnessApp.model.Person;


import java.util.List;

public interface PersonDao {
    public List<Person> getAllUsers();
    public Person getUserById(int id);
    public void AddUser(Person newPerson, int userId);
    public void updateUser(Person updatedPerson, int id);
    public void removeUser(int id);
}
