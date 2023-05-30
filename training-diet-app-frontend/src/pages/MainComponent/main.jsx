import ResponsiveAppBar from "../../components/templates/navbar/navbar";
import HomePage from "../Home/home";
import { Routes, Route, useLocation } from "react-router-dom";
import LoginPage from "../../components/templates/login/login";
import CreateAccountPage from "../../components/templates/login/createacc";
import UserPage from "../UserPage/userpage";
import TrainingsPage from "../Trainings/trainingspage";
import DietsPage from "../Diets/dietspage";
import UserAccount from "../../components/templates/userpage/account/account";
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
    </Routes>
  );
};

export default Main;
