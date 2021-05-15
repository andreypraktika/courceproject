import React, {Component} from "react";
import Form from "react-bootstrap/Form";
import {Button,Card} from "react-bootstrap";
export default class Login extends Component {

	constructor(props) {
		super(props);
		this.state = {
			username: '',
			password: '',
			message: ''
		};
		this.handleChange = this.handleChange.bind(this);
		this.handleRegisterClick = this.handleRegisterClick.bind(this);
	}

	handleChange(event) {
		this.setState({
			[event.target.name]: event.target.value
		});
	}

	handleRegisterClick(event) {
		console.log('Try to register', this.state.username, this.state.password)
		const body = {
			username: this.state.username,
			password: this.state.password
		};
		fetch('/authenticate', {
			method: 'POST',
			body: JSON.stringify(body),
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(response => {
			if (response.status === 200) {
				localStorage.setItem("username", this.state.username)
				console.log("LOGGED IN!");
				this.props.history.push('/profile');
			} else if (response.status === 401) {
				this.setState({
					message: "Wrong credentials"
				})
			} else {
				this.setState({
					message: "Something went wrong!"
				})
			}
		});
		event.preventDefault();
	}

	render() {
		return (
			<>
			<div style={{margin:'0 auto', width: '28rem'}}>
				<Form>
					<Card border="primary" >
						<Card.Header>
							<Form.Text><h3>Login</h3></Form.Text>
							<Form.Text className="text-muted">
							{this.state.message ? this.state.message : ''}
							</Form.Text>
						</Card.Header>
    			<Card.Body>
      				<Card.Text>
					  <Form.Group controlId="formBasicEmail">
					<Form.Label>Username</Form.Label>
					<Form.Control onChange={this.handleChange} type="text" placeholder="Username"
								  name="username"/>
				</Form.Group>

				<Form.Group controlId="formBasicPassword">
					<Form.Label>Password</Form.Label>
					<Form.Control onChange={this.handleChange} type="password"
								  placeholder="Password" name="password"/>
				</Form.Group>
				<Form.Group style={{marginTop:'15px'}} controlId="formBasicCheckbox" >
					<Form.Check type="checkbox" label="Check me out" />
				</Form.Group>
				<Button style={{marginTop:'10px'}}variant="primary" type="submit" onClick={this.handleRegisterClick}>
					Login
				</Button>
      				</Card.Text>
    			</Card.Body>
  			</Card>
			  </Form>	
			</div>
			</>
		);
	}

}