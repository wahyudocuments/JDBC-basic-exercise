package com.sgiasia.javaspringboot.jdbcbasic.repository;

import com.sgiasia.javaspringboot.jdbcbasic.helper.JDBCHelper;
import com.sgiasia.javaspringboot.jdbcbasic.model.Product;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo {

    public List<Product> retrive() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Product> products = new ArrayList<Product>();

        try {
            con = JDBCHelper.getConnection();
            if(con == null){
                return products;
            }

            String sqlPrep = "SELECT * FROM product";
            ps = con.prepareStatement(sqlPrep);
            rs = ps.executeQuery();
            while(rs.next()){
                Product p = new Product();
                p.setId(rs.getLong("id"));
                p.setProductName(rs.getString("product_name"));
                p.setProductPrice(rs.getLong("product_price"));
                products.add(p);
            }
            JDBCHelper.closeResultSet(rs);
            JDBCHelper.closePrepaerdStatement(ps);
            JDBCHelper.closeConnection(con);
        } catch (SQLException e){
            System.out.println("Gagal Mendapatkan data Product");
            System.out.println(e.getMessage());
//            throw new RuntimeException(e);
        }
        return products;
    }
}
