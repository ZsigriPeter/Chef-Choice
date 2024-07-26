import Dish from "./Dish";

function DishList({ dishes }) {
  return (
    <div className="dishList" key={1}>
      {dishes.map((dish) => {
        return <Dish dish={dish} key={dish.id} />;
      })}
    </div>
  );
}

export default DishList;
