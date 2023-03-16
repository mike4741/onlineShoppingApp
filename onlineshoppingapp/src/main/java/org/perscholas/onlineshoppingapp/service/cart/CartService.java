package org.perscholas.onlineshoppingapp.service.cart;

import org.perscholas.onlineshoppingapp.dto.cart.CartResponse;
import org.perscholas.onlineshoppingapp.models.cart.CartItem;

public interface CartService {



    void addToCart(int itemId , String userId);
    CartResponse getCartByUserId(String userId);
    void deleteCartItem(long id) throws Exception;
}
