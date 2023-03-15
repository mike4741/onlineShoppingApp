package org.perscholas.onlineshoppingapp.dto.catalog;

import lombok.Data;
import org.perscholas.onlineshoppingapp.models.catalog.Brand;
import org.perscholas.onlineshoppingapp.models.catalog.Type;

import javax.validation.constraints.NotEmpty;

@Data
public class ItemDto2 {
    int id;
    @NotEmpty (message = "name should not be empty ")
    String name;
    String description;
    @NotEmpty (message = "price should not be empty ")
    float price;
    @NotEmpty (message = "pictureURL should not be empty ")

//    private Image image;

    @NotEmpty (message = "brand  should not be empty ")
    private Brand brand;

    @NotEmpty (message = "type should not be empty ")
    private Type type;
}
