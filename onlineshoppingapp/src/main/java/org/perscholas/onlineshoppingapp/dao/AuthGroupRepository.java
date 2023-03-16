package org.perscholas.onlineshoppingapp.dao;

import org.perscholas.onlineshoppingapp.models.User.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthGroupRepository extends JpaRepository<AuthGroup , Integer> {
    List<AuthGroup> findByEmail(String email);
}
