import React from 'react'
const Credencials = () => {

    fetch('http://localhost:8080/users/getcredentials')
  .then((response) => {
    return response.json();
  })
  .then((data) => {
    console.log(data);
  });

}
export default Credencials;
