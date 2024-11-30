import React from "react";
import { makeStyles } from "@mui/styles";
import { Box } from "@mui/material";

const useStyles = makeStyles(() => ({
  orderTracker: {
    display: "flex",
    alignItems: "center",
    justifyContent: "space-between",
    padding: "8px 16px",
    borderRadius: "8px",
    background: "#f9f9f9",
    boxShadow: "0 2px 4px rgba(0, 0, 0, 0.1)",
  },
  milestone: {
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    flex: 1,
    textAlign: "center",
  },
  statusPill: {
    padding: "4px 12px",
    borderRadius: "16px",
    fontSize: "0.875rem",
    fontWeight: "bold",
    color: "#fff",
    marginBottom: "8px",
    textTransform: "capitalize",
  },
  statusPlaced: {
    backgroundColor: "#4caf50", // Green for "Order Placed"
  },
  statusCooking: {
    backgroundColor: "#ff9800", // Orange for "Cooking"
  },
  statusReady: {
    backgroundColor: "#2196f3", // Blue for "Ready for Pickup"
  },
  statusDelivered: {
    backgroundColor: "#9c27b0", // Purple for "Delivered"
  },
}));

const OrderTracker = ({ currentStep }) => {
  const classes = useStyles();
  const milestones = [
    { label: "Order Placed", className: classes.statusPlaced },
    { label: "Cooking", className: classes.statusCooking },
    { label: "Ready for Pickup", className: classes.statusReady },
    { label: "Delivered", className: classes.statusDelivered },
  ];

  return (
    <Box className={classes.orderTracker}>
      {milestones.map((step, index) => (
        <Box key={index} className={classes.milestone}>
          <div className={`${classes.statusPill} ${step.className}`}>
            {step.label}
          </div>
        </Box>
      ))}
    </Box>
  );
};

export default OrderTracker;
