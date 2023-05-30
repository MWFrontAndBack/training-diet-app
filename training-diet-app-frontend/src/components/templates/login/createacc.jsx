import React, { useState } from "react";
import { Navigate, useNavigate } from "react-router-dom";
import { CreateAccount } from "../../../sevices/login/login";
import "./login.css";
import backgroundSVG from "../../../assets/wave.svg";
import BackNavbar from "../navbar/backnavba";
const CreateAccountPage = () => {
  const [loginName, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [email, setEmail] = useState("");
  const [error, setError] = useState(""); // Add error state variable
  const [redirectToLogin, setRedirectToLogin] = useState(false);
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();

    CreateAccount(loginName, password, email)
      .then((response) => response.json())
      .then((data) => {
        navigate("/");
        setRedirectToLogin(true);
      })
      .catch((error) => {
        setError("Invalid credentials"); // Update the error state if the login request fails
      });
  };

  if (redirectToLogin) {
    return <Navigate to="/login" replace />;
  }

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
        {error && <p className="error-message">{error}</p>}{" "}
        {/* Display error message */}
        <label className="customlb">Username:</label>
        <input
          type="text"
          value={loginName}
          onChange={(e) => setUsername(e.target.value)}
          required
        />
        <br />
        <label className="customlb">Password:</label>
        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
        <br />
        <label className="customlb">Email:</label>
        <input
          type="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />
        <br />
        <button type="submit" className="login-button">
          Create Account
        </button>
      </form>
    </div>
  );
};

export default CreateAccountPage;
