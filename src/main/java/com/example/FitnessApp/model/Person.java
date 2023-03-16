package com.example.FitnessApp.model;

public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private int currentWeight;
    private int goalWeight;
    private int userId;
    private int height;
    public Person(){}

    public Person(int id, String firstName, String lastName, int age, int currentWeight, int goalWeight, int userId, int height) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
        this.userId = userId;
        this.height = height;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(int goalWeight) {
        this.goalWeight = goalWeight;
    }

    public String toString() {
        return "Person {" +
                "person_id=" + id +
                ", first_name=" + firstName +
                ", last_name=" + lastName +
                ", age=" + age +
                ", current_weight=" + currentWeight +
                ", goal_weight=" + goalWeight +
                ", height=" + height +
                ", user_id=" + userId +
                '}';
    }
}
