package org.perscholas.onlineshoppingapp.service.catalog;

import org.perscholas.onlineshoppingapp.dto.cart.ItemsResponse;
import org.perscholas.onlineshoppingapp.dto.catalog.ItemDto;
<<<<<<< HEAD:src/main/java/org/perscholas/onlineshoppingapp/service/catalog/ItemService.java
import org.perscholas.onlineshoppingapp.models.catalog.Brand;
import org.perscholas.onlineshoppingapp.models.catalog.Type;
=======
import org.perscholas.onlineshoppingapp.dto.catalog.ItemDto2;
import org.perscholas.onlineshoppingapp.models.catalog.Brand;
import org.perscholas.onlineshoppingapp.models.catalog.Type;
import org.springframework.web.multipart.MultipartFile;
>>>>>>> b3276dd (applying security):onlineshoppingapp/src/main/java/org/perscholas/onlineshoppingapp/service/catalog/ItemService.java

import java.util.List;
import java.util.Optional;

public interface ItemService {
     ItemDto saveItem(ItemDto itemDto, Long typeId, Long brandId);
     Brand saveBrand(Brand brand);
     List<Brand> getAllBrands();
     Optional<Brand> getBrandById(long brandId);
     Type saveType(Type type);
     List<Type> getAllTypes();
     Optional<Type> getTypeById(long typeId);

     ItemsResponse getAllItems(int pageNo, int pageSize, String sortBy, String sortDir);
<<<<<<< HEAD:src/main/java/org/perscholas/onlineshoppingapp/service/catalog/ItemService.java
=======


     ItemDto saveItem(MultipartFile image, ItemDto2 itemDto2) throws Exception;
>>>>>>> b3276dd (applying security):onlineshoppingapp/src/main/java/org/perscholas/onlineshoppingapp/service/catalog/ItemService.java
}
