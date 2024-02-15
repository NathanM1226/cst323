package com.gcu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import com.gcu.business.ProductsBusinessServiceInterface;
import com.gcu.models.ProductModel;
import com.gcu.models.searchModel;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/products")
public class productController {
    
    @Autowired
    ProductsBusinessServiceInterface products;

    public productController(ProductsBusinessServiceInterface products){
        super();
        this.products = products;
    }

    @GetMapping("/")
    public String showAllProducts(Model model){
        
        List<ProductModel> items = products.getProducts();
        
        model.addAttribute("title", "Products");
        model.addAttribute("products", items);

        return "products"; 
    }

    @GetMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("title", "Add New Product");
        model.addAttribute("product", new ProductModel());
        return "newProduct";
    }

    @PostMapping("/processNew")
    public String processNew(@Valid ProductModel product, BindingResult bindingResult, Model model){
        products.addOne(product);

        model.addAttribute("title", "Added an item");
        return "redirect:/products/";
    }

    @GetMapping("/edit")
    public String editProduct(ProductModel productModel, Model model){
        model.addAttribute("title", "Edit order");
		model.addAttribute("product", productModel);
        return "editProduct";
    }

    @PostMapping("processEdit")
    public String processEdit(@Valid ProductModel product, BindingResult bindingResult, Model model){

        products.updateOne(product.getId(), product);

        List<ProductModel> items = products.getProducts();

        model.addAttribute("products", items); 
        return "redirect:/products/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@Valid ProductModel product, BindingResult bindingResult, Model model){
        products.deleteOne(product.getId());

        List<ProductModel> items = products.getProducts();
        model.addAttribute("products", items); 
        return "redirect:/products/";
    }

    @GetMapping("/search")
    public String searchForm(Model model){
        model.addAttribute("title", "Search Products");
        model.addAttribute("searchModel", new searchModel());
        return "search";
    }

    @PostMapping("/searchResults")
    public String searchProducts(@Valid searchModel searchModel, BindingResult bindingResult, Model model){
        
        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Search for Orders");
            return "search";
        }

        List<ProductModel> items = products.searchProducts(searchModel.getSearch());
        model.addAttribute("title", "Products Found");
        model.addAttribute("items", items);   
        return "search";
    }

}
