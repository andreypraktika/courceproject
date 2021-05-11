import React from 'react';
import {useFormik} from 'formik';
import axios from 'axios';
import { Navbar, Nav, Form, NavItem, NavDropdown, MenuItem, FormControl, Button, Container } from 'react-bootstrap'; 
 
const validate = (values) => {
   const errors = {};
   if (!values.username) {
     errors.username = 'Username is required';
   } 
   if (!values.password) {
     errors.password = 'Password is required';
   } 

   return errors;
 };
 
 const LoginForm = () => {
   const formik = useFormik({
     initialValues: {
       username: '',
       password: '',
     },
     validate,
     onSubmit: values => {
       alert(JSON.stringify(values, null, 2));
       axios.post("http://localhost:8080/reactlogin", values).then(response => {
         console.log(response)
       })
       .catch(error => console.log(error))
     },
   });

   return (
     <form onSubmit={formik.handleSubmit}>
       <label htmlFor="username">Username</label>
       <input
         id="username"
         name="username"
         type="text"
         onChange={formik.handleChange}
         value={formik.values.username}
       />
       {formik.errors.username ? <div>{formik.errors.username}</div> : null}
 
       <label htmlFor="password">Password</label>
       <input
         id="password"
         name="password"
         type="text"
         onChange={formik.handleChange}
         value={formik.values.password}
       />
       {formik.errors.password ? <div>{formik.errors.password}</div> : null}
       <button type="submit">Submit</button>
     </form>
   );
 };

 export default LoginForm;