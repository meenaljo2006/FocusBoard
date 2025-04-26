import { useState } from "react";
import Logo from "../components/logo.jsx"
import './register.css'
function Register() {

  const [isSignIn, setIsSignIn] = useState(true);

  return(
      <>
          <Logo/>
          <div className="main">
              <div className={`box ${isSignIn ? '' : 'right-panel-active'}`}>
                  <div className="formBox RegisterBox">
                      <form>
                          <h1>Create Account</h1>
                          <div className="social-container">
                              <a href="#" className="social">G</a>
                              <a href="#" className="social">f</a>
                              <a href="#" className="social">Git</a>
                          </div>
                          <span>or use your email for registration</span>
                          <input type="text" placeholder="Name" />
                          <input type="email" placeholder="Email" />
                          <input type="password" placeholder="Password" />
                          <button>Sign Up</button>
                          
                      </form>
                  </div>
                  
                  <div className="formBox LoginBox">
                      <form>
                          <h1>Sign In</h1>
                          <div className="social-container">
                              <a href="#" className="social">G</a>
                              <a href="#" className="social">f</a>
                              <a href="#" className="social">Git</a>
                          </div>
                          <span>or use your email account</span>
                          <input type="email" placeholder="Email" />
                          <input type="password" placeholder="Password" />
                          <a href="#">Forgot your password?</a>
                          <button>Sign In</button>
                      </form>
                  </div>


                  <div className="overlay-container">
      <div className="overlay">
        <div className="overlay-panel overlay-left">
          <h1>Welcome Back!</h1>
          <p>To keep connected with us, please login with your personal info</p>
          <button className="ghost" onClick={() => setIsSignIn(true)}>
            Sign In
          </button>
        </div>
        <div className="overlay-panel overlay-right">
          <h1>Hello, Friend!</h1>
          <p>Enter your details and start journey with us</p>
          <button className="ghost" onClick={() => setIsSignIn(false)}>
            Sign Up
          </button>
        </div>
      </div>
    </div>
                  
              </div>
              

          </div>

      

          
      </>
  );
}

export default Register;