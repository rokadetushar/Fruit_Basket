package com.example.s.activities;

public class fruitdb {

    // Model class

    String fruit_type;
    String brand;
    String url;
    String organic;
    String price_per_kg;
    String produce_type;
    String quality;

    //Constructors


    public fruitdb() {
    }

    public fruitdb(String fruit_type, String brand, String url, String organic, String price_per_kg, String produce_type, String quality) {
        this.fruit_type = fruit_type;
        this.brand = brand;
        this.url = url;
        this.organic = organic;
        this.price_per_kg = price_per_kg;
        this.produce_type = produce_type;
        this.quality = quality;
    }

}
