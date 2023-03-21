import axios from 'axios'
import {useState, useEffect} from 'react'
import '../CSS/workout.css'

function CreateWorkout(){
    const [workout, setWorkout] = useState([])
    const [workoutName, setWorkoutName] = useState('')
    const [workoutDescription, setWorkoutDescription] = useState('')
    const [weight, setWeight] = useState('')
    const [reps, setReps] = useState('')
    const [bodyGroupId, setBodyGroupId] = useState('')
    const [date, setDate] = useState('')
    const [sets, setSets] = useState('') 
    const [bodyGroups, setBodyGroups] = useState([])
    const id = 1;

    useEffect(() => {
        async function fetchBodyGroups(){
            const response = await axios.get('http://localhost:9000/bodygroups/all')
            setBodyGroups(response.data)
        }
        fetchBodyGroups()
    }, [])

   
    function addWorkout(newWorkout, id) {
        console.log(newWorkout)
        axios.post(`http://localhost:9000/workouts/new/${id}`, newWorkout, {
            headers: {
                'Content-Type': 'application/json'
            }
            })
        .then((response) => {
                console.log(response.data);
                setWorkout(response.data)
        })
        .catch(function(error) {
            console.log(error);
        
        })
        }

    function handleSubmit(e){
        e.preventDefault()
        addWorkout({
            workoutName: workoutName,
            workoutDescription: workoutDescription,
            weight: weight,
            reps: reps,
            bodyGroupId: 3,
            date: date,
            sets: sets
        }, id)
    }

{/*Need to style input, but input works correctly*/}
    return(
        
        <div className="create-workout">
            Fill in the following fields to log a new workout!
            <form onSubmit={handleSubmit}>
                <p>Workout Name:<input type="text" value={workoutName} onChange={(e)=>setWorkoutName(e.target.value)}/></p>
                <p>Workout Description: <input type="text" value={workoutDescription} onChange={(e)=>setWorkoutDescription(e.target.value)} /></p>
                <p>Weight:<input type="number" value={weight} onChange={(e)=>setWeight(e.target.value)} /></p>
                <p>Reps:<input type="number" value={reps} onChange={(e)=>setReps(e.target.value)} /></p>
                <p>Sets:<input type="number" value={sets} onChange={(e)=>setSets(e.target.value)} /></p>
                <p>Date:<input type="date" value={date} onChange={(e)=>setDate(e.target.value)} /></p>
                <select value={bodyGroupId} onChange={(e)=>setBodyGroupId(e.target.value)}>
                {bodyGroups.map((bodyGroup) => (<option key={bodyGroupId}>{bodyGroup.name}</option>
                ))}
                </select>
                <input type="submit" />
            </form>
        </div>    
    )
}

export default CreateWorkout;