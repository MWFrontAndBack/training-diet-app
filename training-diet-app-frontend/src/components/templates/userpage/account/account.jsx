import { useEffect, useState } from "react";
import "./useracc.css";
import { useNavigate } from "react-router-dom";
import OptionsNavbar from "../../../organisms/navbar/optionsNavbar/optionsnavbar";
import GetUserAccoutData from "../../../../sevices/accout/accountservice";
import backgroundSVG from "../../../../assets/background.svg";
const UserAccount = () => {
  const [userData, setUserData] = useState(null);
  const navigate = useNavigate();
  const [error, setError] = useState("");
  const [birthDate, setBirthDate] = useState("");
  const [height, setHeight] = useState("");
  const [weight, setWeight] = useState("");

  const handleSubmit = () => {};
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
                {userData.birthDate ? (
                  <p className="text">BirthDate: {userData.birthDate}</p>
                ) : (
                  <p className="text">BirthDate: ?</p>
                )}
                {userData.height ? (
                  <p className="text">Height: {userData.height}</p>
                ) : (
                  <p className="text">Height: ?</p>
                )}
                {userData.weight ? (
                  <p className="text">Weight: {userData.weight}</p>
                ) : (
                  <p className="text">Weight: ?</p>
                )}
              </div>
            ) : (
              <p className="text">No user data available.</p>
            )}
          </div>

          <form onSubmit={handleSubmit} className="login-form">
            {error && <p>{error}</p>}

            <label className="customlb">BrithDate:</label>
            <input
              type="date"
              value={birthDate}
              onChange={(e) => setBirthDate(e.target.value)}
            />

            <br />

            <label className="customlb">Height:</label>
            <input
              type="number"
              value={height}
              onChange={(e) => setHeight(e.target.value)}
            />

            <label className="customlb">Weight:</label>
            <input
              type="number"
              value={weight}
              onChange={(e) => setWeight(e.target.value)}
            />

            <br />
            <button type="submit" className="login-button">
              Update
            </button>
          </form>
        </div>
      </div>
    </div>
  );
};
export default UserAccount;
