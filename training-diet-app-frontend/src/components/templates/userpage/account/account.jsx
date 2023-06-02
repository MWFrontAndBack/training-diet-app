import { useEffect, useState } from "react";
import "./useracc.css";
import { useNavigate } from "react-router-dom";
import OptionsNavbar from "../../../organisms/navbar/optionsNavbar/optionsnavbar";
import GetUserAccoutData from "../../../../sevices/accout/accountservice";
import backgroundSVG from "../../../../assets/background.svg";
const UserAccount = () => {
  const [userData, setUserData] = useState(null);
  const navigate = useNavigate();
  useEffect(() => {
    const username = localStorage.getItem("email");
    const password = localStorage.getItem("password");
    const loggedIn = localStorage.getItem("isLoggedIn");

    if (loggedIn !== "true") {
      navigate("/login");
    }

    if (username && password) {
      GetUserAccoutData(username, password)
        .then((response) => {
          if (response.ok) {
            return response.json();
          } else {
            throw new Error("Failed to fetch user data");
          }
        })
        .then((data) => {
          setUserData(data);
        })
        .catch((error) => {
          console.error("Failed to fetch user data", error);
        });
    }
  }, []);

  return (
    <div
      style={{
        backgroundImage: `url(${backgroundSVG})`,
        height: "100vh",
        backgroundSize: "cover",
      }}
    >
      <OptionsNavbar />
      <div className="container-account">
        <div className="content">
          <div className="image-container">
            {userData ? (
              <img src={userData.photo} alt="User Photo" className="image" />
            ) : (
              <div className="placeholder-image" />
            )}
          </div>
          <div className="data-container">
            <h1 className="title">User Data</h1>
            {userData ? (
              <div>
                <p className="text">Login: {userData.loginName}</p>
                <p className="text">Email: {userData.email}</p>
              </div>
            ) : (
              <p className="text">No user data available.</p>
            )}
          </div>
        </div>
      </div>
    </div>
  );
};
export default UserAccount;
