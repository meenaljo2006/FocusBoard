import { Routes, Route } from "react-router-dom";
import Home from "./pages/home"; 
import Register from "./pages/register";
import Dashboard from "./pages/dashboard";
import FocusTimer from './pages/timer';


const AppRoutes = () => {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/Register" element={<Register />} />
      <Route path="/Dashboard" element={<Dashboard />} />
      <Route path="/FocusTimer" element={<FocusTimer />} />


      
    </Routes>
  );
};

export default AppRoutes;
