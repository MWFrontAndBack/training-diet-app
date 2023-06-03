import { useState } from "react";
import "./details.css";
import * as React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { Button, CardActions } from "@mui/material";
import { DelteteTrainigById } from "../../../../sevices/training/trainingservice";
import { Link } from "react-router-dom";

const TrainingDetails = (props) => {
  const [isDeleted, setIsDeleted] = useState(false);

  const { id, name, description, maxAge, photo, excercieses } = props.val;

  const handleDelelte = () => {
    const username = localStorage.getItem("email");
    const password = localStorage.getItem("password");
    if (username && password) {
      DelteteTrainigById(username, password, id)
        .then((response) => {
          if (response.ok) {
            props.ondelete(id);
            setIsDeleted(true);
          } else {
            console.log("Failed to delete note");
          }
        })
        .catch((error) => {
          console.error("Error deleting note:", error);
        });
    }
  };
  if (isDeleted) {
    return null;
  }

  return (
    <div>
      <Card sx={{ maxWidth: 345 }}>
        <CardMedia sx={{ height: 140 }} image={photo} title="green iguana" />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {name}
          </Typography>
          <Typography variant="body1" color="text.secondary">
            {description}
          </Typography>
        </CardContent>
        <CardActions>
          <button onClick={handleDelelte} className="delte-perfect">
            Delete
          </button>
          <Link
            className="link-perfect"
            to={`/user-page/trainings/details/${id}`}
            state={{ data: excercieses }}
          >
            Details
          </Link>
        </CardActions>
      </Card>
    </div>
  );
};

export default TrainingDetails;
