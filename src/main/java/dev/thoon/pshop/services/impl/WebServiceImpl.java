package dev.thoon.pshop.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.thoon.pshop.entity.Product;
import dev.thoon.pshop.model.ShoppingCart;
import dev.thoon.pshop.services.CookieService;
import dev.thoon.pshop.services.ProductService;
import dev.thoon.pshop.services.WebService;
import dev.thoon.pshop.utils.Constants;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class WebServiceImpl implements WebService {
    
    private static final Logger logger = LoggerFactory.getLogger(WebServiceImpl.class);

    private final CookieService cookieService;

    private final ProductService productService;

    public WebServiceImpl(CookieService cookieService, ProductService productService) {
        this.cookieService = cookieService;
        this.productService = productService;
    }

    @Override
    public String serializeShoppingCart(ShoppingCart shoppingCart) {
        return cookieService.createShoppingCartCookie(shoppingCart.getItems());
    }

    public ShoppingCart deserializeShoppingCart(String string) {
        ShoppingCart shoppingCart = new ShoppingCart();
        String[] items = string.split("\\|");
        for (String item : items) {
            try {
                String data[] = item.split("-");
                long idProduct = Long.parseLong(data[0]);
                int count = Integer.parseInt(data[1]);
                Product product = productService.findProductById(idProduct);
                shoppingCart.addProduct(product, count);
            } catch (RuntimeException e) {
                logger.error("can't add product to ShoppingCart during deserialization: item=" + item, e);
            }
        }

        return shoppingCart;
    }


    @Override
    public boolean isCurrentShoppingCartCreated(HttpServletRequest req) {
        return req.getSession().getAttribute(Constants.CURRENT_SHOPPING_CART) != null;
    }
    @Override
    public void setCurrentShoppingCart(HttpServletRequest req, ShoppingCart shoppingCart) {
        req.getSession().setAttribute(Constants.CURRENT_SHOPPING_CART, shoppingCart);
    }
    @Override
    public void clearCurrentShoppingCart(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().removeAttribute(Constants.CURRENT_SHOPPING_CART);
        setCookie(Constants.Cookie.SHOPPING_CART.getName(), null, 0, resp);
    }
    @Override
    public Cookie findShoppingCartCookie(HttpServletRequest req) {
        return cookieService.findCookie(req, Constants.Cookie.SHOPPING_CART.getName());
    }


    @Override
    public  void updateCurrentShoppingCartCookie(String cookieValue, HttpServletResponse resp) {
        setCookie(Constants.Cookie.SHOPPING_CART.getName(), cookieValue,
                Constants.Cookie.SHOPPING_CART.getTtl(), resp);
    }

    @Override
    public  void setCookie(String name, String value, int age, HttpServletResponse resp) {
        Cookie c = new Cookie(name, value);
        c.setMaxAge(age);
        c.setPath("/");
        c.setHttpOnly(true);
        resp.addCookie(c);
    }

    @Override
    public String getCurrentRequestUrl(HttpServletRequest req) {
        String query = req.getQueryString();
        if (query == null) {
            return req.getRequestURI();
        } else {
            return req.getRequestURI() + "?" + query;
        }
    }


    @Override
    public ShoppingCart getCurrentShoppingCart(HttpServletRequest req) {
        return (ShoppingCart) req.getSession().getAttribute(Constants.CURRENT_SHOPPING_CART);
    }




//    public static CurrentAccount getCurrentAccount(HttpServletRequest req) {
//        return (CurrentAccount) req.getSession().getAttribute(Constants.CURRENT_ACCOUNT);
//    }

//    public static void setCurrentAccount(HttpServletRequest req, CurrentAccount currentAccount) {
//        req.getSession().setAttribute(Constants.CURRENT_ACCOUNT, currentAccount);
//    }
//
//    public static boolean isCurrentAccountCreated(HttpServletRequest req) {
//        return getCurrentAccount(req) != null;
//    }
}
