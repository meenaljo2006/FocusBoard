import { useState, useEffect,useRef } from "react";
import { Home, Hourglass, LogOut } from "lucide-react";
import "./sidebar.css"; 
import { auth } from "../firebase";

import { onAuthStateChanged,signOut } from "firebase/auth";
import { useLocation, useNavigate } from "react-router-dom";



const menuItems = [
  { icon: <Home size={20} />, label: "Dashboard" , path:"/Dashboard"},,
  { icon: <Hourglass size={20} />, label: "Focus Timer", path:"/FocusTimer"},
  { icon: <LogOut size={20} />, label: "Logout" }
];

export default function Sidebar() {

  const sidebarRef = useRef(null);

  // Close sidebar on outside click
  useEffect(() => {
    function handleClickOutside(event) {
      if (sidebarRef.current && !sidebarRef.current.contains(event.target)) {
        setIsCollapsed(true); // collapse the sidebar
      }
    }

    document.addEventListener("mousedown", handleClickOutside);
    return () => {
      document.removeEventListener("mousedown", handleClickOutside);
    };
  }, []);

  const location = useLocation();
  const navigate = useNavigate();

  const [isCollapsed, setIsCollapsed] = useState(true);
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

    const handleLogout = async () => {
      try {
        await signOut(auth);
        navigate("/"); // or "/home" if your home page is at that route
      } catch (error) {
        console.error("Error logging out:", error);
      }
    };
      

  return (
    <div ref={sidebarRef} className={`sidebar ${isCollapsed ? 'collapsed' : ''}`}>

      
      {/* Header */}
      <div className="sideHeader">
        
        <span className="logo-text"> {!isCollapsed && "Focus Board"}</span>
        <button className="collapsingBtn" onClick={() => setIsCollapsed(!isCollapsed)} ><img src="\assets\icon.png"></img></button>
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

          return(
            <div
              key={index}
              className={`menu-item ${isCollapsed ? 'collapsed' : ''} ${isActive ? 'active' : ''}`}
              onClick={() => {
                if (item.label === "Logout") {
                  handleLogout();
                } else {
                  navigate(item.path);
                }
              }}
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
