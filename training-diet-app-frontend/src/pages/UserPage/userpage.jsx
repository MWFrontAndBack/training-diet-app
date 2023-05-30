import UserNavbar from "../../components/templates/navbar/usernavbar/usernavbar";
import UserPageMain from "../../components/templates/userpage/userpage";
import backgroundSVG from "../../assets/userpage.svg";
const UserPage = () => {
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
