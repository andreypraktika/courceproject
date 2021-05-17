import './App.css';
import { Route } from 'react-router';
import News from './news/News';

import { BrowserRouter } from 'react-router-dom';
import Login from './login/Login';
import 'bootstrap/dist/css/bootstrap.min.css';
import NaviBar from './components/NaviBar';
import SignupForm from './signup/SignupForm';
import UserProfiles from './administration/UserProfiles';
import UserProfile from './profile/UserProfile';
import Main from './main/Main';
import CreateNews from './news/CreateNews'


const App = () => {
  return (
    <BrowserRouter>
      <div className="App">
        <NaviBar />
        <div className="App-content">
          {/* <Route path="/campaigns" component={UserCampaigns}/> */}
          <Route path="/home" component={Main}/>
          <Route path="/profile" component={UserProfile}/>
          <Route path="/news" component={ News }/>
          <Route path="/login" component={ Login }/>
          <Route path="/signup" component={ SignupForm }/>
          <Route path="/users" component={ UserProfiles }/>
          <Route path="/createnews" component={ CreateNews }/>
      
        </div>
      </div>
    </BrowserRouter>);
}

export default App;
