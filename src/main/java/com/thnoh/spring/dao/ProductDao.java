package com.thnoh.spring.dao;

import com.thnoh.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProductDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getRowCount() {
        String sqlStatement = "select count(*) from offers";
        return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
    }

    public List<Product> getProducts() {

        return null;
    }
}
