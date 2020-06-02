package com.thnoh.spring.controller;

import com.thnoh.spring.model.Product;
import com.thnoh.spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * class : AdminController
 *
 * 관리자 페이지 , 제품 관리 담당
 *
 * TODO (update , delete , add)에서 method를 Put , delete , post로 하는 방법을 찾아서 수정.
 * TODO file upload 파트에서 path부분의 language가 7로 downgrade가 필요.
 */

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


    /**
     * controller          ->              dispatcher          ->             view
     *        model(product , bindingresult)      model(product , bindingresult)
     *
     * controller 부터 넘어가는 동안 model에 product와 bindingresult 둘다 담겨서 넘어감.
     * 그래서, 사용자가 폼에서 validation을 위반해서 다시 입력하는 경우 위의 두 정보가 model에 담겨있기 때문에
     * 새로 입력할 필요없이 입력했던 정보 그대로 sf input에 적혀있음.
     */
    @RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid Product product, BindingResult bindingResult, HttpServletRequest request) throws IOException {

        //error handling
        if(bindingResult.hasErrors()){
            System.out.println("add Form data has some error");
            List<ObjectError> errors = bindingResult.getAllErrors();

            for(ObjectError error:errors){
                System.out.println(error.getDefaultMessage());
            }

            return "addProduct";
        }

        //file name handling
        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        //여기서 rootDirectory가 out폴더임.

        Path savePath = Paths.get(rootDirectory + "/resource/images/"+productImage.getOriginalFilename());

        if(productImage!=null && !productImage.isEmpty()){
            productImage.transferTo(new File(savePath.toString()));
        }

        product.setImageFilename(productImage.getOriginalFilename());

        productService.addProduct(product);

        return "redirect:/admin/productInventory";
        //redirect를 넣는 이유 : model에 아직 product가 들어가지 않았기 때문에 다시 productInventory에 해당하는 getProducts()를 호출해서 add된 product도 볼 수 있게하기 위함.
    }

    @RequestMapping(value="/productInventory/deleteProduct/{id}") // method => get? delete?
    public String deleteProduct(@PathVariable int id,HttpServletRequest request) throws IOException {

        Product product = productService.getProductById(id);

        //filename delete
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        Path savePath = Paths.get(rootDirectory + "/resource/images/"+product.getImageFilename());

        if(Files.exists(savePath)){
            Files.delete(savePath);
        }

        productService.deleteProduct(product);

        return "redirect:/admin/productInventory";
    }

    @RequestMapping(value = "/productInventory/updateProduct/{id}")
    public String updateProduct(@PathVariable int id, Model model){

        Product product = productService.getProductById(id);

        model.addAttribute("product",product);

        return "updateProduct";
    }

    @RequestMapping(value="/productInventory/updateProduct",method=RequestMethod.POST)
    public String updateProductPost(@Valid Product product,BindingResult bindingResult,HttpServletRequest request) throws IOException {

        if(bindingResult.hasErrors()){
            System.out.println("update Form data has some error");
            List<ObjectError> errors = bindingResult.getAllErrors();

            for(ObjectError error:errors){
                System.out.println(error.getDefaultMessage());
            }

            return "updateProduct";
        }

        //file name handling
        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        Path savePath = Paths.get(rootDirectory + "/resource/images/"+productImage.getOriginalFilename());

        if(productImage!=null && !productImage.isEmpty()) productImage.transferTo(new File(savePath.toString()));

        product.setImageFilename(productImage.getOriginalFilename());


        productService.updateProduct(product);

        return "redirect:/admin/productInventory";
    }


}
