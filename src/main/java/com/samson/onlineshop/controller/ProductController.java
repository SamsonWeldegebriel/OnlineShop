package com.samson.onlineshop.controller;


import com.samson.onlineshop.domain.Product;
import com.samson.onlineshop.exception.NoProductsFoundUnderCategoryException;
import com.samson.onlineshop.exception.ProductNotFoundException;
import com.samson.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Arrays;
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
    public ModelAndView getAllProducts() {
        ModelAndView modelAndView = new ModelAndView();
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
    public String listProductsByCategory(Model model, @PathVariable("category") String productCategory) {
        List<Product> products = productService.getProductsByCategory(productCategory);
        //ResponseStatus - Exception handling when there are no products found under the category.
        if (products.isEmpty() || products == null) {
            throw new NoProductsFoundUnderCategoryException();
        }
        model.addAttribute("products", productService.getProductsByCategory(productCategory));
        return "products";
    }


    /*
        http://localhost:8080/market/products/filter/params;brands=Google,Dell;categories=Tablet,Laptop
        showing products based on filters Consider a situation where we want to filter the product list
         based on brands and categories. For example, you want to list all the products that fall
         under the category Laptop and Tablets and from the manufacturer Google and Dell.
     */
    @RequestMapping(value = "products/filter/{params}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "params") Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }

    @RequestMapping(value = "/product")
    public String getProductById(@RequestParam(value = "id", required = false) String productId, Model model) {
        Product product = productService.getProductById(productId);
        //Handle Exception when no product found with the specified ID.
        if (product == null) {
            throw new ProductNotFoundException(productId);
        }
        model.addAttribute("product", product);
        return "product";
    }

    // Handling no product found Exception
    @ExceptionHandler(ProductNotFoundException.class)
    public String handleError(Model model, HttpServletRequest request, ProductNotFoundException e) {
        model.addAttribute("invalidProduct", e.getProductId());
        model.addAttribute("exception", e);
        model.addAttribute("url", request.getRequestURL() + request.getQueryString());
        return "productNotFound";
    }

    // Handling no Product under Category Exception
    @ExceptionHandler(NoProductsFoundUnderCategoryException.class)
    public String handleNoProductsError(Model model, HttpServletRequest request, NoProductsFoundUnderCategoryException e) {
        model.addAttribute("invalidProduct", e);
        model.addAttribute("exception", e);
        model.addAttribute("url", request.getRequestURL() + request.getQueryString());
        return "productNotFound";
    }


    @RequestMapping(value = "/addproduct", method = RequestMethod.GET)
    public String addNewProductForm(Model model) {
        Product newProduct = new Product();
        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public String processNewProductForm(@ModelAttribute("newProduct") Product newProduct, BindingResult bindingResult,
                                        HttpServletRequest request) {
        String[] suppressedFileds = bindingResult.getSuppressedFields();
        if (suppressedFileds.length > 0) {
            throw new RuntimeException("Trying to enter disallowed fields: " +
                    Arrays.asList(suppressedFileds));
        }

        MultipartFile productImage = newProduct.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(rootDirectory + "resources\\images\\" + newProduct.getProductId() + ".png"));
            } catch (Exception e) {
                throw new RuntimeException("Product Image saving failed", e);
            }
        }

        productService.addProduct(newProduct);
        return "redirect:/market/products";
    }


    @InitBinder
    public void initializeBinder(WebDataBinder binder) {
        binder.setAllowedFields("productId", "name", "description", "unitPrice", "manufacturer", "category", "unitsInStock",
                "condition", "productImage", "language");

    }


    @RequestMapping("/products/invalidPromoCode")
    public String invalidPromoCode() {
        return "invalidPromoCode";
    }



}
