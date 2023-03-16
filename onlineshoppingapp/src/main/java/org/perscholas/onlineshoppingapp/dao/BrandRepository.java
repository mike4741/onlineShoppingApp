package org.perscholas.onlineshoppingapp.dao;

import org.perscholas.onlineshoppingapp.models.catalog.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    Brand findByBrandName(String brandName);
}