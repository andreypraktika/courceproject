import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Formik, Form, Field, ErrorMessage } from 'formik';

const News = () => {
    const [News, setNews] = useState([])
    const fetchUserProfiles = () => {
      axios.get("http://localhost:8080/news/all").then((res) => {
      console.log(res);
      const data = res.data;
      setNews(res.data);}
      )};
      useEffect(() => {
        fetchUserProfiles();
      }, []);
  
      return News.map((News,index) => {
        return (
          <div key={index}>
            <h1>News</h1>
            <h1>{News.newstitle}</h1>
            <p>{News.newstext}</p>
            <p>{News.date}</p>
          </div>)})
    
  }
  export default News;