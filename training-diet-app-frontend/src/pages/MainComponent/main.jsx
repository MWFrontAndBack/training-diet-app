import HomePage from "../Home/home";
import { Routes, Route } from "react-router-dom";
import LoginPage from "../../components/templates/login/login";
import CreateAccountPage from "../../components/templates/login/createacc";
import UserPage from "../UserPage/userpage";
import TrainingsPage from "../Trainings/trainingspage";
import DietsPage from "../Diets/dietspage";
import UserAccount from "../../components/templates/userpage/account/account";
import ChooseTraining from "../../components/templates/userpage/create-training/chooseTrainig/choosetraining";
import TrainingCustomization from "../../components/templates/userpage/create-training/trainCustomization/traincustomization";
import CustomExcercises from "../../components/templates/userpage/create-training/excercisesCustomization/excercisecustom";
import ExcerciseDetails from "../Trainings/ExcerciseDetails/excerciseDetails";
import DietCustomization from "../../components/templates/userpage/create-diet/dietCustomization/dietcustomization";
import MealDetails from "../Diets/MealDetails/mealDetails";
import PremiumPage from "../UserPage/premiumpage";

const Main = () => {
  return (
    <Routes>
      <Route path="/" element={<HomePage />} />
      <Route path="/create-acc" element={<CreateAccountPage />} />
      <Route path="/login" element={<LoginPage />} />
      <Route path="/user-page" element={<UserPage />} />
      <Route path="/user-page/trainings" element={<TrainingsPage />} />
      <Route path="/user-page/diets" element={<DietsPage />} />
      <Route path="/user-page/account" element={<UserAccount />} />
      <Route path="/user-page/create-training" element={<ChooseTraining />} />
      <Route
        path="/user-page/create-training/train-customize"
        element={<TrainingCustomization />}
      />

      <Route
        path="/user-page/create-training/diet-customize"
        element={<DietCustomization />}
      />
      <Route
        path="/user-page/create-training/train-customize/excercise"
        element={<CustomExcercises />}
      />
      <Route
        path="user-page/trainings/details/:id"
        element={<ExcerciseDetails />}
      />
      <Route path="user-page/diet/details/:id" element={<MealDetails />} />
      <Route path="/premium-page" element={<PremiumPage />} />
    </Routes>
  );
};

export default Main;
