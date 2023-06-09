import { useEffect, useState } from "react";
import DietDetails from "./dietDetails";
import { GetAllDiets } from "../../../../sevices/diets/dietService";
import RequireLogin from "../../../../pages/UserPage/requireLogin";

const OwnDiets = () => {
  const [userData, setUserData] = useState(null);
  const [loading, setLoading] = useState(true);
  const handleNoteDeletion = (id) => {
    setUserData((prevUserData) =>
      prevUserData.filter((item) => item.id !== id)
    );
  };
  useEffect(() => {
    const username = localStorage.getItem("email");
    const password = localStorage.getItem("password");
    if (username && password) {
      GetAllDiets(username, password)
        .then((response) => {
          if (response.ok) {
            return response.json();
          } else {
            throw new Error("Failed to fetch user data");
          }
        })
        .then((data) => {
          setUserData(data);
          setLoading(false);
        })
        .catch((error) => {
          console.error("Failed to fetch user data", error);
          setLoading(false);
        });
    }
  }, []);
  return (
    <div className="onwTraningContainer">
      <RequireLogin />
      {loading ? (
        <p>Loading...</p>
      ) : userData && userData.length > 0 ? (
        <div className="parent">
          {userData.map((item) => (
            <div className="column">
              <DietDetails val={item} ondelete={handleNoteDeletion} />
            </div>
          ))}
        </div>
      ) : (
        <p className="emptytrain">No Diet available</p>
      )}
    </div>
  );
};
export default OwnDiets;
