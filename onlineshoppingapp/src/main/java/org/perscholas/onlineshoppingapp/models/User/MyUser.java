package org.perscholas.onlineshoppingapp.models.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @NonNull
    String name;
    @NonNull
    String email;
    @Setter(AccessLevel.NONE)
    String  password;

    public MyUser(@NonNull String name, @NonNull String email, String password) {
        this.name = name;
        this.email = email;
        this.password = setPassword(password);
    }

    public String setPassword(String password) {

        return this.password = new BCryptPasswordEncoder().encode(password);
    }
}
