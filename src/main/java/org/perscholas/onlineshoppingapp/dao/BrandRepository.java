package org.perscholas.onlineshoppingapp.dao;

import org.perscholas.onlineshoppingapp.models.catalog.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
<<<<<<< HEAD:src/main/java/org/perscholas/onlineshoppingapp/dao/BrandRepository.java
    Brand findByBrand(String brand);
=======
    Brand findByBrandName(String brandName);
>>>>>>> b3276dd (applying security):onlineshoppingapp/src/main/java/org/perscholas/onlineshoppingapp/dao/BrandRepository.java
}