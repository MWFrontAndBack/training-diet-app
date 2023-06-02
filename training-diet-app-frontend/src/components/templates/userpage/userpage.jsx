import { Splide, SplideSlide } from "@splidejs/react-splide";
import * as React from "react";
import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";

import image1 from "../../../assets/traininguser.jpg";
import image2 from "../../../assets/subscribe.jpg";
import "@splidejs/react-splide/css/sea-green";
import "./userp.css";
import UserPageCard from "../../organisms/card/userPageCard";
const UserPageMain = () => {
  let tab1 = {
    img: image1,
    desc: "Training and diet",
    action: "create training",
    to: "/user-page/create-training",
  };
  let tab2 = {
    img: image2,
    desc: "Premium Subscription",
    action: "buy subscription",
    to: "/",
  };
  return (
    <Splide aria-label="My Favorite Images">
      <SplideSlide>
        <div className="slide-container">
          <UserPageCard data={tab1} />
        </div>
      </SplideSlide>
      <SplideSlide>
        <div className="slide-container">
          <UserPageCard data={tab2} />
        </div>
      </SplideSlide>
    </Splide>
  );
};
export default UserPageMain;
