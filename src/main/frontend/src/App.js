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


const App = () => {
  return (
    <BrowserRouter>
      <div className="App">
        <NaviBar />
        <div className="App-content">
          {/* <Route path="/campaigns" component={UserCampaigns}/> */}
          <Route path="/profile" component={UserProfile}/>
          <Route path="/news" component={ News }/>
          <Route path="/login" component={ Login }/>
          <Route path="/signup" component={ SignupForm }/>
          <Route path="/users" component={ UserProfiles }/>
        </div>
      </div>
    </BrowserRouter>);
}

export default App;
