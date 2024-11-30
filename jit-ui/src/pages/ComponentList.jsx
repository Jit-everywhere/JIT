import React from "react";
import ButtonComponent from "../components/common/Button";
import DateSelector from "../components/common/DatePicker";
import DateTimeSelector from "../components/common/DateTimeSelector";
import InputComponent from "../components/common/Input";
import TimeSelector from "../components/common/TimeSelector";
import Map from "../components/common/Map";
import FoodCard from "../components/common/FoodCard";
import OrderTracker from "../components/common/OrderTracker";

const ComponentList = () => {
  const foods = [
    {
      name: "Biryani",
      description: "Test",
      price: "100",
    },
    {
      name: "Dosa",
      description: "Plain",
      price: "30",
    },
  ];

  return (
    <div style={{width: "80%", height: "100vh"}}>
      <div>Input</div>
      <InputComponent label={"Test"} sx={{ width: "20%" }} />
      <div>Button</div>
      <ButtonComponent label={"Button"} />
      <div>Date</div>
      <DateSelector />
      <div>Time</div>
      <TimeSelector />
      <div>Date and Time</div>
      <DateTimeSelector />
      <div>Map</div>
      <Map lat={37.7749} lng={-122.4194} />
      <div>Food Card</div>
      <FoodCard foods={foods} addToCart={() => {}} />
      <div>Order Tracker</div>
      <OrderTracker currentStep={2}/>
    </div>
  );
};

export default ComponentList;
