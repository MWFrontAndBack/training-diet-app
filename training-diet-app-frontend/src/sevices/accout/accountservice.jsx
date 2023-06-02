const GetUserAccoutData = (username, password) => {
  return fetch("http://localhost:8080/api/public/user-page/account", {
    headers: {
      Authorization: "Basic " + btoa(`${username}:${password}`),
    },
  });
};
export default GetUserAccoutData;
