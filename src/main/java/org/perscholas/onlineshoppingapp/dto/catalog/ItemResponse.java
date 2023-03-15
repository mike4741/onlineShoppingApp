package org.perscholas.onlineshoppingapp.dto.catalog;

<<<<<<< HEAD:src/main/java/org/perscholas/onlineshoppingapp/dto/catalog/ItemResponse.java
public class ItemResponse {
=======
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemResponse {
    List<ItemDto> itemDto;
    int pageNo;
    int pageSize;
    long totalElements;
    int totalPages;
    boolean last;
>>>>>>> b3276dd (applying security):onlineshoppingapp/src/main/java/org/perscholas/onlineshoppingapp/dto/catalog/ItemResponse.java
}
