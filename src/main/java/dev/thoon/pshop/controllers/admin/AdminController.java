package dev.thoon.pshop.controllers.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.thoon.pshop.dto.EditProductForm;
import dev.thoon.pshop.entity.Product;
import dev.thoon.pshop.services.OrderService;
import dev.thoon.pshop.services.ProductService;

@Controller
public class AdminController {
    
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    private ProductService productService;

    private OrderService orderService;

    public AdminController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping(value = "/admin/single-product")
    public String editItem(Model model) {
        model.addAttribute("loginError", true);
        return "/single-product";
    }

    @GetMapping(value = "admin/editItem")
    public String viewEditItem(@RequestParam("id") Long id, Model model) {

        Product product = productService.findProductById(id);
        model.addAttribute("editProduct", product);
        model.addAttribute("editProductForm", new EditProductForm());
        model.addAttribute("specCategoryList", productService.findAllSpecCategory());
        System.out.println("Product id" + id);
        return "edit-items";
    }

}
