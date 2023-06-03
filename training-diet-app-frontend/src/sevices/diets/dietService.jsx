const GetAllDiets = (username, password) => {
  return fetch("http://localhost:8080/api/public/user-page/diets", {
    headers: {
      Authorization: "Basic " + btoa(`${username}:${password}`),
    },
  });
};
const SaveDiet = (username, password, dietToSave) => {
  fetch("http://localhost:8080/api/public/user-page/save-diet", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",

      Authorization: "Basic " + btoa(`${username}:${password}`),
    },
    body: JSON.stringify(dietToSave),
  });
};
export { GetAllDiets, SaveDiet };
