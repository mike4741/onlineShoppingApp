package org.perscholas.onlineshoppingapp.dao;

import org.perscholas.onlineshoppingapp.models.User.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MyUserRepository extends JpaRepository< MyUser , Long> {
    Optional<MyUser> findByEmailAllIgnoreCase(String email);

}
