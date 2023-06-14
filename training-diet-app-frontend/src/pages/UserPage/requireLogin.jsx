import { useEffect } from "react";
import { navigate, useNavigate } from "react-router-dom";
const RequireLogin = () => {
  const navigate = useNavigate();

  useEffect(() => {
    let logged = localStorage.getItem("isLoggedIn");

    if (logged !== "true") {
      navigate("/login");
    }
  }, []);

  return null;
};

export default RequireLogin;
