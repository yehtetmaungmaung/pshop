package dev.thoon.pshop.services.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.thoon.pshop.model.ShoppingCartItem;
import dev.thoon.pshop.services.CookieService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class CookieServiceImpl implements CookieService {

    @Override
    public String createShoppingCartCookie(Collection<ShoppingCartItem> items) {

        StringBuilder res = new StringBuilder();
        for (ShoppingCartItem item : items) {
            res.append(item.getProduct().getId()).append("-").append(item.getCount()).append("|");
        }
        if (res.length() > 0) {
            res.deleteCharAt(res.length() - 1);
        }

        return res.toString();
    }

    @Override
    public Cookie findCookie(HttpServletRequest req, String cookieName) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(cookieName)) {
                    if (c.getValue() != null && !"".equals(c.getValue())) {
                        return c;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public List<ShoppingCartItem> parseShoppingCartCookie(String cookieValue) {
        return null;
    }
}
