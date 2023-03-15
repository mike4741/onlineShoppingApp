package org.perscholas.onlineshoppingapp.models.catalog;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @NonNull
    String name;
    String description;
    @NonNull
    float price;
<<<<<<< HEAD:src/main/java/org/perscholas/onlineshoppingapp/models/catalog/Item.java
    @NonNull
    String pictureURL;


    @ToString.Exclude
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
=======



    @ToString.Exclude
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true,fetch = FetchType.EAGER)
>>>>>>> b3276dd (applying security):onlineshoppingapp/src/main/java/org/perscholas/onlineshoppingapp/models/catalog/Item.java
    @JoinColumn(name = "image_id")
    private Image image;


    @ToString.Exclude
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "brand_id")
    private Brand brand;


    @ToString.Exclude
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "type_id")
    private Type type;

<<<<<<< HEAD:src/main/java/org/perscholas/onlineshoppingapp/models/catalog/Item.java
=======

>>>>>>> b3276dd (applying security):onlineshoppingapp/src/main/java/org/perscholas/onlineshoppingapp/models/catalog/Item.java
}
