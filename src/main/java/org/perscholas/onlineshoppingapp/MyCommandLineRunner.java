package org.perscholas.onlineshoppingapp;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.onlineshoppingapp.service.catalog.ImageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyCommandLineRunner implements CommandLineRunner  {

    ImageService imageService;

    public MyCommandLineRunner(ImageService imageService) {
        this.imageService = imageService;
    }

    @Override
    public void run(String... args) throws Exception {
        imageService.init();
    }
}
