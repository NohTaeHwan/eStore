package com.thnoh.spring.controller;

import com.thnoh.spring.model.Product;
import com.thnoh.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String getProducts(Model model) { //controller  -> model -> view

        List<Product> products = productService.getProducts();

        model.addAttribute("products", products);

        return "productInventory";

    }

    @RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.GET)
    public String addProduct(Model model) {

        Product product = new Product();

        model.addAttribute("product", product);

        return "addProduct";
    }

    @RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.POST)
    public String addProductPost(Product product) {

        if (!productService.addProduct(product))
            System.out.println("Adding product fail");


        return "redirect:/admin/productInventory";
        //redirect를 넣는 이유 : model에 아직 product가 들어가지 않았기 때문에 다시 productInventory에 해당하는 getProducts()를 호출해서 add된 product도 볼 수 있게하기 위함.
    }

    @RequestMapping(value="/productInventory/deleteProduct/{id}") // method => get? delete?
    public String deleteProduct(@PathVariable int id){

        if( !productService.deleteProduct(id))
            System.out.println("delete product fail");

        return "redirect:/admin/productInventory";
    }

    @RequestMapping(value = "/productInventory/updateProduct/{id}")
    public String updateProduct(@PathVariable int id, Model model){

        Product product = productService.getProductById(id);

        model.addAttribute("product",product);

        return "updateProduct";
    }

    @RequestMapping(value="/productInventory/updateProduct",method=RequestMethod.POST)
    public String updateProductPost(Product product){

        System.out.println(product);
        if( !productService.updateProduct(product))
            System.out.println("update product fail");

        return "redirect:/admin/productInventory";
    }


}
