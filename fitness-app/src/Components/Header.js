import {Link} from 'react-router-dom'
import '../CSS/App.css';


export default function header() {
    return ( 

    <header className="App-header">
        <h1>GymMate</h1>
        <p>Your number one fitness pal</p>

        <div className="Nav">
            <Link className="link-styles" to="/">Home</Link>
            <Link className="link-styles" to="/search">Search</Link>
            <Link className="link-styles" to="/workouts">Workouts</Link>
            <Link className="link-styles" to="/profile">Profile</Link>
            
        </div>
    </header>
    )
}