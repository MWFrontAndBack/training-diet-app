const GetMealByMealType = (username, password, type) => {
  return fetch(
    `http://localhost:8080/api/public/user-page/meals?type=${type}`,
    {
      headers: {
        Authorization: "Basic " + btoa(`${username}:${password}`),
      },
    }
  );
};
const DelteteMealbyId = (username, password, id) => {
  return fetch(`http://localhost:8080/api/public/user-page/delete-diet/${id}`, {
    headers: {
      Authorization: "Basic " + btoa(`${username}:${password}`),
    },
  });
};

export { DelteteMealbyId, GetMealByMealType };
