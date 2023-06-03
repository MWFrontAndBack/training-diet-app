import "./custom.css";

import * as React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { Button, CardActionArea, CardActions } from "@mui/material";
import CustomizedRating from "../../../../../pages/Trainings/ExcerciseDetails/customRatin";

const CustomExcercises = (props) => {
  let exer = props.data;
  let main = props.data.excercise;
  const handleHange = (altIndex) => {
    let mainId = main.id;
    props.onreplace(altIndex, mainId);
  };
  if (!main) {
    return null;
  }
  return (
    <div id="parent">
      <div className="left">
        <h4>Excercise:</h4>

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
                {main.name}
              </Typography>
              <Typography variant="h6" color="text.secondary">
                Series: {main.series}
              </Typography>
              <Typography variant="h6" color="text.secondary">
                Reps {main.reps}
              </Typography>
              <Typography variant="h6" color="text.secondary">
                {main.trainingType}
              </Typography>
              <Typography variant="body2" color="text.secondary">
                <CustomizedRating rate={main.levelOfAdvance} />
              </Typography>
            </CardContent>
          </CardActionArea>
        </Card>
      </div>
      <div className="right">
        <h4>Alternatives:</h4>
        <div className="alternatives-row">
          {exer.alternatives.map((alternative, idx) => (
            <div className="altern" key={idx}>
              <Card sx={{ maxWidth: 345, backgroundColor: "ActiveBorder" }}>
                <CardActionArea>
                  <CardMedia
                    component="img"
                    height="140"
                    image="https://t3.ftcdn.net/jpg/03/25/72/12/360_F_325721295_x224QeDphb6ZAFl2tkoX0TlBuczNwBek.jpg"
                    alt="green iguana"
                  />
                  <CardContent>
                    <Typography
                      gutterBottom
                      variant="h5"
                      component="div"
                      color="orange"
                    >
                      {alternative.name}
                    </Typography>
                    <Typography variant="h6" color="orange">
                      Series {alternative.series}
                    </Typography>
                    <Typography variant="h6" color="orange">
                      Reps {alternative.reps}
                    </Typography>
                    <Typography variant="h6" color="orange">
                      Type {alternative.trainingType}
                    </Typography>
                    <Typography variant="body2" color="orange">
                      <CustomizedRating rate={alternative.levelOfAdvance} />
                    </Typography>
                  </CardContent>
                  <CardActions>
                    <Button
                      onClick={() => handleHange(idx, alternative.id)}
                      variant="contained"
                    >
                      Change
                    </Button>
                  </CardActions>
                </CardActionArea>
              </Card>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};
export default CustomExcercises;
