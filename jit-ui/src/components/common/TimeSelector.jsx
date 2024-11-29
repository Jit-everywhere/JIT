import React from "react";
import { LocalizationProvider } from "@mui/x-date-pickers";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { TimePicker } from "@mui/x-date-pickers";
import { makeStyles } from "@mui/styles";

const useStyles = makeStyles(() => ({
  timePickerContainer: {
    margin: "8px 0",
  },
  textField: {
    "& .MuiInputBase-root": {
      border: "1px solid #ccc",
      borderRadius: "4px",
      fontSize: "16px",
      transition: "all 0.3s ease",
    },
    "& .MuiInputBase-root:focus-within": {
      borderColor: "#1976d2",
      outline: "none",
    },
    "& .MuiInputBase-input::placeholder": {
      color: "#888",
    },
  },
}));

const TimeSelector = ({ value, onChange, sx }) => {
  const classes = useStyles();

  return (
    <LocalizationProvider dateAdapter={AdapterDayjs}>
      <TimePicker
        value={value}
        onChange={onChange}
        className={classes.timePickerContainer}
        slotProps={{
          textField: {
            className: classes.textField,
            size: "small",
            label: "Select Time",
          },
        }}
        sx={{ ...sx }}
      />
    </LocalizationProvider>
  );
};

export default TimeSelector;
