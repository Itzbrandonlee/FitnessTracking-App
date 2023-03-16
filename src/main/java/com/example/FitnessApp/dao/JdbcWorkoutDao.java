package com.example.FitnessApp.dao;

import com.example.FitnessApp.model.Person;
import com.example.FitnessApp.model.Workout;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcWorkoutDao implements WorkoutDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcWorkoutDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Workout> getAllWorkouts() {

        List<Workout> allWorkouts = new ArrayList<>();
        String sql = "select * from workouts";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            Workout workout = mapRowToWorkout(results);
            allWorkouts.add(workout);
        }
        return allWorkouts;
    }

    @Override
    public List<Workout> getWorkoutsByUserId(int userId) {
        List<Workout> workouts = new ArrayList<>();
        String sql = "select * from workouts w join person_workout pw ON w.workout_id = pw.workout_id where person_id = ? ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);

        while(results.next()){
            Workout workout = mapRowToWorkout(results);
            workouts.add(workout);
        }
        return workouts;
    }

    @Override
    public List<Workout> getWorkoutsByBodygroup(String bodyGroupName) {
        List<Workout> workouts = new ArrayList<>();
        String sql = "select * from workouts w join body_groups bg on w.body_group_id = bg.body_group_id where LOWER(body_group_name) like LOWER(concat('%', ?, '%'))";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bodyGroupName);

        while(results.next()){
            Workout workout = mapRowToWorkout(results);
            workouts.add(workout);
        }
        return workouts;
    }

    @Override
    public Workout getWorkoutById(int workoutId) {
        Workout workout = new Workout();
        String sql = "Select * from workouts where workout_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, workoutId);

        while(results.next()){
            workout = mapRowToWorkout(results);
        }
        return workout;
    }

    @Override
    public void addNewWorkout(Workout workout, int userId) {
        String sql = "with new_workout as (" +
                "Insert into workouts (workout_id, workout_name, description, weight, reps, body_group_id, date, sets)" +
                "values (default, ?, ?, ?, ?, ?, ?, ?) returning workout_id)" +
                "insert into person_workout (person_id, workout_id) values (?, (select workout_id from new_workout));";

        jdbcTemplate.update(sql, workout.getWorkoutName(), workout.getWorkoutDescription(), workout.getWeight(), workout.getReps(), workout.getBodyGroupId(), workout.getDate(), workout.getSets(), userId);

    }

    @Override
    public void updateWorkout(Workout newWorkout, int workoutId) {
        String sql = "UPDATE workouts SET workout_name = ?, description = ?, weight = ?, reps = ?, body_group_id = ?, date = ?, sets = ? where workout_id = ?";
        jdbcTemplate.update(sql, newWorkout.getWorkoutName(), newWorkout.getWorkoutDescription(), newWorkout.getWeight(), newWorkout.getReps(), newWorkout.getBodyGroupId(), newWorkout.getDate(), newWorkout.getSets(), workoutId);

    }

    @Override
    public void deleteWorkout(int workoutId) {
        String sql = "with deleted_workout as (" +
                "delete from workouts " +
                "where workout_id = ? " +
                "returning workout_id) " +
                "delete from person_workout " +
                "where workout_id in (select workout_id from deleted_workout);";
        jdbcTemplate.update(sql, workoutId);
    }

    @Override
    public List<Workout> getWorkoutsByDate(LocalDate date) {
        List<Workout> workouts = new ArrayList<>();
        String sql = "Select * from workouts where date = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, date);

        while(results.next()){
            Workout workout = mapRowToWorkout(results);
            workouts.add(workout);
        }
        return workouts;
    }

    private Workout mapRowToWorkout(SqlRowSet sql) {
        Workout workout = new Workout();
        workout.setWorkoutId(sql.getInt("workout_id"));
        workout.setWorkoutName(sql.getString("workout_name"));
        workout.setWorkoutDescription(sql.getString("description"));
        workout.setWeight(sql.getInt("weight"));
        workout.setReps(sql.getInt("reps"));
        workout.setBodyGroupId(sql.getInt("body_group_id"));
        workout.setDate(sql.getDate("date").toLocalDate());
        workout.setSets(sql.getInt("sets"));
        return workout;
    }
}
