package org.perscholas.onlineshoppingapp.dao;

import org.perscholas.onlineshoppingapp.dto.catalog.TypeDto;
import org.perscholas.onlineshoppingapp.models.catalog.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type,Long> {
    TypeDto findAllById(long typeId);

    Type findByType(String type);
}