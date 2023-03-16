import '../CSS/profile.css';
import React, { useEffect, useState } from 'react';
import axios from 'axios';

export default function UpdateProfile() {
const [firstName, setFirstName] = useState('');
const [lastName, setLastName] = useState('');
const [age, setAge] = useState('');
const [currentWeight, setCurrentWeight] = useState('');
const [goalWeight, setGoalWeight] = useState('');
const [height, setHeight] = useState('');
const [id, setId] = useState(null);


useEffect(() => {
    setId(localStorage.getItem('ID'))
    setFirstName(localStorage.getItem('First Name'))
    setLastName(localStorage.getItem('Last Name'))
    setAge(localStorage.getItem('Age'))
    setCurrentWeight(localStorage.getItem('Current Weight'))
    setGoalWeight(localStorage.getItem('Goal Weight'))
    setHeight(localStorage.getItem('Height'))
}, []);

const setData = (data) => {
    let { id, firstName, lastName, age, currentWeight, goalWeight, height } = data;
    localStorage.setItem('ID', id);
    localStorage.setItem('First Name', firstName);
    localStorage.setItem('Last Name', lastName);
    localStorage.setItem('Age', age);
    localStorage.setItem('Current Weight', currentWeight);
    localStorage.setItem('Goal Weight', goalWeight);
    localStorage.setItem('Height', height);
    
}
const updateData = () => {
    axios.put(`http://localhost:8080/profile/update/1`, {
        firstName,
        lastName,
        age,
        currentWeight,
        goalWeight,
        height
},
        {
            headers: {
                'Content-Type': 'application/json'
            }
        
        })
}


return (
    <div className="updateProfile">
    <h1>Update your information in the following fields:</h1>
<form>
    <label>First Name: </label><input type="text" name="firstName" value={firstName || ''} onChange={(e) => setFirstName(e.target.value)}/><br/>
    <label>Last Name: </label><input type="text" name="lastName" value={lastName || ''} onChange={(e) => setLastName(e.target.value)}/><br/>
    <label>Age: </label><input type="number" name="age" value={age || ''} onChange={(e) => setAge( e.target.value)}/><br/>
    <label>Current Weight(in lbs): </label><input type="number" value={currentWeight || ''} name="currentWeight" onChange={(e) => setCurrentWeight( e.target.value)}/><br/>
    <label>Goal Weight(in lbs): </label><input type="number" name="goalWeight" value={goalWeight || ''} onChange={(e) => setGoalWeight(e.target.value)}/><br/>
    <label>Height(in inches): </label><input type="number" name="height" value={height || ''} onChange={(e) => setHeight( e.target.value)}/><br/>
    <button name="submit" type="button" className="submit" onClick={updateData}>Update</button>
</form>
</div>
)
}

