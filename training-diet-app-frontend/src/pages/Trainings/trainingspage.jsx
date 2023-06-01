import { useEffect, useState } from "react";
import TrainingDetails from "./trainingDetails";

const TrainingsPage = () => {
  const [userData, setUserData] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const username = localStorage.getItem("email");
    const password = localStorage.getItem("password");
    if (username && password) {
      fetch("http://localhost:8080/api/public/user-page/trainings", {
        headers: {
          Authorization: "Basic " + btoa(`${username}:${password}`),
        },
      })
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
    <div>
      {loading ? (
        <p>Loading...</p>
      ) : userData ? (
        <div className="parent">
          {userData.map((item) => (
            <div key={item.id} className="column">
              <TrainingDetails val={item} />
            </div>
          ))}
        </div>
      ) : (
        <p>No data available</p>
      )}
    </div>
  );
};

export default TrainingsPage;
