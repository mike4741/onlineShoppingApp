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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
@Slf4j
public class ItemController {
    private ItemService itemService;
@Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @PostMapping("/addItem")
    public ResponseEntity<ItemDto> saveItem(@RequestBody  ItemDto itemDto  , @RequestParam Long typeId,  @RequestParam Long brandId){
        System.out.println("one");
        log.info(itemDto.toString());

        return new ResponseEntity<ItemDto>(itemService.saveItem(itemDto,typeId,brandId), HttpStatus.CREATED);
    }

    @PostMapping("/brand")
    public ResponseEntity<Brand> saveBrand (@RequestBody Brand brand){
        return new ResponseEntity<Brand>(itemService.saveBrand(brand), HttpStatus.CREATED);
    }

    @PostMapping("/type")
    public ResponseEntity<Type> saveType (@RequestBody Type type){
        return new ResponseEntity<Type>(itemService.saveType(type), HttpStatus.CREATED);
    }

    @GetMapping("/brands")
    public String getAllBrands() {

       itemService.getAllBrands();
      return  "index";
    }

    @GetMapping("/types")
    public String getAllTypes() {

      itemService.getAllTypes();
      log.info( itemService.getAllTypes().toString());
        return  "index";
    }

    @GetMapping("brands/{brandId}")
    public String getBrandById(@PathVariable(value = "brandId") long brandId) {
        itemService.getBrandById(brandId);
        return "index";
    }

    @GetMapping("types/{typeId}")
    public String getTypeById(@PathVariable(value = "typeId") long typeId) {
         itemService.getTypeById(typeId);
         return "index";
    }

    @GetMapping()
    public String getAllItems(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {

         itemService.getAllItems(pageNo, pageSize, sortBy, sortDir);
         return "index";
    }


}
