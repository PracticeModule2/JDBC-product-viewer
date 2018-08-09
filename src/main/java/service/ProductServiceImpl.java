package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    static final String JDBC_Driver = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/awesomeBusiness";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "07091994";

    public ProductServiceImpl() {
    }


    @Override
    public List<Product> findAll() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_Driver);

        Connection conn = null;
        Statement sta = null;
        log("Dang ket noi toi co so du lieu...");

        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        log("Tao lenh truy van SQL... ");
        sta = conn.createStatement();
        String sql = "select product_id, product_name, product_code from products ";

        log("Dang thuc hien lenh truy van...");
        ResultSet rst = sta.executeQuery(sql);

        List<Product> products = new ArrayList<>();
        log("Dang thu nhap ket qua...");
        while (rst.next()) {
            Product product = new Product();
            product.setProduct_id(rst.getInt("product_id"));
            product.setProduct_code(rst.getString("product_code"));
            product.setProduct_name(rst.getString("product_name"));

            products.add(product);
        }
        log("hoan thanh thu nhap ket qua; dang dong cac ket noi...");
        rst.close();
        sta.close();
        conn.close();

        log("Thanh cong!");
        return products;
    }

    public void log(String message) {
        System.out.println(message);
    }
}
