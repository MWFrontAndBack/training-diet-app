import { useState } from "react";
import * as React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { Button, CardActions } from "@mui/material";
import { Link } from "react-router-dom";
import { DelteteMealbyId } from "../../../../sevices/meals/meals";
import "../ownTraining/details.css";
const DietDetails = (props) => {
  const [isDeleted, setIsDeleted] = useState(false);

  const { id, dietName, description, calories, url, dishesList } = props.val;

  const handleDelelte = () => {
    const username = localStorage.getItem("email");
    const password = localStorage.getItem("password");
    if (username && password) {
      DelteteMealbyId(username, password, id)
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
        <CardMedia sx={{ height: 140 }} image={url} title="green iguana" />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {dietName} {calories} kcal
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
            to={`/user-page/diet/details/${id}`}
            state={{ data: dishesList }}
          >
            Details
          </Link>
        </CardActions>
      </Card>
    </div>
  );
};
export default DietDetails;
