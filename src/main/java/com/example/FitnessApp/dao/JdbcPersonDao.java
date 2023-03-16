package com.example.FitnessApp.dao;

import com.example.FitnessApp.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcPersonDao implements PersonDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> getAllUsers() {
        List<Person> allUsers = new ArrayList<>();
        String sql = "select * from person";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            Person user = mapRowToUser(results);
            allUsers.add(user);
        }
        return allUsers;
    }

    @Override
    public Person getUserById(int id) {
        Person person = new Person();
        String sql = "SELECT * from person WHERE person_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if(results.next()){
            person =  mapRowToUser(results);
        }
        return person;
    }

    @Override
    public void AddUser(Person newPerson, int userId) {
        String sql = "INSERT INTO person (person_id, first_name, last_name, age, current_weight, goal_weight, height, user_id) VALUES (default, ?, ?, ?, ?, ?, ?, ?);";

        try {
            jdbcTemplate.update(sql, newPerson.getFirstName(), newPerson.getLastName(), newPerson.getAge(), newPerson.getCurrentWeight(), newPerson.getGoalWeight(), newPerson.getHeight(), userId);
        }
        catch (Error e) {
            System.out.println("Information Not Correct");
        }
    }

    @Override
    public void updateUser(Person updatedPerson, int id) {
        String sql = "UPDATE person SET first_name = ?, last_name = ?, age = ?, current_weight = ?, goal_weight = ?, height = ?, user_id = ? WHERE person_id = ?;";

        try {
            jdbcTemplate.update(sql, updatedPerson.getFirstName(), updatedPerson.getLastName(), updatedPerson.getAge(), updatedPerson.getCurrentWeight(), updatedPerson.getGoalWeight(), updatedPerson.getHeight(), updatedPerson.getUserId(), id);
        } catch (Error e) {
            System.out.println("Unable to complete");
        }
    }

    @Override
    public void removeUser(int id) {
        String sql = "DELETE FROM person where person_id = ?";

        jdbcTemplate.update(sql, id);
    }

    private Person mapRowToUser(SqlRowSet sql) {
        Person person = new Person();
        person.setId(sql.getInt("person_id"));
        person.setFirstName(sql.getString("first_name"));
        person.setLastName(sql.getString("last_name"));
        person.setAge(sql.getInt("age"));
        person.setCurrentWeight(sql.getInt("current_weight"));
        person.setGoalWeight(sql.getInt("goal_weight"));
        person.setHeight(sql.getInt("height"));
        person.setUserId(sql.getInt("user_id"));
        return person;
    }
}
