import React from "react";
import {TextField} from "@mui/material";
import { makeStyles } from "@mui/styles";

const useStyles = makeStyles({
  inputField: {
    width: "100%",
    padding: "10px",
    margin: "8px 0",
    border: "1px solid #ccc",
    borderRadius: "4px",
    fontSize: "16px",
    transition: "all 0.3s ease",
    "&:focus": {
      borderColor: "#1976d2",
      outline: "none",
    },
    "&::placeholder": {
      color: "#888",
    },
  },
});

const InputComponent = ({ label, value, onChange, className, sx = {} }) => {
  const classes = useStyles();

  return (
    <TextField
      className={`${classes.inputField} ${className}`}
      label={label}
      variant="outlined"
      value={value}
      onChange={onChange}
      sx={{ ...sx }}
    />
  );
};

export default InputComponent;
