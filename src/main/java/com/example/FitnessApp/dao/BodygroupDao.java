package com.example.FitnessApp.dao;

import com.example.FitnessApp.model.Bodygroup;


import java.util.List;

public interface BodygroupDao {

    public List<Bodygroup> getAllBodyGroups();
    public Bodygroup getBodyGroupById(int id);
    public void addBodyGroup(Bodygroup bodyGroup);
    public void deleteBodyGroup(int id);
    public void updateBodyGroup(Bodygroup bodyGroup, int id);
}
