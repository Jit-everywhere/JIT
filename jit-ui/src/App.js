import "./App.css";
import ButtonComponent from "./components/common/Button/Button";
import InputComponent from "./components/common/Input/Input";

function App() {
  return (
    <div className="App">
      {/* Sample */}
      <InputComponent label={"Test"} sx={{ width: "20%" }} />
      <ButtonComponent label={"Button"} />
    </div>
  );
}

export default App;
