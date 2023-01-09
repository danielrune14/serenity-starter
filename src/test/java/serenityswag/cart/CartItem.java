package serenityswag.cart;

public class CartItem {
    String name;
    String description;
    Double price;

    public CartItem(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getItemName(){
        return name;
    }

    public String getItemDescription(){
        return description;
    }

    public Double getItemPrice(){
        return price;
    }
}
