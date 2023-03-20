import '../CSS/profile.css';
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import UpdateProfile from '../Components/updateProfile'

    function ProfileInfo(){
        const [profileData, setProfileData] = useState([]);

        useEffect(() => {
            axios.get(`http://localhost:9000/profile/1`)
            .then((response) => {
                setProfileData(response.data);
            })
        }, [])
    
        return (
            <div className="profileInfo">
                <div className="currentProfile">
                    <h1>Profile Information:</h1>
                    <p><b>Name:</b> { profileData.firstName } { profileData.lastName}<br/>
                    <b>Age:</b> { profileData.age }<br />
                    <b>Current Weight:</b> { profileData.currentWeight }pounds<br />
                    <b>Goal Weight:</b> { profileData.goalWeight } pounds<br />
                    <b>Height:</b> { profileData.height }inches<br/>
                    </p>
                </div>
                <UpdateProfile />
        </div>
    );
}
export default ProfileInfo;



