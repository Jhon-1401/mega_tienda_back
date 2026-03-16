package org.megatienda.cart.model;

public class CartItem {

    private int productId;
    private int quantity;
    private String name;
    private Double price;
    private String imageUrl;

    public CartItem(){}

    public CartItem(int productId, int quantity){
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getProductId(){
        return productId;
    }

    public void setProductId(int productId){
        this.productId = productId;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public Double getPrice() {
    return price;
}

public void setPrice(Double price) {
    this.price = price;
}

public String getImageUrl() {
    return imageUrl;
}

public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
}
}