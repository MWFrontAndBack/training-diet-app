import { useLocation } from "react-router-dom";
import OptionsNavbar from "../../../components/organisms/navbar/optionsNavbar/optionsnavbar";
import "./excercise.css";
import CustomizedRating from "./customRatin";
import trainImage from "../../../assets/traininguser.jpg";

const ExcerciseDetails = () => {
  const location = useLocation();
  const data = location.state?.data;

  if (!data) {
    return <div>No exercise data available.</div>;
  }

  return (
    <div>
      <OptionsNavbar />
      <div className="alignCenter">
        <div className="exercise-details-container">
          {data.map((exercise) => (
            <div className="exercise-card" key={exercise.id}>
              <img src={trainImage} alt={exercise.name} />
              <div className="exercise-details">
                <h3>{exercise.name}</h3>
                <CustomizedRating rate={exercise.levelOfAdvance} />
                <p className="customText">Reps {exercise.reps}</p>
                <p className="customText">Series {exercise.series}</p>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};
export default ExcerciseDetails;
