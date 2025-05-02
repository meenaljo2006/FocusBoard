import React, { useState,useEffect } from 'react';
import './timer.css';
import Sidebar from '../components/sidebar';
import { CountdownCircleTimer } from 'react-countdown-circle-timer';
import { motion } from "framer-motion";

const FocusTimer = () => {
    const [customTime, setCustomTime] = useState(1500); // in seconds
    const [key, setKey] = useState(0); // used to reset timer
    const [isPlaying, setIsPlaying] = useState(false);

    const handleStart = () => {
        setIsPlaying(true);
    };

    const handlePause = () => {
        setIsPlaying(false);
    };

    const handleReset = () => {
        setIsPlaying(false);
        setKey(prev => prev + 1); // triggers re-render of timer
    };

    const formatTime = (remainingTime) => {
    const minutes = Math.floor(remainingTime / 60);
    const seconds = remainingTime % 60;
    return `${minutes < 10 ? '0' : ''}${minutes}:${seconds < 10 ? '0' : ''}${seconds}`;
    };

    const [circleSize, setCircleSize] = useState(220);

    useEffect(() => {
        const handleResize = () => {
            const width = window.innerWidth;
            if (width < 400) {
            setCircleSize(150);
            } else if (width < 768) {
            setCircleSize(200);
            } else {
            setCircleSize(220);
            }
        };

        handleResize(); // Set initial size
        window.addEventListener('resize', handleResize);
        return () => window.removeEventListener('resize', handleResize);
    }, []);


  return (
    <>
      <Sidebar />
      <div className="focus-timer-container">
        <div className="focus-timer">
            <h1>Focus Timer</h1>

            {/* Time Selector */}
            <div className="time-selector">
                <label>Select Duration: </label>
                <select
                    value={customTime}
                    onChange={(e) => {
                    setCustomTime(parseInt(e.target.value));
                    setKey(prev => prev + 1);
                    setIsPlaying(false);
                    }}
                >
                    <option value={300}>5 minutes</option>
                    <option value={900}>15 minutes</option>
                    <option value={1500}>25 minutes</option>
                    <option value={1800}>30 minutes</option>
                    <option value={3600}>1 hour</option>
                </select>
            </div>

            {/* Countdown Circle */}
            <div className="timer">
                <CountdownCircleTimer
                    key={key}
                    isPlaying={isPlaying}
                    duration={customTime}
                    colors="#4CAF50"
                    trailColor="#d9d9d9"
                    strokeWidth={12}
                    size={circleSize}
                    onComplete={() => {
                    setIsPlaying(false);
                    alert("Time's up!");
                    return { shouldRepeat: false };
                    }}
                >
                {({ remainingTime }) => (
                    <div className="time-text">{formatTime(remainingTime)}</div>
                )}
                </CountdownCircleTimer>
            </div>

            {/* Controls */}
            <div className="controls">
            {!isPlaying ? (
                <motion.button onClick={handleStart}>Start</motion.button>
            ) : (
                <motion.button onClick={handlePause}>Pause</motion.button>
            )}
                <motion.button onClick={handleReset}>Reset</motion.button>
            </div>
            
        </div>
      </div>
    </>
  );
};

export default FocusTimer;
