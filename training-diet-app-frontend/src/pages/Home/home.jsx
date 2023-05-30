import ResponsiveAppBar from "../../components/templates/navbar/navbar";
import backgroundSVG from "../../assets/background.svg";
import MainDesciption from "../../components/templates/mainPageDesc/mainPagedesc";
import "./home.css";

const HomePage = () => {
  let trainingDesc =
    "Our training program is designed to help you achieve your fitness goals effectively and efficiently. Whether you're a beginner or an experienced athlete, our team of qualified trainers will provide expert guidance and support throughout your fitness journey. ";
  let dietDesc =
    "At our facility, we understand the importance of nutrition in achieving optimal health and fitness. Our diet program is designed to complement your training efforts and help you make sustainable and healthy dietary choices. ";
  return (
    <div
      style={{
        backgroundImage: `url(${backgroundSVG})`,
        height: "100vh",
        backgroundSize: "cover",
      }}
    >
      <ResponsiveAppBar />
      <div className="container">
        <MainDesciption
          img={
            "https://img.freepik.com/free-vector/vector-cartoon-background-gym-with-big-window_33099-1200.jpg?w=2000"
          }
          title={"trainings"}
          desc={trainingDesc}
        />

        <MainDesciption
          img={
            "https://img.freepik.com/premium-vector/diet-plan-with-vegetables-healthy-nutrition-cartoon-design_530689-1311.jpg?w=2000"
          }
          title={"diets"}
          desc={dietDesc}
        />
      </div>
    </div>
  );
};
export default HomePage;
