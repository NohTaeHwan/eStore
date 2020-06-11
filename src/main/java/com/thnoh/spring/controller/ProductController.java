package com.thnoh.spring.controller;

import com.thnoh.spring.model.Product;
import com.thnoh.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public String getProduct(Model model){

        List<Product> products = productService.getProducts();
        model.addAttribute("products",products);

        return "products";//view의 logical name
    }

    @RequestMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable int productId,Model model){

        Product product = productService.getProductById(productId);

        model.addAttribute("product",product);

        return "viewProduct";
    }

}
