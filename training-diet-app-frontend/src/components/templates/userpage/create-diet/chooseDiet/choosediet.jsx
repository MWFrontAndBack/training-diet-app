const ChooseDiet = () => {
  return (
    <div>
      <OptionsNavbar />
      <div
        className="center"
        style={{
          backgroundImage: `url(${backgroundSVG})`,
          height: "100vh",
          backgroundSize: "cover",
        }}
      >
        <form className="login-form" onSubmit={handleSubmit}>
          <label className="customlb">Training with Diet</label>

          <input
            type="radio"
            value="trainAndDiet"
            name="anserw"
            onChange={handleChange}
          />

          <label className="customlb">Only Training</label>
          <input
            type="radio"
            value="train"
            name="anserw"
            onChange={handleChange}
          />

          <input className=" login-button " type="submit" value="Submit" />
        </form>
      </div>
    </div>
  );
};

export default ChooseDiet;
