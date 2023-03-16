package com.example.FitnessApp.service;

import com.example.FitnessApp.dao.ExerciseDao;
import com.example.FitnessApp.model.Exercise;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class ExerciseService implements ExerciseDao {

    private RestTemplate restTemplate = new RestTemplate();

    String API_BASE_URL = "https://api.api-ninjas.com/v1/exercises";
    String API_KEY = "wVryX7s+YD2xrHudcLw9VA==vCHXDXU9iWTgwA1V";

    public ExerciseService(){};

    public ExerciseService(String API_BASE_URL, String API_KEY) {
        this.API_BASE_URL = API_BASE_URL;
        this.API_KEY = API_KEY;
    }

    private HttpEntity<Void> makeHeaders(){
        HttpHeaders header = new HttpHeaders();
        header.set("x-api-key", API_KEY);
        return new HttpEntity<>(header);
    }

    public List<Exercise> exercisesByMuscle(String muscle){
        List<Exercise> exercises = new ArrayList<>();
        String path = API_BASE_URL + "?muscle=" + muscle;
        String exercise = null;
        ResponseEntity<List<Exercise>> response =
                restTemplate.exchange(path, HttpMethod.GET, makeHeaders(), new ParameterizedTypeReference<List<Exercise>>(){});
        exercises = response.getBody();
        return exercises;
    }

    public List<Exercise> exercisesByType(String type){
        List<Exercise> exercises = new ArrayList<>();
        String path = API_BASE_URL + "?type=" + type;
        String exercise = null;
        ResponseEntity<List<Exercise>> response =
                restTemplate.exchange(path, HttpMethod.GET, makeHeaders(), new ParameterizedTypeReference<List<Exercise>>(){});
        exercises = response.getBody();
        return exercises;
    }

    public List<Exercise> exercisesByName(String name){
        List<Exercise> exercises = new ArrayList<>();
        String path = API_BASE_URL + "?name=" + name;
        String exercise = null;
        ResponseEntity<List<Exercise>> response =
                restTemplate.exchange(path, HttpMethod.GET, makeHeaders(), new ParameterizedTypeReference<List<Exercise>>(){});
        exercises = response.getBody();
        return exercises;
    }

    public List<Exercise> exercisesByDifficulty(String difficulty){
        List<Exercise> exercises = new ArrayList<>();
        String path = API_BASE_URL + "?difficulty=" + difficulty;
        String exercise = null;
        ResponseEntity<List<Exercise>> response =
                restTemplate.exchange(path, HttpMethod.GET, makeHeaders(), new ParameterizedTypeReference<List<Exercise>>(){});
        exercises = response.getBody();
        return exercises;
    }

    public List<Exercise> exercisesBySearch(Exercise exercise){
        List<Exercise> exercises = new ArrayList<>();
        String path = API_BASE_URL + "?";

        if(exercise.getName() != null){
            path += "name=" + exercise.getName() + "&";
        }

        if(exercise.getDifficulty() != null){
            path += "difficulty=" + exercise.getDifficulty() + "&";
        }

        if(exercise.getType() != null){
            path += "type=" + exercise.getType() + "&";
        }

        if(exercise.getMuscle() != null){
            path += "muscle=" + exercise.getMuscle();
        }
        ResponseEntity<List<Exercise>> response =
                restTemplate.exchange(path, HttpMethod.GET, makeHeaders(), new ParameterizedTypeReference<List<Exercise>>(){});
        exercises = response.getBody();
        return exercises;
    }
}
