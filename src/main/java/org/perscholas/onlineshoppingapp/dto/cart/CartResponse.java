package org.perscholas.onlineshoppingapp.dto.cart;

<<<<<<< HEAD:src/main/java/org/perscholas/onlineshoppingapp/dto/cart/CartResponse.java
public class CartResponse {
=======
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
>>>>>>> b3276dd (applying security):onlineshoppingapp/src/main/java/org/perscholas/onlineshoppingapp/dto/cart/CartResponse.java
}
