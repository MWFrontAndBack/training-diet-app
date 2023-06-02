import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import CustomExcercises from "../excercisesCustomization/excercisecustom";
import "./customization.css";
import OptionsNavbar from "../../../../organisms/navbar/optionsNavbar/optionsnavbar";
import Button from "@mui/material/Button";
import backgroundSVG from "../../../../../assets/wave.svg";
import { SaveTrainig } from "../../../../../sevices/training/trainingservice";

const TrainingCustomization = () => {
  const [excercise, setExcercise] = useState("");
  const [userData, setUserData] = useState(null);
  const navigate = useNavigate();
  const [trainingType, setTrainingType] = useState("");
  const [descriptio, setDescription] = useState("");
  const [photo, setPhoto] = useState("");

  const saveTrainig = (event) => {
    event.preventDefault();
    let exercices = userData.map((data) => data.excercise);
    const trainingToSave = {
      name: trainingType,
      photo: photo,
      description: descriptio,
      maxAge: 99,
      excercieses: exercices,
    };
    const username = localStorage.getItem("email");
    const password = localStorage.getItem("password");
    SaveTrainig(username, password, trainingToSave);
    navigate("/user-page");
  };
  const HandleSubmit = (event) => {
    event.preventDefault();
    fetchUserData(excercise);
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
        let type = data[0].excercise.trainingType;

        setTrainingType(type);

        if (type === "STRENGTH") {
          setDescription(
            "Strength Training: Strength training focuses on increasing muscular strength and power. It typically involves lifting weights or using resistance equipment to challenge the muscles. By gradually increasing the load, repetitions, or intensity of the exercises, individuals can build stronger muscles and improve their overall strength. This type of training is beneficial for enhancing physical performance, increasing bone density, and improving body composition."
          );
          setPhoto(
            "https://superherojacked.b-cdn.net/wp-content/uploads/2018/07/Goku-Workout-2.jpg"
          );
        }

        if (type === "MOBILITY") {
          setDescription(
            "Mobility Training: Mobility training aims to improve the range of motion and flexibility of the joints and muscles. It involves performing exercises that target specific areas of the body, such as stretching, dynamic movements, and joint mobilization exercises. By incorporating mobility training into a fitness routine, individuals can enhance their overall flexibility, joint stability, and movement efficiency. It is particularly beneficial for injury prevention, enhancing athletic performance, and promoting better posture and body alignment."
          );
          setPhoto(
            "https://www.integrativenutrition.com/sites/default/files/shutterstock_1100356202.jpg"
          );
        }
        if (type === "ENDURANCE") {
          setDescription(
            "Endurance Training: Endurance training, also known as cardiovascular or aerobic training, focuses on improving the body's ability to sustain physical activity over an extended period. It typically involves activities like running, cycling, swimming, or any other form of continuous rhythmic movement that elevates the heart rate. Endurance training increases cardiovascular fitness, improves lung capacity, and boosts stamina. It is essential for enhancing overall endurance, promoting weight loss, and reducing the risk of chronic diseases like heart disease and diabetes."
          );
          setPhoto(
            "https://wompampsupport.azureedge.net/fetchimage?siteId=7575&v=2&jpgQuality=100&width=700&url=https%3A%2F%2Fi.kym-cdn.com%2Fentries%2Ficons%2Ffacebook%2F000%2F023%2F802%2Fnarutorunning.jpg"
          );
        }
      })
      .catch((error) => {
        console.error("Failed to fetch user data", error);
      });
  };
  const handleAlternativeChange = (index) => {
    // Logic to change the alternative with the exercise
    // Update the userData state based on the selected alternative index
  };
  return (
    <div>
      <OptionsNavbar />
      <div
        style={{
          backgroundImage: `url(${backgroundSVG})`,
          height: "100%",
          backgroundSize: "cover",
        }}
        className="container"
      >
        <form onSubmit={HandleSubmit} className="comic-form">
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
            Mobility Training
          </label>

          <label>
            <input
              type="radio"
              value="ENDURANCE"
              name="return"
              onChange={handleChange}
            />
            Endurance Training
          </label>

          <input className="submit-button" type="submit" value="Submit" />
        </form>
        <div className="user-data">
          {userData ? (
            userData.map((item, index) => (
              <div key={index}>
                <CustomExcercises excercise={item} />
              </div>
            ))
          ) : (
            <p className="warning">Select a training type</p>
          )}
        </div>

        <div className="save-button">
          {userData ? (
            <Button variant="contained" onClick={saveTrainig}>
              Save
            </Button>
          ) : (
            <p></p>
          )}
        </div>
      </div>
    </div>
  );
};

export default TrainingCustomization;
