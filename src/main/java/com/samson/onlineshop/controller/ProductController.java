package com.samson.onlineshop.controller;

import com.samson.onlineshop.domain.Product;
import com.samson.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/market")
public class ProductController {


    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products")
    public String list(Model model) {

        /*Product iphone = new Product("11", "iPhone 6s", new BigDecimal(500));
        iphone.setCategory("Smart Phone");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);
        model.addAttribute("product", iphone);
        */

        model.addAttribute("products", productService.getAllProducts());

        return "products";
    }

    @RequestMapping(value = "/all")
    public ModelAndView getAllProducts(){
        ModelAndView modelAndView =  new ModelAndView();
        modelAndView.addObject("products", productService.getAllProducts());
        modelAndView.setViewName("products");
        return modelAndView;
    }

    @RequestMapping("/update/stock")
    public String updateStock(Model model) {
        productService.updateAllStock();
        return "redirect:/market/products";
    }

    @RequestMapping(value = "/products/{category}")
    public String listProductsByCategory(Model model, @PathVariable("category") String productCategory){
        model.addAttribute("products", productService.getProductsByCategory(productCategory));
        return "products";
    }

    @RequestMapping(value = "products/filter/{params}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "params") Map<String, List<String>> filterParams, Model model){
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }

    @RequestMapping(value = "/product")
    public String getProductById(@RequestParam("id") String productId, Model model){
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.GET)
    public String addNewProductForm(Model model){
        Product newProduct = new Product();
        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public String processNewProductForm(@ModelAttribute("newProduct") Product product){
        productService.addProduct(product);
        return "redirect:/market/products";
    }

}
