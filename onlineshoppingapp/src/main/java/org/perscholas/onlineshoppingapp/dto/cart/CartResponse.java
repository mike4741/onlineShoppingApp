package org.perscholas.onlineshoppingapp.dto.cart;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.perscholas.onlineshoppingapp.dto.catalog.ItemDto;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartResponse {

    List<ItemDto> itemDto ;
    String userId;
}
