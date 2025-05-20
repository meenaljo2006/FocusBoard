import { useState,useEffect } from 'react'
import './home.css'

import { motion } from "framer-motion";
import Footer from "../components/footer.jsx"
import FAQ from "../components/faq.jsx"

import { Link as ScrollLink} from 'react-scroll';

import { useNavigate} from 'react-router-dom';


import Logo from '../components/logo'

function Home() {

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
    <>
        <header className='header'>
        <a href="/"><Logo /></a>

        <nav className="navbar">
            <ScrollLink to="features" smooth={true} duration={500} offset={-70} className="navbar-link">Features</ScrollLink>
            <ScrollLink to="demo" smooth={true} duration={500} offset={-60} className="navbar-link">Watch Demo</ScrollLink>
            <ScrollLink to="faq" smooth={true} duration={500} offset={-80} className="navbar-link">FAQ</ScrollLink>
        </nav>

        </header>
        
        <div className="main">
        <div className="left">
            <p className='title'>{displayText}<span className="cursor"></span></p>
            <p className='desc'>Take control of your productivity with our intuitive focus board. Plan your tasks, track your progress, and achieve your goals with ease.</p>
            <motion.button whileTap={{ scale: 0.85 }} onClick={handleGetStartedClick}>Get Started</motion.button>
        </div>
        <div className="right">
            <img src="/assets/home.png" alt="Home" />
        </div>
        </div>
        
        <section id="features" class="features">
        <h1>Powerful Tools to Boost Your Productivity</h1>
        <div className="cardSection">
            <div className="feature-card">
                <img src="/assets/Taskmanagement.png" alt="Task Management Icon" class="feature-icon"></img>
                <h3 class="feature-title">Task Management</h3>
                <p>Organize your tasks with customizable boards. Drag and drop for easy prioritization.</p>
            </div>
            <div className="feature-card">
                <img src="/assets/progressTracking.jpg" alt="Progress Tracking Icon" class="feature-icon"></img>
                <h3 class="feature-title">Progress Tracking</h3>
                <p>Visualize your achievements and track progress toward your goals in real-time.</p>
            </div>
            <div className="feature-card">
                <img src="/assets/focusTimer.jpg" alt="Focus Timer Icon" class="feature-icon"></img>
                <h3 class="feature-title">Focus Timer</h3>
                <p>Enhance productivity with built-in Pomodoro timers and focus sessions.</p>
            </div>
        </div>
        </section>

        <section id="demo" className="demoVideo">
        <h1>See Focus Board in Action</h1>
        <video controls autoPlay muted loop>
            <source src="/assets/demo.mp4" type="video/mp4"></source>
            Your browser does not support the video tag.
        </video>
        </section>

        <section id="faq" className="faq">
        <h1>Frequently Asked Questions</h1>
        <div className="question">
            <FAQ/>
        </div>
        </section>

        {/* <Footer/> */}
    
    </>
      
    
  )
}

export default Home
