package com.sgiasia.javaspringboot.jdbcbasic;

import com.sgiasia.javaspringboot.jdbcbasic.model.Product;
import com.sgiasia.javaspringboot.jdbcbasic.repository.ProductRepo;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ProductRepo productRepo = new ProductRepo();
        List<Product> products = null;

        try{
            products = productRepo.retrive();
        }
        catch (SQLException e){
            System.out.println("Gagal mendapatkan data product");
        }

        for (Product p: products)
        {
        System.out.println(p);
        }
    }
}