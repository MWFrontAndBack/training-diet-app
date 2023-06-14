import UserNavbar from "../../components/organisms/navbar/usernavbar/usernavbar";
import UserPageMain from "../../components/templates/userpage/userpage";
import backgroundSVG from "../../assets/userpage.svg";
import { useNavigate } from "react-router-dom";
import { useEffect } from "react";
import RequireLogin from "./requireLogin";

const UserPage = () => {
  const navigate = useNavigate();

  return (
    <div
      style={{
        backgroundImage: `url(${backgroundSVG})`,
        height: "100vh",
        backgroundSize: "cover",
      }}
    >
      <RequireLogin />
      <UserNavbar />
      <UserPageMain />
    </div>
  );
};

export default UserPage;
