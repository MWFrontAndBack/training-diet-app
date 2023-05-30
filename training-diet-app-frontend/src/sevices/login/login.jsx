const DoLogin = (email, password) => {
  return fetch("http://localhost:8080/api/public/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Authorization: "Basic " + btoa(email + ":" + password),
    },
    body: JSON.stringify({ email, password }),
  });
};

const CreateAccount = (loginName, password, email) => {
  return fetch("http://localhost:8080/api/public/create-user", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ loginName, password, email }),
  });
};

export { DoLogin, CreateAccount };
