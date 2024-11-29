import React from "react";
import { makeStyles } from "@mui/styles";
import { Card, CardContent, CardMedia, Typography } from "@mui/material";
import ButtonComponent from "./Button";

const useStyles = makeStyles(() => ({
  foodCard: {
    display: "flex",
    alignItems: "center",
    padding: "16px",
    margin: "16px auto",
    borderRadius: "12px",
    boxShadow: "0 4px 8px rgba(0, 0, 0, 0.2)",
    width: "80%",
    gap: "16px",
  },
  foodImage: {
    width: "120px",
    height: "120px",
    objectFit: "cover",
    borderRadius: "8px",
  },
  cardContent: {
    display: "flex",
    flexDirection: "column",
    flexGrow: 1,
  },
  foodName: {
    fontWeight: "bold",
    fontSize: "1.25rem",
    marginBottom: "8px",
  },
  foodDescription: {
    fontSize: "0.95rem",
    color: "#555",
    marginBottom: "12px",
  },
  foodPrice: {
    fontSize: "1.1rem",
    fontWeight: "bold",
    color: "#1976d2",
    marginBottom: "12px",
  },
  addToCartButton: {
    display: "flex",
    justifyContent: "flex-end",
  },
}));

const FoodCard = ({ foods, addToCart }) => {
  const classes = useStyles();

  const getFoodCard = (food, addToCart, index) => {
    return (
      <Card className={classes.foodCard} key={index}>
        <CardMedia
          component="img"
          image={food?.image}
          alt={food?.name}
          className={classes.foodImage}
        />
        <CardContent className={classes.cardContent}>
          <Typography className={classes.foodName}>{food?.name}</Typography>
          <Typography className={classes.foodDescription}>
            {food?.description}
          </Typography>
          <Typography className={classes.foodPrice}>₹{food?.price}</Typography>
        </CardContent>
        <div className={classes.addToCartButton}>
          <ButtonComponent
            label="Add to Cart"
            onClick={() => addToCart(food)}
            className="custom-add-to-cart-button"
            variant="contained"
            color="primary"
          />
        </div>
      </Card>
    );
  };

  return <div style={{width: "100%"}}>{foods.map((food, index) => getFoodCard(food, addToCart))}</div>;
};

export default FoodCard;
