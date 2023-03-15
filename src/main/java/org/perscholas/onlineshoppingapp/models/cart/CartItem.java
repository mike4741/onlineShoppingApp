package org.perscholas.onlineshoppingapp.models.cart;

<<<<<<< HEAD:src/main/java/org/perscholas/onlineshoppingapp/models/cart/CartItem.java
public class CartItem {
=======
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id ;
    int itemId;
    String userId;


    public CartItem(int itemId, String userID) {
        this.itemId =itemId;
        this.userId =userID;
    }
>>>>>>> b3276dd (applying security):onlineshoppingapp/src/main/java/org/perscholas/onlineshoppingapp/models/cart/CartItem.java
}
