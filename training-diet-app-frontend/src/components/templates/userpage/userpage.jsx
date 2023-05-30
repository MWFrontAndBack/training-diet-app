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
const UserPageMain = () => {
  return (
    <Splide aria-label="My Favorite Images">
      <SplideSlide>
        <div className="slide-container">
          <Card sx={{ maxWidth: 800 }}>
            <CardMedia
              component="img"
              alt="green iguana"
              height="340"
              image={image1}
            />
            <CardContent>
              <Typography
                gutterBottom
                variant="h5"
                component="div"
                sx={{
                  color: "black",
                  fontSize: "25px",
                  fontFamily: "'Luckiest Guy', cursive",
                }}
              >
                Training and diet
              </Typography>
            </CardContent>
            <CardActions>
              <Button size="medium">Create</Button>
            </CardActions>
          </Card>
        </div>
      </SplideSlide>
      <SplideSlide>
        <div className="slide-container">
          <Card sx={{ maxWidth: 800 }}>
            <CardMedia
              component="img"
              alt="green iguana"
              height="340"
              image={image2}
            />
            <CardContent>
              <Typography
                gutterBottom
                variant="h5"
                component="div"
                sx={{
                  color: "black",
                  fontSize: "25px",
                  fontFamily: "'Luckiest Guy', cursive",
                }}
              >
                Buy Subscription
              </Typography>
            </CardContent>
            <CardActions>
              <Button size="small">Buy subscription</Button>
            </CardActions>
          </Card>
        </div>
      </SplideSlide>
    </Splide>
  );
};
export default UserPageMain;
