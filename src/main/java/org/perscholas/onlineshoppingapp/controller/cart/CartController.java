package org.perscholas.onlineshoppingapp.controller.cart;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.onlineshoppingapp.service.cart.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/cart")
@Slf4j
public class CartController {

    private CartService cartService ;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


        @PostMapping("/addNewCart")
        public String addItemToCart(@RequestParam("Id") int Id ,
                                       Model model) throws Exception {
            log.info(Id+"at controller cart ");
            cartService.addToCart(Id);
            return "about";
        }

    @GetMapping("/cart")
    public String getAllToCart(Model model) {
        String email = "abc@gmail.com";
        model.addAttribute("cartResponse", cartService.getCartByUserId( email));
        return "cart";
    }







}
