package org.perscholas.onlineshoppingapp.dao;

import org.perscholas.onlineshoppingapp.models.cart.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<CartItem,Long> {
    List<CartItem> findByUserId(String userId);

}
