package org.megatienda.modelss.product;

public class ModelProduct {
    private String id;
    private String name;
    private String description;
    private Double price;
    private String category;
    private String brand;
    private Integer stock;
    private String imageUrl;
    private Double rating;
    private String currency;

    // Constructor vacío
    public ModelProduct() {
    }

    // Constructor con parámetros
    public ModelProduct(String id, String name, String description, Double price,
                   String category, String brand, Integer stock,
                   String imageUrl, Double rating, String currency) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.stock = stock;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.currency = currency;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public String getCurrency() {
        return currency;
    }


    public void setActive(boolean b) {
    }

}
