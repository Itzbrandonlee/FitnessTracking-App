package com.example.FitnessApp.model;

public class Bodygroup {

    private int bodygroupId;
    private String name;

    public Bodygroup(){}
    public Bodygroup(int bodygroupId, String name) {
        this.bodygroupId = bodygroupId;
        this.name = name;
    }

    public int getBodygroupId() {
        return bodygroupId;
    }

    public void setBodygroupId(int bodygroupId) {
        this.bodygroupId = bodygroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "BodyGroup {" +
                "body_group_id=" + bodygroupId +
                ", body_group_name=" + name +
                '}';
    }
}
