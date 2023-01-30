package com.sgiasia.javaspringboot.jdbcbasic.model;

public class Product {

    private Long id;
    private String productName;
    private Long productPrice;

//    public Product(Long id, String productName, Long productPrice){
//        this.id=id;
//        this.productName=productName;
//        this.productPrice=productPrice;
//    }

//    public Product(){
//
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString(){
        return "Product " + this.id + ", " + this.productName + ", " + this.productPrice;
    }
}

