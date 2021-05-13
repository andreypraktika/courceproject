import React from 'react';
import {useFormik} from 'formik';
import { Navbar, Nav, Form, NavItem, NavDropdown, MenuItem, FormControl, Button, Container } from 'react-bootstrap'; 
import axios from 'axios';

 const validate = values => {
   const errors = {};
   if (!values.firstName) {
     errors.firstName = 'Required';
   } else if (values.firstName.length > 15) {
     errors.firstName = 'Must be 15 characters or less';
   }
   if (!values.lastName) {
     errors.lastName = 'Required';
   } else if (values.lastName.length > 20) {
     errors.lastName = 'Must be 20 characters or less';
   }
   if (!values.email) {
     errors.email = 'Required';
   } else if (!/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(values.email)) {
     errors.email = 'Invalid email address';
   }
   return errors;
 };
 
 const SignupForm = () => {
  
   const formik = useFormik({
     initialValues: {
       firstName: '',
       lastName: '',
       email: '',
       username:'',
       password:''
     },
     validate,
     onSubmit: values => {
      fetch('/register', {
         headers: {
           'Content-Type':'application/json'
         },
         method:'POST',
         body:JSON.stringify(values)
       })
     }
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
       <label htmlFor="email">Email Address</label>
       <input
         id="email"
         name="email"
         type="email"
         onChange={formik.handleChange}
         value={formik.values.email}
       />
       {formik.errors.email ? <div>{formik.errors.email}</div> : null}

       <label htmlFor="firstName">First Name</label>
       <input
         id="firstName"
         name="firstName"
         type="text"
         onChange={formik.handleChange}
         value={formik.values.firstName}
       />
       {formik.errors.firstName ? <div>{formik.errors.firstName}</div> : null}
 
       <label htmlFor="lastName">Last Name</label>
       <input
         id="lastName"
         name="lastName"
         type="text"
         onChange={formik.handleChange}
         value={formik.values.lastName}
       />
       {formik.errors.lastName ? <div>{formik.errors.lastName}</div> : null}

       <Button variant="primary" type="submit">Submit</Button>
     </form>
   );
 };

 export default SignupForm;