package com.example.FitnessApp.controller;

import com.example.FitnessApp.dao.BodygroupDao;
import com.example.FitnessApp.model.Bodygroup;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bodygroups")
@CrossOrigin
public class BodygroupController {

    private BodygroupDao dao;

    public BodygroupController(BodygroupDao dao) {
        this.dao = dao;
    }

    @RequestMapping(path="/all", method = RequestMethod.GET)
    public List<Bodygroup> getAllBodyGroups(){
        return dao.getAllBodyGroups();
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public Bodygroup getBodyGroupById(@PathVariable int id){
        return dao.getBodyGroupById(id);
    }

    @RequestMapping(path="/add", method = RequestMethod.POST)
    public void addNewBodyGroup(@Valid @RequestBody Bodygroup bodyGroup){
        dao.addBodyGroup(bodyGroup);
    }

    @RequestMapping(path="/delete/{id}", method = RequestMethod.DELETE)
    public void deleteBodyGroupById(@PathVariable int id){
        dao.deleteBodyGroup(id);
    }

    @RequestMapping(path="/update/{id}", method = RequestMethod.PUT)
    public void updateBodyGroupById(@Valid @RequestBody Bodygroup bodyGroup, @PathVariable int id){
        dao.updateBodyGroup(bodyGroup, id);
    }


}
