import { useState } from "react";
import "./details.css";

import { DelteteTrainigById } from "../../../../sevices/training/trainingservice";
import TrainingCard from "../../../organisms/card/trainingCard";

const TrainingDetails = (props) => {
  const [isDeleted, setIsDeleted] = useState(false);

  const { id, name, description, maxAge, photo, excercieses } = props.val;
  const training = { id, name, description, maxAge, photo, excercieses };

  const handleDelelte = () => {
    const username = localStorage.getItem("email");
    const password = localStorage.getItem("password");
    if (username && password) {
      DelteteTrainigById(username, password, id)
        .then((response) => {
          if (response.ok) {
            props.ondelete(id);
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
      <TrainingCard data={training} onClick={handleDelelte} />
    </div>
  );
};

export default TrainingDetails;
