import React, { useState } from "react";
import "../navbar.css";
import { ReactComponent as Logo } from "../../../../assets/logo.svg";
import { Link } from "react-router-dom";

const UserNavbar = () => {
  const [menuOpen, setMenuOpen] = useState(false);

  const handleMenuToggle = () => {
    setMenuOpen(!menuOpen);
  };

  return (
    <nav className="navbar">
      <div className="logo-container">
        <Logo className="logo" />
      </div>
      <button className="menu-button" onClick={handleMenuToggle}>
        Menu
      </button>
      <ul className={`menu-list ${menuOpen ? "show" : ""}`}>
        <li>
          <Link to="/user-page/trainings" className="nav-link">
            Trainings
          </Link>
        </li>
        <li>
          <Link to="/user-page/diets" className="nav-link">
            Diets
          </Link>
        </li>
        <li>
          <Link to="/user-page/account" className="nav-link">
            Account
          </Link>
        </li>
        <li>
          <Link to="/" className="nav-link">
            Logout
          </Link>
        </li>
      </ul>
    </nav>
  );
};

export default UserNavbar;