import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import CustomExcercises from "../excercisesCustomization/excercisecustom";

const TrainingCustomization = () => {
  const [excercise, setExcercise] = useState("");
  const [userData, setUserData] = useState(null);
  const navigate = useNavigate();
  const HandleSubmit = (event) => {
    event.preventDefault();
    fetchUserData(excercise);
    // fetchUserData(select);
  };

  const handleChange = (event) => {
    setExcercise(event.target.value);
  };
  const fetchUserData = (type) => {
    const username = localStorage.getItem("email");
    const password = localStorage.getItem("password");
    fetch(
      `http://localhost:8080/api/public/user-page/excercises?type=${type}`,
      {
        headers: {
          Authorization: "Basic " + btoa(`${username}:${password}`),
        },
      }
    )
      .then((response) => {
        if (response.ok) {
          return response.json();
        } else {
          throw new Error("Failed to fetch user data");
        }
      })
      .then((data) => {
        setUserData(data);
        console.log(data);
      })
      .catch((error) => {
        console.error("Failed to fetch user data", error);
      });
  };
  return (
    <div>
      <form onSubmit={HandleSubmit}>
        <label>
          <input
            type="radio"
            value="STRENGTH"
            name="return"
            onChange={handleChange}
          />
          Strength Training
        </label>

        <label>
          <input
            type="radio"
            value="MOBILITY"
            name="return"
            onChange={handleChange}
          />
          MobilityTraining
        </label>

        <label>
          <input
            type="radio"
            value="ENDURANCE"
            name="return"
            onChange={handleChange}
          />
          Endurance training
        </label>

        <input type="submit" value="Submit" />
      </form>

      <div>
        {userData ? (
          userData.map((item, index) => (
            <div key={index}>
              <CustomExcercises excercise={item} />
            </div>
          ))
        ) : (
          <p>wybierz rodzaj treningu</p>
        )}
      </div>

      <div>{userData ? <button>save</button> : <p></p>}</div>
    </div>
  );
};

export default TrainingCustomization;
