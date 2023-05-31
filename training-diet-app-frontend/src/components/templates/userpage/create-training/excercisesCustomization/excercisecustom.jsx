import "./custom.css";
const CustomExcercises = (props) => {
  let item = props.excercise;
  //   console.log(excer);
  return (
    <div id="parent">
      <div className="left">
        <h3>Exercise {item.excercise.id}</h3>
        <p>Name: {item.excercise.name}</p>
        <p>Series: {item.excercise.series}</p>
        <p>Reps: {item.excercise.reps}</p>
        <p>Training Type: {item.excercise.trainingType}</p>
      </div>
      <div className="right">
        <h4>Alternatives:</h4>
        {item.alternatives.map((alternative, idx) => (
          <div key={idx}>
            <p>Name: {alternative.name}</p>
            <p>Series: {alternative.series}</p>
            <p>Reps: {alternative.reps}</p>
            <p>Training Type: {alternative.trainingType}</p>
          </div>
        ))}
      </div>
    </div>
  );
};
export default CustomExcercises;
