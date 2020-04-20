import React from "react"
import ReactDOM from "react-dom"
function Homepage () {
    return (
        <div className="home" >
            <h1> MealOn </h1>
            <h2> Yes!! The Meal is Onn </h2>   
            <p className="align_center">
            <form action="studentlogin">
            <input class = "green_btn big_btn" type="submit" title="If you want to access student features" value="Student Features" />
            </form>
            <br></br>
            <br></br>
            <form action="adminlogin">
            <input class = "green_btn big_btn" type="submit" title="If you want to access Admin Features" value="Mess Admin Features"/>
            </form> 
            </p>  
        </div>
    )
}

export default Homepage; 

