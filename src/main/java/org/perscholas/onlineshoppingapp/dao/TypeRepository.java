package org.perscholas.onlineshoppingapp.dao;

import org.perscholas.onlineshoppingapp.dto.catalog.TypeDto;
import org.perscholas.onlineshoppingapp.models.catalog.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type,Long> {
    TypeDto findAllById(long typeId);

<<<<<<< HEAD:src/main/java/org/perscholas/onlineshoppingapp/dao/TypeRepository.java
    Type findByType(String type);
=======
    Type findByTypeName(String type);
>>>>>>> b3276dd (applying security):onlineshoppingapp/src/main/java/org/perscholas/onlineshoppingapp/dao/TypeRepository.java
}