import React, {Component} from 'react';

export default class Home extends Component {
    
    render() {
        return(
                <p>Hello jopa</p>);
    }

    componentDidMount() {
        fetch('test');
    }
}