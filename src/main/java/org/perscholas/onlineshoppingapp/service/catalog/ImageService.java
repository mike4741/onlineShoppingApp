package org.perscholas.onlineshoppingapp.service.catalog;

import org.perscholas.onlineshoppingapp.dto.catalog.ItemDto2;
import org.perscholas.onlineshoppingapp.models.catalog.Image;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {


    void init() throws Exception;

    Image save(MultipartFile file, String name) throws Exception;

    Resource load(String filename);



}
