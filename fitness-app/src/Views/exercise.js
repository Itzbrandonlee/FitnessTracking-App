import React, { useState, useEffect } from 'react'
import axios from 'axios';
import '../CSS/exercises.css'

function Exercises(){
    const [exercises, setExerciseData] = useState([])
    const [isActive, setIsActive] = useState(false)
    const [clickedIndex, setClickedIndex] = useState({})
    const [muscle, setMuscle] = useState('')
    const [type, setType] = useState('')
    const [difficulty, setDifficulty] = useState('')
    const [name, setName] = useState('')

    const handleClick = (index) => () => {
        setClickedIndex(state => ({
            ...state,
            [index]: !state[index],
            isActive: !isActive
        }));
    }

    function fetchMultipleSearch() {
        
        axios.get('http://localhost:9000/exercises/search', {
            headers: {
                'Content-Type': 'application/json',
            },
            params: {
                name: name,
                difficulty: difficulty,
                type: type,
                muscle: muscle,
            },
        })
        .catch(function(error) {
            if (error.response) {
                console.log(error.response.data);
                console.log(error.response.status);
                console.log(error.response.headers);
            }
        })
        .then((response) => {
            console.log(response.data);
            setExerciseData(response.data);
        })
    }
    
    const handleSubmit = e => {
        e.preventDefault()  
        fetchMultipleSearch()
  
    }

    return (
        <div className="exerciseList">
            <h1>Exercise Search</h1>
            <h3>Search your favorite exercises by muscle group, workout type, difficulty, or name!</h3>
            <p>Click on the exercise to view a short description of each exercise!</p><br/>
            <form onSubmit={handleSubmit}>
                <label>Search by:</label>
             <select value={muscle} onChange={(e)=>setMuscle(e.target.value)}>
                <option value="">Muscle Group</option>
                <option value="biceps">Biceps</option>
                <option value="triceps">Triceps</option>
                <option value="abdominals">Abs</option>
                <option value="chest">Chest</option>
                <option value="glutes">Glutes</option>
                <option value="lower_back">Lower Back</option>
                <option value="middle_back">Middle Back</option>
                <option value="lats">Lats</option>
                <option value="traps">Traps</option>
                <option value="quadriceps">Quads</option>
                <option value="hamstrings">Hamstrings</option>
                <option value="calves">Calves</option>
             </select>
             <select value={type} onChange={(e)=>setType(e.target.value)}>
                <option value="">Workout Type</option>
                <option value="cardio">Cardio</option>
                <option value="olympic_weightlifting">Weight Lifting</option>
                <option value="plyometrics">Plyometrics</option>
                <option value="strength">Strength</option>
                <option value="stretching">Stretching</option>
                <option value="powerlifting">Power Lifting</option>
             </select>
             <select value={difficulty} onChange={(e)=>setDifficulty(e.target.value)}>
                <option value="">Difficulty</option>
                <option value="beginner">Beginner</option>
                <option value="intermediate">Intermediate</option>
                <option value="expert">Advanced</option>
             </select>
             <input type="text" value={name} placeholder="Search by name" onChange={(e)=>setName(e.target.value)} />
            <input className="submit" type="submit" />
            </form>
        {exercises.map((exercise, index) => (
        <div className="flip-card" key={index}>
            <div className="flip-card-inner">
                <div className="flip-card-front" onClick= {handleClick(index)}>
                <b>Name:</b> { exercise.name }<br/>
                <b>Type:</b> { exercise.type }<br />
                <b>Muscle Group:</b> { exercise.muscle }<br />
                <b>Equipment:</b> { exercise.equipment } <br />
                <b>Difficulty: </b> { exercise.difficulty }<br/>     
                </div>
                {clickedIndex[index] ? <div className="flip-card-back">
                <b>Description:</b>
                { exercise.instructions }
                </div> : !isActive}
            </div>    
        </div>
        ))}
        </div>
    )}

    export default Exercises;
