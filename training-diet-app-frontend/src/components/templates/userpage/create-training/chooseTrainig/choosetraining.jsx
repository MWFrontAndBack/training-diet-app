import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./choose.css";
import backgroundSVG from "../../../../../assets/userpage.svg";
import OptionsNavbar from "../../../../organisms/navbar/optionsNavbar/optionsnavbar";
import RequireLogin from "../../../../../pages/UserPage/requireLogin";

const ChooseTraining = () => {
  const [select, setSelect] = useState("");

  const navigate = useNavigate();
  const handleSubmit = (event) => {
    event.preventDefault();
    if (select === "train") {
      navigate("/user-page/create-training/train-customize");
    } else {
      navigate("/user-page/create-training/diet-customize");
    }
  };

  const handleChange = (event) => {
    setSelect(event.target.value);
  };
  return (
    <div>
      <RequireLogin />
      <OptionsNavbar />
      <div
        className="center"
        style={{
          backgroundImage: `url(${backgroundSVG})`,
          height: "100vh",
          backgroundSize: "cover",
        }}
      >
        <form className="login-form" onSubmit={handleSubmit}>
          <label className="customlb">Training with Diet</label>

          <input
            type="radio"
            value="trainAndDiet"
            name="anserw"
            onChange={handleChange}
          />

          <label className="customlb">Only Training</label>
          <input
            type="radio"
            value="train"
            name="anserw"
            onChange={handleChange}
          />

          <input className=" login-button " type="submit" value="Submit" />
        </form>
      </div>
    </div>
  );
};

export default ChooseTraining;
