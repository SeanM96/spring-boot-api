import React, {Component} from 'react';
import './styleLanding.css';
import error from './images/404-dog.png';
import logo from './images/logo-round.png';

class App extends Component {

  render() {
    return (
        <div>
          <header>
            <img src={logo} className="logo" alt="logo"/>
          </header>
        </div>
    );
  }
}

class Info extends Component {

  render() {
    return(
      <div className="content">

  <h1 className="mainHeader">Coursemates</h1>

  <h2>Connect.</h2>

  <p>Coursemates is set to launch a centralised online platform for students across the UK, with personalised hubs for different subject areas.</p>

  <h2>Share.</h2>

  <p>Coursemates was founded on the idea that, regardless of where you are studying, you should be able to share ideas, experiences and knowledge with other students.</p>

  <h2>Learn.</h2>

  <p>Coursemates believes that no matter what your University teaches, you should have access to all knowledge surrounding your subject.</p>  <h1 class="emailInstruction">Be one of the first.</h1>

    <form className="form" id="myForm" method="POST" action="/sign-up">

      <input className="email" id="firstName" type="text" name="firstName" placeholder="First Name" required='true'/>

      <input className="email" id="surname" type="text" name="surname" placeholder="Surname"/>

      <input className="email" id="email" type="email" name="email" placeholder="Email me when we launch"/>

      <input className="email" id="consent" type="checkbox" name="consent" required/>

      <label className="email label-text">I would like to subscribe to updates from Coursemates</label>

      <input className="submitButton" type="submit" value="submit"/>

    </form>

    <div className="socialMedia">

      <a href="https://www.facebook.com/Coursemates-529717987493728" target="_blank"> <i className="fa fa-facebook-square"></i></a>

      <a href="https://twitter.com/CoursematesSite" target="_blank"><i className="fa fa-twitter"></i></a>

      <a href="https://instagram.com/coursemates" target="_blank"><i className="fa fa-instagram"></i></a>

    </div>

    <div className="footer">

      <a href="/">Home</a> 

      <a href="privacy">Privacy</a>

      <p className="copyright">© Sean Martin and Team Netsol</p>

  </div>  </div>
    );
  
  }
}

export default App;
export Info;
