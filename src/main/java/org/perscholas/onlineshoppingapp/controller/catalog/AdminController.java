package org.perscholas.onlineshoppingapp.controller.catalog;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.onlineshoppingapp.dto.catalog.ItemDto;
import org.perscholas.onlineshoppingapp.dto.catalog.ItemDto2;
import org.perscholas.onlineshoppingapp.dto.catalog.ItemResponse;
import org.perscholas.onlineshoppingapp.models.catalog.Brand;
import org.perscholas.onlineshoppingapp.models.catalog.Image;
import org.perscholas.onlineshoppingapp.models.catalog.Item;
import org.perscholas.onlineshoppingapp.service.catalog.ImageService;
import org.perscholas.onlineshoppingapp.service.catalog.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

//    @GetMapping("/cart")
//    public String getCart() {
//
//        return "cart";
//    }


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
        return "addNewItem";
    }


}
