import { useState, useEffect } from "react";
import { Home, FolderKanban, Hourglass, LogOut } from "lucide-react";
import "./sidebar.css"; 
import { auth } from "../firebase";

import { onAuthStateChanged } from "firebase/auth";
import { useLocation, useNavigate } from "react-router-dom";



const menuItems = [
  { icon: <Home size={20} />, label: "Dashboard" , path:"/Dashboard"},
  { icon: <FolderKanban size={20} />, label: "Projects"},
  { icon: <Hourglass size={20} />, label: "Focus Timer", path:"/FocusTimer"},
  { icon: <LogOut size={20} />, label: "Logout" }
];

export default function Sidebar() {

  const location = useLocation();
  const navigate = useNavigate();

  const [isCollapsed, setIsCollapsed] = useState(false);
  const [userInitial, setUserInitial] = useState("");
  const [displayName, setDisplayName] = useState("");
  const [userEmail, setUserEmail] = useState("");

  useEffect(() => {
      const unsubscribe = onAuthStateChanged(auth, async (user) => {
        if (user) {
          const updatedUser = auth.currentUser;
          const name = updatedUser.displayName || updatedUser.email;
          setDisplayName(name);
          setUserInitial(name?.charAt(0).toUpperCase());
          setUserEmail(updatedUser.email); // <-- this was missing!
        }
      });
    
      return () => unsubscribe();
    }, []);
      

  return (
    <div className={`sidebar ${isCollapsed ? 'collapsed' : ''}`}>
      {/* Header */}
      <div className="sideHeader">
        
        <span className="logo-text"> {!isCollapsed && "Focus Board"}</span>
        <button className="collapsingBtn" onClick={() => setIsCollapsed(!isCollapsed)} ><img src="src\assets\icon.png"></img></button>
      </div>

      {/* Profile */}
      <div className="profile">
        <div className="profile-initial">{userInitial}</div>
        {!isCollapsed && (
          <div className="profile-info">
            <h4>{displayName}</h4>
            <p>{userEmail}</p>
          </div>
        )}
      </div>

      {/* Menu Items */}
      <nav>
        {menuItems.map((item, index) => {
          const isActive = location.pathname === item.path;
          console.log(location.pathname);

          return(
            <div
              key={index}
              className={`menu-item ${isCollapsed ? 'collapsed' : ''} ${isActive ? 'active' : ''}`}
              onClick={() => navigate(item.path)}
            >
              {item.icon}
              {!isCollapsed && <span>{item.label}</span>}
            </div>
          );
        })}
      </nav>
    </div>
  );
}
