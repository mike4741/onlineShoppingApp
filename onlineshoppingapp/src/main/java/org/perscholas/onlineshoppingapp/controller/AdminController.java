package org.perscholas.onlineshoppingapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.onlineshoppingapp.dto.catalog.ItemDto;
import org.perscholas.onlineshoppingapp.dto.catalog.ItemDto2;
import org.perscholas.onlineshoppingapp.dto.catalog.ItemResponse;
import org.perscholas.onlineshoppingapp.models.User.MyUser;
import org.perscholas.onlineshoppingapp.models.catalog.Brand;
import org.perscholas.onlineshoppingapp.models.catalog.Image;
import org.perscholas.onlineshoppingapp.models.catalog.Item;
import org.perscholas.onlineshoppingapp.service.catalog.ImageService;
import org.perscholas.onlineshoppingapp.service.catalog.ItemService;
import org.perscholas.onlineshoppingapp.service.user.MyUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@Controller
//@RequestMapping("/admin")
@Slf4j
public class AdminController {
    private ItemService itemService;
    private ImageService imageService;

    public AdminController(ItemService itemService, ImageService imageService) {
        this.itemService = itemService;
        this.imageService = imageService;
    }

    @PostMapping("/brand")
    public String updateOrCreateBrand(@ModelAttribute("brand") Brand brand, Model model) {
        model.addAttribute("brand", itemService.saveBrand(brand));
        model.addAttribute("message", "success");
        return "index";
    }


    @GetMapping("/brand2")
    public String getAll(Model model) {
        model.addAttribute("brand", itemService.getAllBrands());
        return "brand";
    }

    @PostMapping("/addNewItem")
    public String updateOrCreateItem(@ModelAttribute("itemDto") ItemDto2 itemDto2,
                                     @RequestParam("image") MultipartFile image,
                                     Model model) throws Exception {
log.info("add controller "+ itemDto2.getName());
        ItemDto fromDb = itemService.saveItem(image, itemDto2);
        model.addAttribute("message", "success");
        return "redirect:/addNewItem";
    }



    @GetMapping("/update")
    public String getAllTypAndBrand(Model model) {
        model.addAttribute("brand", itemService.getAllBrands());
//        model.addAttribute("type", itemService.getAllTypes());
        return "update";
    }


    @PostMapping("/update")
    public String updatePassword(@ModelAttribute("myUser") MyUser myUser, Model model , Principal principal) {
        String  email = principal.getName();
//        model.addAttribute("myUser", MyUserService.updatePassword(email ,myUser));
      //        model.addAttribute("type", itemService.getAllTypes());
        return "update";
    }
}
