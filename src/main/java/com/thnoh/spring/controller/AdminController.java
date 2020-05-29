package com.thnoh.spring.controller;

import com.thnoh.spring.model.Product;
import com.thnoh.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public String adminPage(){
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String getProducts(Model model){ //controller  -> model -> view

        List<Product> products = productService.getProducts();

        model.addAttribute("products",products);

        return "productInventory";

    }

    @RequestMapping(value="/productInventory/addProduct", method = RequestMethod.GET)
    public String addProduct(Model model){

        Product product = new Product();

        model.addAttribute("product",product);

        return "addProduct";
    }

    @RequestMapping(value="/productInventory/addProduct", method = RequestMethod.POST)
    public String addProductPost(Product product){

        if(!productService.addProduct(product))
            System.out.println("Adding product fail");


        return "redirect:/admin/productInventory";
        //redirect를 넣는 이유 : model에 아직 product가 들어가지 않았기 때문에 다시 productInventory에 해당하는 getProducts()를 호출해서 add된 product도 볼 수 있게하기 위함.
    }

}
