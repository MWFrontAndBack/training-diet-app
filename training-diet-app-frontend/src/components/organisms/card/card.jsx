import * as React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { Button, CardActionArea, CardActions } from "@mui/material";
import CustomizedRating from "../../../pages/Trainings/ExcerciseDetails/customRatin";
export default function MultiActionAreaCard(props) {
  let item = props.data;
  console.log(item);
  return (
    <Card sx={{ maxWidth: 345 }}>
      <CardActionArea>
        <CardMedia
          component="img"
          height="140"
          image="https://t3.ftcdn.net/jpg/03/25/72/12/360_F_325721295_x224QeDphb6ZAFl2tkoX0TlBuczNwBek.jpg"
          alt="green iguana"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {item.name}
          </Typography>
          <Typography variant="h6" color="text.secondary">
            Series: {item.series}
          </Typography>
          <Typography variant="h6" color="text.secondary">
            Reps {item.reps}
          </Typography>
          <Typography variant="h6" color="text.secondary">
            {item.trainingType}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            <CustomizedRating rate={item.levelOfAdvance} />
          </Typography>
        </CardContent>
      </CardActionArea>
    </Card>
  );
}
