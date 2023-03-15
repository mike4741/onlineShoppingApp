package org.perscholas.onlineshoppingapp.controller.catalog;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.onlineshoppingapp.dto.cart.ItemsResponse;
import org.perscholas.onlineshoppingapp.dto.catalog.ItemDto;
import org.perscholas.onlineshoppingapp.models.catalog.Brand;
import org.perscholas.onlineshoppingapp.models.catalog.Type;
import org.perscholas.onlineshoppingapp.service.catalog.ItemService;
import org.perscholas.onlineshoppingapp.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD:src/main/java/org/perscholas/onlineshoppingapp/controller/catalog/ItemController.java
=======
import org.springframework.ui.Model;
>>>>>>> b3276dd (applying security):onlineshoppingapp/src/main/java/org/perscholas/onlineshoppingapp/controller/catalog/ItemController.java
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
<<<<<<< HEAD:src/main/java/org/perscholas/onlineshoppingapp/controller/catalog/ItemController.java
@Slf4j
=======

>>>>>>> b3276dd (applying security):onlineshoppingapp/src/main/java/org/perscholas/onlineshoppingapp/controller/catalog/ItemController.java
public class ItemController {
    private ItemService itemService;
@Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

<<<<<<< HEAD:src/main/java/org/perscholas/onlineshoppingapp/controller/catalog/ItemController.java

    @PostMapping("/addItem")
    public ResponseEntity<ItemDto> saveItem(@RequestBody  ItemDto itemDto  , @RequestParam Long typeId,  @RequestParam Long brandId){
        System.out.println("one");
        log.info(itemDto.toString());

        return new ResponseEntity<ItemDto>(itemService.saveItem(itemDto,typeId,brandId), HttpStatus.CREATED);
    }

    @PostMapping("/brand")
    public ResponseEntity<Brand> saveBrand (@RequestBody Brand brand){
        return new ResponseEntity<Brand>(itemService.saveBrand(brand), HttpStatus.CREATED);
=======
@PostMapping("/form/addItem")
public String updateOrCreateItem(@ModelAttribute("itemDto") ItemDto itemDto,@RequestParam Long typeId,@RequestParam Long brandId, Model model){
    model.addAttribute("itemDto", itemService.saveItem(itemDto,typeId,brandId));
    model.addAttribute("message", "success");
    return "form";
}



@GetMapping("/form")
public String saveBrand (){
//log.info("get mapping get called");

    return "xx";
}
    @PostMapping("/form/addBrand")
    public String saveBrand (@ModelAttribute ("brand") Brand brand){
//        log.info("get mapping get called 1st ");
            itemService.saveBrand(brand);
//        log.info("get mapping get called 2st ");
        return "xx";
>>>>>>> b3276dd (applying security):onlineshoppingapp/src/main/java/org/perscholas/onlineshoppingapp/controller/catalog/ItemController.java
    }

    @PostMapping("/type")
    public ResponseEntity<Type> saveType (@RequestBody Type type){
        return new ResponseEntity<Type>(itemService.saveType(type), HttpStatus.CREATED);
    }

    @GetMapping("/brands")
    public String getAllBrands() {

       itemService.getAllBrands();
<<<<<<< HEAD:src/main/java/org/perscholas/onlineshoppingapp/controller/catalog/ItemController.java
      return  "index";
=======
      return  "xx";
>>>>>>> b3276dd (applying security):onlineshoppingapp/src/main/java/org/perscholas/onlineshoppingapp/controller/catalog/ItemController.java
    }

    @GetMapping("/types")
    public String getAllTypes() {

      itemService.getAllTypes();
<<<<<<< HEAD:src/main/java/org/perscholas/onlineshoppingapp/controller/catalog/ItemController.java
      log.info( itemService.getAllTypes().toString());
        return  "index";
=======
//      log.info( itemService.getAllTypes().toString());
        return  "xx";
>>>>>>> b3276dd (applying security):onlineshoppingapp/src/main/java/org/perscholas/onlineshoppingapp/controller/catalog/ItemController.java
    }

    @GetMapping("brands/{brandId}")
    public String getBrandById(@PathVariable(value = "brandId") long brandId) {
        itemService.getBrandById(brandId);
<<<<<<< HEAD:src/main/java/org/perscholas/onlineshoppingapp/controller/catalog/ItemController.java
        return "index";
=======
        return "xx";
>>>>>>> b3276dd (applying security):onlineshoppingapp/src/main/java/org/perscholas/onlineshoppingapp/controller/catalog/ItemController.java
    }

    @GetMapping("types/{typeId}")
    public String getTypeById(@PathVariable(value = "typeId") long typeId) {
         itemService.getTypeById(typeId);
<<<<<<< HEAD:src/main/java/org/perscholas/onlineshoppingapp/controller/catalog/ItemController.java
         return "index";
=======
         return "xx";
>>>>>>> b3276dd (applying security):onlineshoppingapp/src/main/java/org/perscholas/onlineshoppingapp/controller/catalog/ItemController.java
    }

    @GetMapping()
    public String getAllItems(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {

         itemService.getAllItems(pageNo, pageSize, sortBy, sortDir);
<<<<<<< HEAD:src/main/java/org/perscholas/onlineshoppingapp/controller/catalog/ItemController.java
         return "index";
=======
         return "xx";
>>>>>>> b3276dd (applying security):onlineshoppingapp/src/main/java/org/perscholas/onlineshoppingapp/controller/catalog/ItemController.java
    }


}
<<<<<<< HEAD:src/main/java/org/perscholas/onlineshoppingapp/controller/catalog/ItemController.java
=======
//
>>>>>>> b3276dd (applying security):onlineshoppingapp/src/main/java/org/perscholas/onlineshoppingapp/controller/catalog/ItemController.java
