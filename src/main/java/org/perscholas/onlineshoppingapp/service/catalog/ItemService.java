package org.perscholas.onlineshoppingapp.service.catalog;

import org.perscholas.onlineshoppingapp.dto.cart.ItemsResponse;
import org.perscholas.onlineshoppingapp.dto.catalog.ItemDto;
import org.perscholas.onlineshoppingapp.models.catalog.Brand;
import org.perscholas.onlineshoppingapp.models.catalog.Type;

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
}
