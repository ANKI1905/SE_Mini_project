import React, {Component} from "react"
import ReactDOM from "react-dom"

class StudentLoginPage extends Component {
    render() {
        return (
            <div className="container">
                <h1>MealOn</h1>
		        <h2>Student Login</h2>
		        <div class="align_center">
			    <form action="studentauth" method="post">
				<input class ="form_data" required="required" type="number" name="mis" placeholder="mis" maxlength="9" /><br></br>
				<br></br>
				<input class ="form_data" required="required" type="password" name="Password" placeholder="password" /><br></br>
				<br></br>
				<input class="green_btn medium_btn" type="submit" value="Login" />
				</form>
				</div>
            </div>
        )
    }
}

export default StudentLoginPage;