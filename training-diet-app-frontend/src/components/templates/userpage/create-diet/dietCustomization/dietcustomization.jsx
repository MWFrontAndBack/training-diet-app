import { useState } from "react";
import backgroundSVG from "../../../../../assets/background.svg";
import OptionsNavbar from "../../../../organisms/navbar/optionsNavbar/optionsnavbar";
import CustomMeal from "../mealCustomization/custommeal";
import { Button } from "@mui/material";
import "./customization.css";
import {
  CountCalories,
  SaveDiet,
} from "../../../../../sevices/diets/dietService";
import { useNavigate } from "react-router-dom";
import { GetMealByMealType } from "../../../../../sevices/meals/meals";
const DietCustomization = () => {
  const [descriptio, setDescription] = useState("");
  const [photo, setPhoto] = useState("");
  const navigate = useNavigate();
  const [sumcal, setSumcal] = useState();
  const [userData, setUserData] = useState(null);
  const [meal, setMeal] = useState();
  const HandleSubmit = (event) => {
    event.preventDefault();
    fetchUserData(meal);
  };
  const handleChange = (event) => {
    event.preventDefault();

    setMeal(event.target.value);
  };

  const replaceData = (index, mainIndex) => {
    //new calories

    let userDataIndex = userData.findIndex((d) => {
      return d.dish.id === mainIndex;
    });
    const updatedUserData = [...userData];
    const alternatives = updatedUserData[userDataIndex].alternatives;
    if (alternatives.length > 0) {
      let copy = updatedUserData[userDataIndex].dish;
      updatedUserData[userDataIndex].dish = alternatives[index];
      updatedUserData[userDataIndex].alternatives[index] = copy;
    }
    setUserData(updatedUserData);
    let count = CountCalories(userData);
    setSumcal(count);
  };

  const saveDiet = (event) => {
    event.preventDefault();
    let list = userData.map((data) => data.dish);
    console.log(photo);
    const diet = {
      calories: 200,
      dietName: meal,
      url: photo,
      description: descriptio,
      dishesList: list,
    };
    const username = localStorage.getItem("email");
    const password = localStorage.getItem("password");
    SaveDiet(username, password, diet);
    navigate("/user-page/create-training/train-customize");
  };

  const fetchUserData = (type) => {
    const username = localStorage.getItem("email");
    const password = localStorage.getItem("password");
    GetMealByMealType(username, password, type)
      .then((response) => {
        if (response.ok) {
          return response.json();
        } else {
          throw new Error("Failed to fetch user data");
        }
      })
      .then((data) => {
        console.log("fetched");
        setUserData(data);

        let count = CountCalories(data);
        setSumcal(count);
        let type = data[0].dish.mealType;

        setMeal(type);

        if (type === "WEGETARIAN") {
          setDescription(
            "A vegetarian diet is a dietary approach that excludes the consumption of meat, poultry, and fish. It primarily focuses on plant-based foods, including fruits, vegetables, grains, legumes, nuts, and seeds. Vegetarians often derive their protein from sources like tofu, tempeh, beans, lentils, and dairy products (if they consume them). "
          );
          setPhoto(
            "https://img.freepik.com/free-vector/set-different-vegetables-cartoon_1308-104800.jpg"
          );
        }

        if (type === "LACTOZEFREE") {
          setDescription(
            "A gluten-free diet is essential for individuals with celiac disease or gluten sensitivity. Gluten is a protein found in wheat, barley, rye, and their derivatives. When individuals with celiac disease consume gluten, it triggers an immune response that damages the small intestine. A gluten-free diet involves eliminating all sources of gluten from the diet."
          );
          setPhoto(
            "https://t3.ftcdn.net/jpg/05/12/82/56/360_F_512825636_BKc5mEQMvPlGmpzqs4nAXAsJAMukA3l1.jpg"
          );
        }
        if (type === "GLUTENFREE") {
          setDescription(
            "A gluten-free diet excludes any foods that contain gluten, which is a protein found in wheat and several other grains. It means eating only whole foods that don't contain gluten, such as fruits, vegetables, meat and eggs, as well as processed gluten-free foods like gluten-free bread or pasta."
          );
          setPhoto(
            "https://www.bakeryandsnacks.com/var/wrbm_gb_food_pharma/storage/images/_aliases/wrbm_large/5/9/6/3/2073695-1-eng-GB/Push-for-universal-gluten-free-symbol-in-Europe.jpg"
          );
        }
      })
      .catch((error) => {
        console.error("Failed to fetch user data", error);
      });
  };
  return (
    <div>
      <OptionsNavbar />
      <div className="container">
        <form onSubmit={HandleSubmit} className="comic-form ">
          <label>Wegetarian Diet</label>
          <input
            type="radio"
            value="WEGETARIAN"
            name="return"
            onChange={handleChange}
          />

          <label>Gluten-free Diet</label>

          <input
            type="radio"
            value="GLUTENFREE"
            name="return"
            onChange={handleChange}
          />

          <label>Lactoze-Free Diet</label>
          <input
            type="radio"
            value="LACTOZEFREE"
            name="return"
            onChange={handleChange}
          />

          <input className="submit-button" type="submit" value="Submit" />
        </form>
        <div className="user-data">
          {userData ? (
            userData.map((item, index) => (
              <div key={index}>
                <CustomMeal onreplace={replaceData} data={item} />
              </div>
            ))
          ) : (
            <p className="warning">Select Diet type</p>
          )}
        </div>

        <div className="save-button">
          {userData ? (
            <div>
              <p className="calories">Suma karlori {sumcal} kcal</p>

              <Button variant="contained" onClick={saveDiet}>
                Save
              </Button>
            </div>
          ) : (
            <p></p>
          )}
        </div>
      </div>
    </div>
  );
};
export default DietCustomization;
