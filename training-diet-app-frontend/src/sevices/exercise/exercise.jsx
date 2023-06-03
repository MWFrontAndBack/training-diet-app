const GetExerciseseByTrainingType = (username, password, type) => {
  return fetch(
    `http://localhost:8080/api/public/user-page/excercises?type=${type}`,
    {
      headers: {
        Authorization: "Basic " + btoa(`${username}:${password}`),
      },
    }
  );
};

export default GetExerciseseByTrainingType;
