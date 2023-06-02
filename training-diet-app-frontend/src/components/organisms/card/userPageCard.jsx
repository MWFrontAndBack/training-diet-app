import * as React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { CardActionArea, CardActions } from "@mui/material";
import { Link } from "react-router-dom";
import "./usercard.css";
export default function UserPageCard(props) {
  let image = props.data.img;
  let action = props.data.action;
  let desc = props.data.desc;
  let to = props.data.to;

  return (
    <Card sx={{ maxWidth: 800 }}>
      <CardMedia
        component="img"
        alt="green iguana"
        height="340"
        image={image}
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
          {desc}
        </Typography>
      </CardContent>
      <CardActions>
        <Link className="link-button" to={to}>
          {action}
        </Link>
      </CardActions>
    </Card>
  );
}
