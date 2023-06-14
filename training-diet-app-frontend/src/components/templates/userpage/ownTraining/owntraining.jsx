import { useEffect, useState } from "react";
import TrainingDetails from "./trainingDetails";
import "./own.css";
import { GetAllTrainings } from "../../../../sevices/training/trainingservice";
import RequireLogin from "../../../../pages/UserPage/requireLogin";

const OwnTrainings = () => {
  const [userData, setUserData] = useState(null);
  const [loading, setLoading] = useState(true);

  const handleNoteDeletion = (id) => {
    setUserData((prevUserData) =>
      prevUserData.filter((item) => item.id !== id)
    );
  };
  useEffect(() => {
    const username = localStorage.getItem("email");
    const password = localStorage.getItem("password");
    if (username && password) {
      GetAllTrainings(username, password)
        .then((response) => {
          if (response.ok) {
            return response.json();
          } else {
            throw new Error("Failed to fetch user data");
          }
        })
        .then((data) => {
          setUserData(data);
          setLoading(false);
          console.log(data);
        })
        .catch((error) => {
          console.error("Failed to fetch user data", error);
          setLoading(false);
        });
    }
  }, []);
  return (
    <div className="onwTraningContainer">
      <RequireLogin />
      {loading ? (
        <p>Loading...</p>
      ) : userData && userData.length > 0 ? (
        <div className="parent">
          {userData.map((item) => (
            <TrainingDetails
              key={item.id}
              val={item}
              ondelete={handleNoteDeletion}
            />
          ))}
        </div>
      ) : (
        <p className="emptytrain">No Training available</p>
      )}
    </div>
  );
};
export default OwnTrainings;
