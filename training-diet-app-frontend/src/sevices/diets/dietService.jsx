const GetAllDiets = (username, password) => {
  return fetch("http://localhost:8080/api/public/user-page/trainings", {
    headers: {
      Authorization: "Basic " + btoa(`${username}:${password}`),
    },
  });
};
export default GetAllDiets;
