import { useLocation } from "react-router-dom";
import OptionsNavbar from "../../../components/organisms/navbar/optionsNavbar/optionsnavbar";
import trainImage from "../../../assets/food.jpeg";

const MealDetails = () => {
  const location = useLocation();
  const data = location.state?.data;

  if (!data) {
    return <div>No Dishes data available.</div>;
  }

  return (
    <div>
      <OptionsNavbar />
      <div className="alignCenter">
        <div className="exercise-details-container">
          {data.map((dish) => (
            <div className="exercise-card" key={dish.id}>
              <img src={trainImage} alt={dish.name} />
              <div className="exercise-details">
                <h3>{dish.name}</h3>
                <p className="customText">Calories {dish.calories}</p>
                <p className="customText"> {dish.mealType}</p>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};
export default MealDetails;
