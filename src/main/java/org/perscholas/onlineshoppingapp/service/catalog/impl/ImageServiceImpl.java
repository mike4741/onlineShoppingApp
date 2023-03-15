package org.perscholas.onlineshoppingapp.service.catalog.impl;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.onlineshoppingapp.controller.catalog.ImageController;
import org.perscholas.onlineshoppingapp.dao.ImageRepository;
import org.perscholas.onlineshoppingapp.models.catalog.Image;
import org.perscholas.onlineshoppingapp.service.catalog.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {
        private final Path root = Paths.get("./uploads");
     private  final ImageRepository imageRepository;
    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public void init() throws Exception {
            try {
                if(Files.exists(root)){
                    log.debug("Folder Exists!");
                }else {
                    Files.createDirectories(root);
                    log.debug("Folder Created!");
                }
            } catch (IOException e) {
                throw new Exception("Could not initialize folder for upload!");
            }
        }


        public Image save(MultipartFile file,String itemName) throws Exception {
            try {

                String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

                String imageName = itemName.concat("-").concat(String.valueOf(LocalDate.now().getYear())).concat(ext);

                Files.copy(file.getInputStream(), this.root.resolve(imageName));
                Path p = root.resolve(imageName);
                String url = MvcUriComponentsBuilder .fromMethodName(ImageController.class, "getImage", p.getFileName().toString()).build().toString();
//                log.debug(url);

                  return imageRepository.save(new Image(imageName,url));
            } catch (Exception e) {
                if (e instanceof FileAlreadyExistsException) {
                    throw new Exception("A file of that name already exists.");
                } else {
                    throw new Exception("Error copying file to HD" + file.getOriginalFilename());
                }

            }


        }


        public Resource load(String filename) {
            try {
                Path file = root.resolve(filename);
                Resource resource = new UrlResource(file.toUri());

                if (resource.exists() || resource.isReadable()) {
                    return resource;
                } else {
                    throw new RuntimeException("Could not read the file!");
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException("Error: " + e.getMessage());
            }
        }




}
