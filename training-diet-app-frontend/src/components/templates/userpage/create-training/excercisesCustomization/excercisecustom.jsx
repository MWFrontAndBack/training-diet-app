import { useState } from "react";
import "./custom.css";
import MultiActionAreaCard from "../../../../organisms/card/card";
import MultiActionAreaCardAlternative from "../../../../organisms/card/alternativeCard";

const CustomExcercises = (props) => {
  let item = props.excercise;
  const [selectedAlternative, setSelectedAlternative] = useState(null);
  const handleAlternativeChange = (event) => {
    setSelectedAlternative(event.target.value);
  };
  //   console.log(excer);
  return (
    <div id="parent">
      <div className="left">
        <h4>Excercise:</h4>

        <MultiActionAreaCard data={item.excercise} />
      </div>
      <div className="right">
        <h4>Alternatives:</h4>
        <div className="alternatives-row">
          {item.alternatives.map((alternative, idx) => (
            <div className="altern" key={idx}>
              <MultiActionAreaCardAlternative data={alternative} />
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};
export default CustomExcercises;
