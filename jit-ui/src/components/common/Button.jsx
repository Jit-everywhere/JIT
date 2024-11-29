import React from "react";
import Button from "@mui/material/Button";
import { makeStyles } from "@mui/styles";

const useStyles = makeStyles({
  customButton: {
    margin: "12px 0",
    padding: "10px 20px",
    fontFamily: "'Roboto', sans-serif",
    fontSize: "16px",
    fontWeight: "bold",
    borderRadius: "8px",
    textTransform: "capitalize",
  },
  containedPrimary: {
    backgroundColor: "#f4a261",
    color: "#ffffff",
    "&:hover": {
      backgroundColor: "#e76f51",
    },
  },
  outlinedPrimary: {
    color: "#f4a261",
    border: "2px solid #f4a261",
    "&:hover": {
      backgroundColor: "#fef6f0",
    },
  },
});

const ButtonComponent = ({
  label,
  onClick,
  className,
  variant = "contained",
  color = "primary",
  sx = {},
}) => {
  const classes = useStyles();

  const variantClass =
    variant === "contained" && color === "primary"
      ? classes.containedPrimary
      : variant === "outlined" && color === "primary"
      ? classes.outlinedPrimary
      : "";

  return (
    <Button
      className={`${classes.customButton} ${variantClass} ${className}`}
      variant={variant}
      color={color}
      onClick={onClick}
      sx={{ ...sx }}
    >
      {label}
    </Button>
  );
};

export default ButtonComponent;
