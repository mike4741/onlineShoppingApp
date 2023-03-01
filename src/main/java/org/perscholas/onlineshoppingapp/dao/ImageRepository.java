package org.perscholas.onlineshoppingapp.dao;

import org.perscholas.onlineshoppingapp.models.catalog.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository  extends JpaRepository<Image , Integer> {
}
