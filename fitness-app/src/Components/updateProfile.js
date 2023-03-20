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
const id = 1;
const [profileData, setProfileData] = useState([]);

useEffect(() => {
    axios.get(`http://localhost:9000/profile/1`)
    .then((response) => {
        setProfileData(response.data);
    })
}, [])

useEffect(()=> {
    setFirstName(profileData.firstName);
    setLastName(profileData.lastName);
    setAge(profileData.age);
    setCurrentWeight(profileData.currentWeight);
    setGoalWeight(profileData.goalWeight);
    setHeight(profileData.height);
}, [profileData.firstName, profileData.lastName, profileData.age, profileData.currentWeight, profileData.goalWeight, profileData.height])


const handleSubmit = e => {
    e.preventDefault();
    const updatedPerson = {
      firstName,
      lastName,
      age,
      currentWeight,
      goalWeight,
      height
    };
    axios.put(`http://localhost:9000/profile/update/${id}`, updatedPerson, {
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => {
        console.log(response.data);
      })
      .catch(error => {
        console.error(error);
      });

      window.location.reload(false);
  }

return (
    <div className="updateProfile">
    <h1>Update your information in the following fields:</h1>
<form onSubmit={handleSubmit}>
    <div className="eachInput"><label>First Name: </label><input type="text" name="firstName" value={firstName} onChange={(e) => setFirstName(e.target.value)}/><br/></div>
    <label>Last Name: </label><input type="text" name="lastName" value={lastName} onChange={(e) => setLastName(e.target.value)}/><br/>
    <label>Age: </label><input type="number" name="age" value={age} onChange={(e) => setAge( e.target.value)}/><br/>
    <label>Current Weight(in lbs): </label><input type="number" value={currentWeight} name="currentWeight" onChange={(e) => setCurrentWeight( e.target.value)}/><br/>
    <label>Goal Weight(in lbs): </label><input type="number" name="goalWeight" value={goalWeight} onChange={(e) => setGoalWeight(e.target.value)}/><br/>
    <label>Height(in inches): </label><input type="number" name="height" value={height} onChange={(e) => setHeight( e.target.value)}/><br/>
    <input type="submit" name="submit" className="submit" />
</form>
</div>
)
}

