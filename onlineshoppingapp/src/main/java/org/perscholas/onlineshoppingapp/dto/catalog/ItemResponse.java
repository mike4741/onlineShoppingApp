package org.perscholas.onlineshoppingapp.dto.catalog;

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
}
