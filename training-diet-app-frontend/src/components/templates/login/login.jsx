import React, { useState } from "react";
import { Link, Routes, Route, useNavigate } from "react-router-dom";
import { DoLogin } from "../../../sevices/login/login";
import "./login.css";
import backgroundSVG from "../../../assets/wave.svg";
import BackNavbar from "../navbar/backnavba";

const LoginPage = () => {
  const [password, setPassword] = useState("");
  const [email, setEmail] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    DoLogin(email, password)
      .then((response) => {
        if (response.ok) {
          return response.json();
        } else {
          throw new Error("Invalid credentials");
        }
      })
      .then((data) => {
        let authority = data.user.authorities[0].authority;
        localStorage.setItem("isLoggedIn", "true");

        localStorage.setItem("email", email);
        localStorage.setItem("password", password);
        if (authority === "ROLE_USER") {
          navigate("/user-page", { state: data });
        } else if (authority === "ROLE_ADMIN") {
          navigate("/admin-page");
        }
      })
      .catch((error) => {
        console.error("Login failed", error);
        setError("Invalid credentials");
      });
  };

  return (
    <div
      style={{
        backgroundImage: `url(${backgroundSVG})`,
        height: "100vh",
        backgroundSize: "cover",
      }}
    >
      <BackNavbar />
      <form onSubmit={handleSubmit} className="login-form">
        {error && <p>{error}</p>}

        <label className="customlb">Email:</label>
        <input
          type="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />

        <br />

        <label className="customlb">Password:</label>
        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />

        <br />
        <button type="submit" className="login-button">
          Login
        </button>
      </form>
    </div>
  );
};
export default LoginPage;
