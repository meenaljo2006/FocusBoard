import { useState } from "react";
import Logo from "../components/logo.jsx"
import Footer from "../components/footer.jsx"
import './register.css'

import { FcGoogle } from "react-icons/fc"; // Google icon
import { FaFacebook, FaGithub } from "react-icons/fa"; // Facebook and GitHub

import { auth,googleProvider } from "../firebase.js";
import { createUserWithEmailAndPassword,signInWithPopup,signInWithEmailAndPassword } from "firebase/auth";
import { updateProfile } from "firebase/auth";

import { motion } from "framer-motion";

import { Link,useNavigate } from 'react-router-dom'; 


function Register() {

  const [isSignIn, setIsSignIn] = useState(true);

  const[email,setEmail] = useState("");
  const[password,setPassword] = useState("");
  const[name,setName] = useState("");

  const [signInError, setSignInError] = useState("");
  const [signUpError, setSignUpError] = useState("");

  const navigate = useNavigate();



  const signUp = async (e) => {
    e.preventDefault();
    try{
        const userCredential = await createUserWithEmailAndPassword(auth,email,password);
        const user = userCredential.user;
        await updateProfile(user, {
          displayName: name,
        });

        console.log(auth.currentUser.email);
        setName("");
        setEmail("");
        setPassword("");
        setSignUpError("");
        
        await updateProfile(user, { displayName: name });
        navigate("/Dashboard"); //Redirect after signup

    } catch(error){
        console.error(error);
        if (error.code === "auth/invalid-email") {
          setSignUpError("Please enter a valid email address.");
        }
    }  
  };

  const signInWithGoogle = async (e) => {
    e.preventDefault();
    try{
        await signInWithPopup(auth,googleProvider);
        navigate("/Dashboard");
    } catch(error){
        console.error(error);
    }  
  };

  const signIn = async (e) => {
    e.preventDefault();
    try{
        await signInWithEmailAndPassword(auth,email,password);
        // alert("logged in succesfully");

        setEmail("");
        setPassword("");
        setSignInError("");

        navigate("/Dashboard"); //Redirect after signup

    } catch(error){
        console.error(error);
        if (error.code === "auth/invalid-credential") {
          setSignInError("User does not exist. Please register first.");
        } else if (error.code === "auth/wrong-password") {
            setSignInError("Incorrect password. Please try again.");
        } else if (error.code === "auth/invalid-email") {
            setSignInError("Please enter a valid email address.");
        } else {
            setSignInError("Something went wrong. Please try again.");
        }
    };
  };


  return(
      <>
          <Link to="/"><Logo /></Link>
          <div className="mainBox">
              <div className={`box ${isSignIn ? '' : 'right-panel-active'}`}>

                  <div className="formBox RegisterBox">
                      <form>
                          <h1>Create Account</h1>
                          <div className="social-container">
                              <button onClick={signInWithGoogle}className="social"><FcGoogle size={24} /></button>
                              <button className="social"><FaGithub size={24}color="black" /></button>
                          </div>
                          <span>or use your email for registration</span>
                          <input type="text" placeholder="Name" value={name} onChange={(e) => setName(e.target.value) }></input>
                          <input type="email" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value) }></input>
                          <input type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)}></input>
                          {signUpError && <p className="error">{signUpError}</p>} 
                          <motion.button whileTap={{ scale: 0.85 }} onClick={signUp}>Sign Up</motion.button>
                          
                      </form>

                      <p className="toggleText">
                        Already have an account?{' '}
                        <span className="toggleLink" onClick={() => setIsSignIn(true)}>Login</span>
                      </p>

                  </div>
                  
                  <div className="formBox LoginBox">
                      <form>
                          <h1>Sign In</h1>
                          <div className="social-container">
                            <button onClick={signInWithGoogle}className="social"><FcGoogle size={24} /></button>
                            <button className="social"><FaGithub size={24}color="black" /></button>
                          </div>
                          <span>or use your email account</span>
                          <input type="email" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)}></input>
                          <input type="password" placeholder="Password" value={password}onChange={(e) => setPassword(e.target.value)}></input>
                          {signInError && <p className="error">{signInError}</p>}
                          <motion.button whileTap={{ scale: 0.85 }} onClick={signIn}>Sign In</motion.button>
                      </form>

                      <p className="toggleText">
                        Don't have an account?{' '}
                        <span className="toggleLink" onClick={() => setIsSignIn(false)}>Register</span>
                      </p>

                  </div>


                  <div className="overlay-container">
                    <div className="overlay">
                      <div className="overlay-panel overlay-left">
                        <h1>Welcome Back!</h1>
                        <p>To keep connected with us, Please Login.</p>
                        <motion.button whileTap={{ scale: 0.85 }} className="ghost" onClick={() => setIsSignIn(true)}>Sign In</motion.button>
                      </div>
                      <div className="overlay-panel overlay-right">
                        <h1>Hello, Friend!</h1>
                        <p>Enter your details and start journey with us.</p>
                        <motion.button whileTap={{ scale: 0.85 }} className="ghost" onClick={() => setIsSignIn(false)}>Sign Up</motion.button>
                      </div>
                    </div>
                  </div>
                  
              </div>

          </div>

          <Footer/>
             
      </>
  );
}

export default Register;