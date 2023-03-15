package org.perscholas.onlineshoppingapp.controller;

<<<<<<< HEAD:src/main/java/org/perscholas/onlineshoppingapp/controller/HomeController.java
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    public String homePage(){
        return  "index";
    }
=======
import lombok.extern.slf4j.Slf4j;
import org.perscholas.onlineshoppingapp.dto.cart.ItemsResponse;
import org.perscholas.onlineshoppingapp.dto.catalog.ItemResponse;
import org.perscholas.onlineshoppingapp.models.catalog.Brand;
import org.perscholas.onlineshoppingapp.models.catalog.Image;
import org.perscholas.onlineshoppingapp.models.catalog.Item;
import org.perscholas.onlineshoppingapp.models.catalog.Type;
import org.perscholas.onlineshoppingapp.service.catalog.ImageService;
import org.perscholas.onlineshoppingapp.service.catalog.ItemService;
import org.perscholas.onlineshoppingapp.utils.AppConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class HomeController {
    private ItemService itemService;
    private ImageService imageService;

    public HomeController(ItemService itemService, ImageService imageService) {
        this.itemService = itemService;
        this.imageService = imageService;
    }

    @GetMapping("/index")
    public String getAllItems(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            Model model) {

              ItemsResponse itemsResponse = itemService.getAllItems(pageNo, pageSize, sortBy, sortDir);
              log.info("for image check "+itemsResponse.toString());
        model.addAttribute("item", itemsResponse);

        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/addNewItem")
    public String addNewItem() {
        return "addNewItem";
    }


    @GetMapping("/myUser")
    public String updateOrCreateUser() {
        return "myUser";
    }

    @ModelAttribute("brand")
    public String getAllBrand(Model model) {
        model.addAttribute("brand", itemService.getAllBrands());
        return "brand";
    }

    @ModelAttribute("type")
    public String getAllType(Model model) {
        model.addAttribute("type", itemService.getAllTypes());
        return "type";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/403")
    public String access(){
        return "403";
    }

>>>>>>> b3276dd (applying security):onlineshoppingapp/src/main/java/org/perscholas/onlineshoppingapp/controller/HomeController.java
}
