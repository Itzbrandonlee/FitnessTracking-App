import images from './Bodybuilder-Working-Out-His-Uppe.png';
import '../CSS/home.css';


function Home(){
    return(
        <div className="homePage">
            
            <div className="homePhoto">
                <img src={images} alt="Home Page"/>
            </div>
            <div className="info">
                <h1>Get Started Today!</h1>
                <h3>Click Here to Sign Up!</h3>
                <p>Get started today to take advantage of some of our amazing offers:</p>
                <ul>
                    <li>Customize your profile to track your progress!</li>
                    <li>Search tons of workouts through various search criteria</li>
                    <li>Track and remember your workouts!</li>
                    <li>And so much more!</li>
                </ul>
            </div>
        </div>
    );
}


export default Home;