import { useEffect, useState } from "react";
import TrainingDetails from "./trainingDetails";
import { Splide, SplideSlide } from "@splidejs/react-splide";
import OptionsNavbar from "../../components/templates/navbar/optionsNavbar/optionsnavbar";

const TrainingsPage = () => {
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
      <OptionsNavbar />
      {loading ? (
        <p>Loading...</p>
      ) : userData ? (
        <div className="parent">
          {userData.map((item) => (
            <div className="column">
              <TrainingDetails val={item} ondelte={handleNoteDeletion} />
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
