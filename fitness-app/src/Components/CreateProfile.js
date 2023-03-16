import './CSS/profile.css';
import React, { useState } from 'react';

export default function Create() {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [age, setAge] = ('');
    const [currentWeight, setCurrentWeight] = ('');
    const [goalWeight, setGoalWeight] = ('');
    const [height, setHeight] = ('');

    return (
        <div className="createProfile">
        <h1>Complete your profile to get started:</h1>
        <form>
            <label>First Name: </label><input type="text" placeholder="First name" name="name" /><br/>
            <label>Last Name: </label><input type="text" placeholder="Last name" name="name" /><br/>
            <label>Age: </label><input type="number" placeholder="25" name="age" /><br/>
            <label>Current Weight(in lbs): </label><input type="number" placeholder="160" name="currentWeight"/><br/>
            <label>Goal Weight(in lbs): </label><input type="number" placeholder="150"name="goalWeight"/><br/>
            <label>Height(in inches): </label><input type="number" placeholder="70"name="height" /><br/>
            <input type="submit" value="Create" className="submit" />
        </form>
        </div>
    );
}