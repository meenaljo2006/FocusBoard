import { useState } from "react";
import { Home, FolderKanban, Hourglass, LogOut } from "lucide-react";
import "./sidebar.css"; 

const menuItems = [
  { icon: <Home size={20} />, label: "Dashboard" },
  { icon: <FolderKanban size={20} />, label: "Projects" },
  { icon: <Hourglass size={20} />, label: "Focus Timer" },
  { icon: <LogOut size={20} />, label: "Logout" }
];

export default function Sidebar() {
  const [isCollapsed, setIsCollapsed] = useState(false);
  const [darkMode, setDarkMode] = useState(false);

  return (
    <div className={`sidebar ${isCollapsed ? 'collapsed' : ''}`}>
      {/* Header */}
      <div className="header">
        <span className="logo-text">{!isCollapsed && "Focus Board"}</span>
        <button onClick={() => setIsCollapsed(!isCollapsed)} >☰</button>
      </div>

      {/* Profile */}
      <div className="profile">
        <img src="https://i.pravatar.cc/40" alt="Profile" />
        {!isCollapsed && (
          <div className="profile-info">
            <h4>Ajendra S.</h4>
            <p>UI/UX Designer</p>
          </div>
        )}
      </div>

      {/* Menu Items */}
      <nav className="flex-1">
        {menuItems.map((item, index) => (
          <div
            key={index}
            className={`menu-item ${isCollapsed ? 'collapsed' : ''}`}
          >
            {item.icon}
            {!isCollapsed && <span>{item.label}</span>}
          </div>
        ))}
      </nav>
    </div>
  );
}
