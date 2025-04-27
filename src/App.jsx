import { useState,useEffect } from 'react'
import './App.css'
import Register from './pages/register'
import { motion } from "framer-motion";
import { BrowserRouter as Router, Route, Routes, useNavigate,Link } from 'react-router-dom';


import Logo from './components/logo'

function App() {

  const text = "Stay Organized. Stay Focused.";
  const [displayText, setDisplayText] = useState("");
  const [index, setIndex] = useState(0);
  const [isTyping, setIsTyping] = useState(true);

  useEffect(() => {
    let typingInterval;

    if (isTyping) {
      typingInterval = setInterval(() => {
        if (index < text.length) {
          setDisplayText((prev) => prev + text.charAt(index));
          setIndex((prev) => prev + 1);
        } else {
          clearInterval(typingInterval);
          setTimeout(() => {
            setDisplayText("");
            setIndex(0);
          }, 3000); // 5 seconds pause after typing finishes
        }
      }, 100); // Speed of typing (100ms per character)
    }

    return () => clearInterval(typingInterval);
  }, [index, isTyping, text]);

  const navigate = useNavigate()
  // Function to handle button click and redirect to Register page
  const handleGetStartedClick = () => {
    navigate('/Register'); // Redirects to the Register page
  };

  return (

    <Routes> 
      <Route path="/" element={
        <>
          <header className='header'>
            <Link to="/"><Logo /></Link>
          </header>
          
          <div className="main">
            <div className="left">
              <p className='title'>{displayText}<span className="cursor">|</span></p>
              <p className='desc'>Unlock Your Full Potential by Mastering Every Task.</p>
              <motion.button whileTap={{ scale: 0.85 }} onClick={handleGetStartedClick}>Get Started</motion.button>
            </div>
            <div className="right">
              <img src="src/assets/home.png" alt="Home" />
            </div>
          </div>
        </>
      } />
      <Route path="/Register" element={<Register />} /> {/* Register page route */}
    </Routes>
    
  )
}

export default App
