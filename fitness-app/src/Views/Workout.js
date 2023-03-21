import { useState, useEffect } from 'react'
import axios from 'axios'
import '../CSS/workout.css'

function Workout() {

    const [workouts, setWorkouts] = useState([])
    const [bodyGroupName, setBodyGroupName] = useState({})

    function getWorkouts(){
        axios.get('http://localhost:9000/workouts/all')
        .then((response) => {
            const workouts = response.data;
            const bodyGroupPromises = workouts.map((workout) => {
                return axios.get(`http://localhost:9000/bodygroups/${workout.bodyGroupId}`)
                    .then((response) => {
                        const bodyGroupName = response.data.name;
                        return {
                            ...workout,
                            bodyGroupName
                        };
                    });
            });
            Promise.all(bodyGroupPromises)
                .then((workoutsWithBodyGroups) => {
                    setWorkouts(workoutsWithBodyGroups);
                });
        })
        .catch(function(error) {
            if (error.response) {
                console.log(error.response.data);
                console.log(error.response.status);
                console.log(error.response.headers);
            }
        });
    }

    useEffect(()=> {
        getWorkouts()
        console.log(workouts)
    }, [])
    {/*Need to add a add new button to link to create page*/}
    {/*Need to continue stying to create grid of workouts*/}
    return(
        <div className="workouts">
            <div className="workout-intro">
                <h1>View all Workout Logs below!</h1>
                <p>Search workouts by date or by muscle group!</p>
            </div>
          
            <div className="workout-grid">
            {workouts.map((workout, index) => (
                <div className="workout-card" key={index}>
                Date: {workout.date} <br/>
                Workout Name: {workout.workoutName}<br />
                Workout Description: {workout.workoutDescription}<br/>
                Body Group: {workout.bodyGroupName}<br/>
                Weight: {workout.weight}<br/>
                Reps: {workout.reps}<br/>
                Sets: {workout.sets}<br/>
                </div>
                ) )}
            </div> 
        </div>
    )}

export default Workout;