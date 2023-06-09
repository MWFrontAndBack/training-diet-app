import * as React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { Button, CardActionArea, CardActions } from "@mui/material";
import CustomizedRating from "../../../pages/Trainings/ExcerciseDetails/customRatin";
export default function MultiActionAreaCardAlternative(props) {
  let item = props.data;
  const { data, onAlternativeClick } = props;

  const handleAlternativeClick = (event) => {
    event.preventDefault();
    onAlternativeClick(data.id);
  };

  return (
    <Card sx={{ maxWidth: 345, backgroundColor: "ActiveBorder" }}>
      <CardActionArea>
        <CardMedia
          component="img"
          height="140"
          image="https://t3.ftcdn.net/jpg/03/25/72/12/360_F_325721295_x224QeDphb6ZAFl2tkoX0TlBuczNwBek.jpg"
          alt="green iguana"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div" color="orange">
            {item.name}
          </Typography>
          <Typography variant="h6" color="orange">
            Series {item.series}
          </Typography>
          <Typography variant="h6" color="orange">
            Reps {item.reps}
          </Typography>
          <Typography variant="h6" color="orange">
            Type {item.trainingType}
          </Typography>
          <Typography variant="body2" color="orange">
            <CustomizedRating rate={item.levelOfAdvance} />
          </Typography>
        </CardContent>
        <CardActions>
          <Button
            variant="contained"
            onClick={(event) => handleAlternativeClick(event, item.id)}
          >
            Change
          </Button>
        </CardActions>
      </CardActionArea>
    </Card>
  );
}
