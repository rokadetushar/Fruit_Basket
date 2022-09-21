package com.example.s.models;

public class FruitModel {
    private String brand, fruit_type, organic, price_per_kg, product_type, quality, url;

    public FruitModel() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFruit_type() {
        return fruit_type;
    }

    public void setFruit_type(String fruit_type) {
        this.fruit_type = fruit_type;
    }

    public String getOrganic() {
        return organic;
    }

    public void setOrganic(String organic) {
        this.organic = organic;
    }

    public String getPrice_per_kg() {
        return price_per_kg;
    }

    public void setPrice_per_kg(String price_per_kg) {
        this.price_per_kg = price_per_kg;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public FruitModel(String brand, String fruit_type, String organic, String price_per_kg, String product_type, String quality, String url) {
        this.brand = brand;
        this.fruit_type = fruit_type;
        this.organic = organic;
        this.price_per_kg = price_per_kg;
        this.product_type = product_type;
        this.quality = quality;
        this.url = url;
    }
}
