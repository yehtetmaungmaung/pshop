package dev.thoon.pshop.services;

import java.util.Collection;
import java.util.List;

import dev.thoon.pshop.model.ShoppingCartItem;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public interface CookieService {
    
    String createShoppingCartCookie(Collection<ShoppingCartItem> items);
    public Cookie findCookie(HttpServletRequest req, String cookieName);

    List<ShoppingCartItem> parseShoppingCartCookie(String cookieValue);
}
