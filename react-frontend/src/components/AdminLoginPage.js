import React, {Component} from "react"
import ReactDOM from "react-dom"

class AdminLoginPage extends Component {
    render() {
        return (
            <div className="container">
                <h1>MealOn</h1>
		        <h2>Admin Login</h2>
		        <div class="align_center">
			    <form action="adminauth" method="post">
				<input class ="form_data" required="required" name="mess_id" placeholder="mis" maxlength="9" /><br></br>
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

export default AdminLoginPage;