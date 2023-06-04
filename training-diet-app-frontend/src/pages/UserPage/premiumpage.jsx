import backgroundSVG from "../../assets/premium.svg";
import PremiumNavbar from "../../components/organisms/navbar/usernavbar/premiumNavbar";

const PremiumPage = () => {
  return (
    <div
      style={{
        backgroundImage: `url(${backgroundSVG})`,
        height: "100vh",
        backgroundSize: "cover",
      }}
    >
      <PremiumNavbar />
    </div>
  );
};
export default PremiumPage;
