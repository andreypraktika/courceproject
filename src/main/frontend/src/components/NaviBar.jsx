import React, { Component } from 'react'; 
import { Navbar, Nav, Form, NavItem, NavDropdown, MenuItem, FormControl, Button, Container } from 'react-bootstrap';
const NaviBar = () => {
    return (
    <>
    <Navbar bg="light" variant="light">
        <Container className="p-2">
        <Navbar.Brand className="ml-3" href="/home">My application</Navbar.Brand>
        <Nav>
            <Nav.Link href="/profile">Profile</Nav.Link>
            <Nav.Link href="/news">News</Nav.Link>
            <Nav.Link href="/login">Login</Nav.Link>
            <Nav.Link href="/signup">Sign up</Nav.Link>
        </Nav>
        
        <Navbar.Collapse className="justify-content-end">
        <Form>
            <FormControl type="text" placeholder="Search" />
            <Button variant="outline-primary">Search</Button>
        </Form>
        </Navbar.Collapse>
        </Container>
        
    </Navbar>
    <br/>
    </>
    );
}

export default NaviBar;
