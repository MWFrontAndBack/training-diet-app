import { Link, useNavigate } from "react-router-dom";
import { useState } from "react";
import "./details.css";
import Card from "@mui/material/Card";
import CardActions from "@mui/material/CardActions";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";

const TrainingDetails = (props) => {
  const navigate = useNavigate();
  const [isDeleted, setIsDeleted] = useState(false);
  const username = localStorage.getItem("email");
  const password = localStorage.getItem("password");
  const { id, name, description, maxAge, photo, excercieses } = props.val;
  const training = { id, name, description, maxAge, photo, excercieses };

  const handleDelelte = () => {
    fetch(`http://localhost:8080/api/public/user-page/delete-training/${id}`, {
      headers: {
        Authorization: "Basic " + btoa(`${username}:${password}`),
      },
    })
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
  };

  if (isDeleted) {
    return null;
  }

  return (
    <div>
      <Card sx={{ maxWidth: 345 }}>
        <CardMedia
          sx={{ height: 140 }}
          image={training.photo}
          title="green iguana"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {training.name}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            {training.description}
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
    </div>
  );
};

export default TrainingDetails;
