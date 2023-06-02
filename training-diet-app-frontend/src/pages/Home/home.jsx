import backgroundSVG from "../../assets/background.svg";
import "./home.css";
import MainPageCard from "../../components/organisms/card/mainpageCaard";
import dietBecground from "../../assets/dieteBacground.avif";
import trainigBacground from "../../assets/trainingbackground.avif";
import CustomNavbar from "../../components/organisms/navbar/mainpageNavbar/navbar";

const HomePage = () => {
  let trainingDesc =
    "Our training program is designed to help you achieve your fitness goals effectively and efficiently. Whether you're a beginner or an experienced athlete, our team of qualified trainers will provide expert guidance and support throughout your fitness journey. ";

  let dietDesc =
    "At our facility, we understand the importance of nutrition in achieving optimal health and fitness. Our diet program is designed to complement your training efforts and help you make sustainable and healthy dietary choices. ";

  const traing = {
    title: "training",
    desc: trainingDesc,
    img: trainigBacground,
  };
  const diet = {
    title: "diet",

    desc: dietDesc,
    img: dietBecground,
  };
  return (
    <div
      className="mainbacground"
      style={{
        backgroundImage: `url(${backgroundSVG})`,
        height: "100vh",
        backgroundSize: "cover",
      }}
    >
      <CustomNavbar />
      <div className="maincontainer">
        <MainPageCard data={traing} />
        <MainPageCard data={diet} />
      </div>
    </div>
  );
};
export default HomePage;
