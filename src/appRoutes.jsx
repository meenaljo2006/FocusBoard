import { Routes, Route } from "react-router-dom";
import Home from "./pages/home"; 
import Register from "./pages/register";
import Dashboard from "./pages/dashboard";

const AppRoutes = () => {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/Register" element={<Register />} />
      <Route path="/Dashboard" element={<Dashboard />} />
    </Routes>
  );
};

export default AppRoutes;
