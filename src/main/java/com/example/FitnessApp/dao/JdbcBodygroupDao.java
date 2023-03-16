package com.example.FitnessApp.dao;

import com.example.FitnessApp.model.Bodygroup;
import com.example.FitnessApp.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcBodygroupDao implements BodygroupDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcBodygroupDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Bodygroup> getAllBodyGroups() {
        List<Bodygroup> allBodyGroups = new ArrayList<>();
        String sql = "Select * from body_groups";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            Bodygroup bodygroup = mapRowToBodyGroup(results);
            allBodyGroups.add(bodygroup);
        }
        return allBodyGroups;
    }

    @Override
    public Bodygroup getBodyGroupById(int id) {
        Bodygroup bodygroup = new Bodygroup();
        String sql = "SELECT * from body_groups where body_group_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        while(results.next()){
            bodygroup = mapRowToBodyGroup(results);
        }
        return bodygroup;
    }

    @Override
    public void addBodyGroup(Bodygroup bodyGroup) {
        String sql = "INSERT INTO body_groups (body_group_id, body_group_name) values (default, ?);";
        jdbcTemplate.update(sql, bodyGroup.getName());
    }

    @Override
    public void deleteBodyGroup(int id) {
        String sql = "Delete from body_groups where body_group_id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateBodyGroup(Bodygroup bodyGroup, int id) {
        String sql = "UPDATE body_groups SET body_group_name = ? where body_group_id = ?";
        jdbcTemplate.update(sql, bodyGroup.getName(), id);

    }

    private Bodygroup mapRowToBodyGroup(SqlRowSet sql) {
        Bodygroup bodyGroup = new Bodygroup();
        bodyGroup.setBodygroupId(sql.getInt("body_group_id"));
        bodyGroup.setName(sql.getString("body_group_name"));
        return bodyGroup;
    }
}
