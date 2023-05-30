import { useState, useEffect } from "react";
// import UserNavbar from "./usernavbar";
// import NotesSchow from "./notesshow";
// import "./allnotes.css";

import { useNavigate } from "react-router-dom";

const TrainingMain = () => {
  const [userData, setUserData] = useState(null);
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();
  useEffect(() => {
    const username = localStorage.getItem("email");
    const password = localStorage.getItem("password");
    const loggedIn = localStorage.getItem("isLoggedIn");
    if (loggedIn !== "true") {
      navigate("/login");
    }

    if (username && password) {
      fetch("http://localhost:8080/api/public/user-page", {
        headers: {
          Authorization: "Basic " + btoa(`${username}:${password}`),
        },
      })
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
  const handleNoteDeletion = (id) => {
    setUserData((prevUserData) =>
      prevUserData.filter((item) => item.id !== id)
    );
  };

  return (
    <div>
      <h2>Main trainings</h2>
    </div>
    // <div>
    //   <UserNavbar />
    //   {/* <div className="all-notes-container"> */}
    //   {loading ? (
    //     <p>Loading...</p>
    //   ) : userData ? (
    //     <div
    //       style={{
    //         backgroundImage: `url(${userBacground})`,
    //         backgroundSize: "cover",
    //         backgroundPosition: "center",
    //         height: "100vh",
    //       }}
    //       className="parent"
    //     >
    //       {userData.map((item) => (
    //         <div key={item.id} className="column">
    //           <NotesSchow
    //             val={item}
    //             onNoteDelete={handleNoteDeletion}
    //             className="note"
    //           />
    //         </div>
    //       ))}
    //     </div>
    //   ) : (
    //     <p>No data available</p>
    //   )}
    //   {/* </div> */}
    // </div>
  );
};

export default TrainingMain;
