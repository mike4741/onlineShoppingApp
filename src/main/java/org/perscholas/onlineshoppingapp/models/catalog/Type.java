package org.perscholas.onlineshoppingapp.models.catalog;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NonNull
<<<<<<< HEAD:src/main/java/org/perscholas/onlineshoppingapp/models/catalog/Type.java
    String type;
=======
    String typeName;
>>>>>>> b3276dd (applying security):onlineshoppingapp/src/main/java/org/perscholas/onlineshoppingapp/models/catalog/Type.java


    @OneToMany(mappedBy = "type", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private Set<Item> items = new LinkedHashSet<>();

<<<<<<< HEAD:src/main/java/org/perscholas/onlineshoppingapp/models/catalog/Type.java
=======
    public Type(int i, String type) {
    }
>>>>>>> b3276dd (applying security):onlineshoppingapp/src/main/java/org/perscholas/onlineshoppingapp/models/catalog/Type.java
}