import "./custom.css";
import MultiActionAreaCard from "../../../../organisms/card/card";
import MultiActionAreaCardAlternative from "../../../../organisms/card/alternativeCard";
import { useState } from "react";

const CustomExcercises = (props) => {
  const [selectedExercise, setSelectedExercise] = useState(props.excercise);
  const [selectedAlternative, setSelectedAlternative] = useState(null);

  const handleAlternativeClick = (id) => {
    const alt = selectedExercise.alternatives.find(
      (alternative) => alternative.id === id
    );
    setSelectedAlternative(alt);
  };
  return (
    <div id="parent">
      <div className="left">
        <h4>Excercise:</h4>

        <MultiActionAreaCard
          data={
            selectedAlternative
              ? selectedAlternative
              : selectedExercise.excercise
          }
        />
      </div>
      <div className="right">
        <h4>Alternatives:</h4>
        <div className="alternatives-row">
          {selectedExercise.alternatives.map((alternative, idx) => (
            <div className="altern" key={idx}>
              <MultiActionAreaCardAlternative
                data={alternative}
                onAlternativeClick={handleAlternativeClick}
              />
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};
export default CustomExcercises;
