package dev.thoon.pshop.controllers.client;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dev.thoon.pshop.entity.Product;
import dev.thoon.pshop.entity.SpecCategory;
import dev.thoon.pshop.services.ProductService;
import dev.thoon.pshop.utils.Constants;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

public class WelcomeController {
    
    private final ProductService productService;

    private final ServletContext servletContext;

    public WelcomeController(ProductService productService, ServletContext servletContext) {
        this.productService = productService;
        this.servletContext = servletContext;
    }

    @GetMapping(value = "/")
    public String welcome(Model model, HttpSession session) {

        List<SpecCategory> specCategories = (List<SpecCategory>) servletContext.getAttribute(Constants.SPECCATEGORY_LIST);
        List<Product> products = productService.listAllProductsBySpecCategory(specCategories.get(0).getId(), PageRequest.of(0, Constants.MAX_PRODUCTS_PER_HTML_PAGE));

        model.addAttribute("products", products);
        model.addAttribute("specCategory", specCategories.get(0));
        model.addAttribute("specCategoryList", specCategories);
        return "index";
    }
}
