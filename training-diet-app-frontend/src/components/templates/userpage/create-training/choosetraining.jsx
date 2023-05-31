import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const ChooseTraining = () => {
  const [select, setSelect] = useState("");

  const navigate = useNavigate();
  const handleSubmit = (event) => {
    event.preventDefault();
    console.log(select);
    if (select === "train") {
      navigate("/user-page/create-training/train-customize");
    }
  };

  const handleChange = (event) => {
    setSelect(event.target.value);
  };
  return (
    <form onSubmit={handleSubmit}>
      <label>
        <input
          type="radio"
          value="trainAndDiet"
          name="anserw"
          onChange={handleChange}
        />
        Training with Diet
      </label>

      <label>
        <input
          type="radio"
          value="train"
          name="anserw"
          onChange={handleChange}
        />
        Only Training
      </label>

      <input type="submit" value="Submit" />
    </form>
  );
};

export default ChooseTraining;
