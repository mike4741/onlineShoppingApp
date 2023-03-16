package org.perscholas.onlineshoppingapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.onlineshoppingapp.service.cart.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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
                                    Model model , Principal principal) throws Exception {
            String  userID = principal.getName();
//            String userID = "mike@gmail.com";
            log.info(Id+"at controller cart plus the user email "+ userID);
            cartService.addToCart(Id , userID);
            return "redirect:/index";
        }

    @GetMapping("/cart")
    public String getAllToCart(Model model , Principal principal ) {
        String  email = principal.getName();
//        String email = "mike@gmail.com";
        model.addAttribute("cartResponse", cartService.getCartByUserId( email));
   System.out.println(cartService.getCartByUserId( email));
        return "cart";
    }


    @GetMapping("deleteCartItem/{id}")
    public String deleteCartItem(@PathVariable(name = "id") int id) throws Exception {
        cartService.deleteCartItem(id);
        return "redirect:/cart";
    }






}
