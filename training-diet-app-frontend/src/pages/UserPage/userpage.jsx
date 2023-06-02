import UserNavbar from "../../components/organisms/navbar/usernavbar/usernavbar";
import UserPageMain from "../../components/templates/userpage/userpage";
import backgroundSVG from "../../assets/userpage.svg";
import { useNavigate } from "react-router-dom";
import { useEffect } from "react";
const UserPage = () => {
  const navigate = useNavigate();

  useEffect(() => {
    let logged = localStorage.getItem("isLoggedIn");

    if (logged !== "true") {
      navigate("/login");
    }
  }, []);
  return (
    <div
      style={{
        backgroundImage: `url(${backgroundSVG})`,
        height: "100vh",
        backgroundSize: "cover",
      }}
    >
      <UserNavbar />
      <UserPageMain />
    </div>
  );
};

export default UserPage;
