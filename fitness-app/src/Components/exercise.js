import React, { useState, useEffect } from 'react'
import axios from 'axios';
import '../CSS/exercises.css'

// render() {
//     return (
//         <input type="text" name="muscleSearch" onChange={(e) => this.setState({value: e.target.value})} />
//     )
// }
// }

function Exercises(){
    const [exercises, setExerciseData] = useState([])
    const [isActive, setIsActive] = useState(false)
    const[clickedIndex, setClickedIndex] = useState({})

    const handleClick = (index) => () => {
        setClickedIndex(state => ({
            ...state,
            [index]: !state[index],
            isActive: !isActive
        }));
    }
    useEffect(() => {
        axios.get(`http://localhost:9000/exercises/muscle/biceps`)
        .catch(function(error) {
            if (error.response) {
                console.log(error.response.data);
                console.log(error.response.status);
                console.log(error.response.headers);
            }
        })
        .then((response) => {
            setExerciseData(response.data);
        })
    }, [])
    
    return (
        <div className="exerciseList">
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
