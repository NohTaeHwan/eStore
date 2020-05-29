package com.thnoh.spring.dao;

import com.thnoh.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Product> getProducts() {

        String sqlStatement = "select * from product";

        return jdbcTemplate.query(sqlStatement, new RowMapper<Product>() { //record -> object

            public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Product product = new Product();

                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setCategory(resultSet.getString("category"));
                product.setManufacturer(resultSet.getString("manufacturer"));
                product.setUnitInStock(resultSet.getInt("unitInStock"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getInt("price"));

                return product;
            }
        });
    }

    public boolean addProduct(Product product) {

        String name = product.getName();
        String category = product.getCategory();
        String description = product.getDescription();
        int price = product.getPrice();
        int unitInStock = product.getUnitInStock();
        String manufacturer = product.getManufacturer();

        String sqlStatement = "insert into product (name,category,price,manufacturer,unitInStock,description) "
                + "values (?,?,?,?,?,?) ";

        return (jdbcTemplate.update(sqlStatement,new Object[]{name,category,price,manufacturer,unitInStock,description})==1);

    }
}
