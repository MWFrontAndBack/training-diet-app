const DelteteTrainigById = (username, password, id) => {
  return fetch(
    `http://localhost:8080/api/public/user-page/delete-training/${id}`,
    {
      headers: {
        Authorization: "Basic " + btoa(`${username}:${password}`),
      },
    }
  );
};

const GetAllTrainings = (username, password) => {
  return fetch("http://localhost:8080/api/public/user-page/trainings", {
    headers: {
      Authorization: "Basic " + btoa(`${username}:${password}`),
    },
  });
};

const SaveTrainig = (username, password, trainingToSave) => {
  fetch("http://localhost:8080/api/public/user-page/save-training", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",

      Authorization: "Basic " + btoa(`${username}:${password}`),
    },
    body: JSON.stringify(trainingToSave),
  });
};
export { DelteteTrainigById, GetAllTrainings, SaveTrainig };
