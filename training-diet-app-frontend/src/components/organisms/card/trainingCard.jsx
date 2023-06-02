import * as React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { Button, CardActions } from "@mui/material";

import { DelteteTrainigById } from "../../../sevices/training/trainingservice";
import { Link } from "react-router-dom";

export default function TrainingCard(props) {
  let id = props.data.id;

  let name = props.data.name;
  let photo = props.data.photo;

  let description = props.data.description;
  let excercieses = props.data.excercieses;
  const handleDelelte = () => {
    const username = localStorage.getItem("email");
    const password = localStorage.getItem("password");
    if (username && password) {
      DelteteTrainigById(username, password, id)
        .then((response) => {
          if (response.ok) {
            props.ondelte(id);
          } else {
            console.log("Failed to delete note");
          }
        })
        .catch((error) => {
          console.error("Error deleting note:", error);
        });
    }
  };
  return (
    <Card sx={{ maxWidth: 345 }}>
      <CardMedia sx={{ height: 140 }} image={photo} title="green iguana" />
      <CardContent>
        <Typography gutterBottom variant="h5" component="div">
          {name}
        </Typography>
        <Typography variant="body2" color="text.secondary">
          {description}
        </Typography>
      </CardContent>
      <CardActions>
        <Button onClick={handleDelelte} size="small">
          Delete
        </Button>
        <Link
          to={`/user-page/trainings/details/${id}`}
          state={{ data: excercieses }}
        >
          Details
        </Link>
      </CardActions>
    </Card>
  );
}
