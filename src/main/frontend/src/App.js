import './App.css';
import { Route } from 'react-router';
import News from './news/News';
import Profile from './profile/Profile'
import { BrowserRouter } from 'react-router-dom';
import Login from './login/Login';
import 'bootstrap/dist/css/bootstrap.min.css';
import NaviBar from './components/NaviBar';
import SignupForm from './signup/SignupForm';
import Home from './components/Home';
import ReactCalendar from './components/ReactCalendar';


const App = () => {
  return (
    <BrowserRouter>
      <div className="App">
        <NaviBar />
        <div className="App-content">
          <Route path="/home" component={Home}/>
          <Route path="/profile" component={ Profile }/>
          <Route path="/news" component={ News }/>
          <Route path="/login" component={ Login }/>
          <Route path="/signup" component={ SignupForm }/>
        </div>
      </div>
    </BrowserRouter>);
}

export default App;
