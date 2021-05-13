import React, {Component} from 'react'


export default class Profile extends React.Component {

    constructor(props) {
		super(props);
		this.state = {
			username: '',
			password: '',
		};
        this.onDidMount = this.onDidMount.bind(this)
	}

    onDidMount()
    {
        fetch('users/getcredentials')
        .then((response) => {
        return response.json();
    })
        .then((data) => {
        console.log(data);
    });
    }

    render() {
     return(<div>
         <h1>Profile</h1>
         </div>);   
    }
}
