package org.perscholas.onlineshoppingapp;

import lombok.extern.slf4j.Slf4j;


import org.perscholas.onlineshoppingapp.dao.AuthGroupRepository;
import org.perscholas.onlineshoppingapp.dto.catalog.ItemDto;
import org.perscholas.onlineshoppingapp.models.User.AuthGroup;
import org.perscholas.onlineshoppingapp.models.User.MyUser;
import org.perscholas.onlineshoppingapp.models.catalog.Brand;
import org.perscholas.onlineshoppingapp.models.catalog.Type;
import org.perscholas.onlineshoppingapp.service.catalog.ImageService;
import org.perscholas.onlineshoppingapp.service.catalog.ItemService;
import org.perscholas.onlineshoppingapp.service.user.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyCommandLineRunner implements CommandLineRunner  {

    ImageService imageService;
    MyUserService myUserService;
    ItemService itemService;
    AuthGroupRepository authGroupRepoI;

    public MyCommandLineRunner(ImageService imageService, MyUserService myUserService, ItemService itemService, AuthGroupRepository authGroupRepoI) {
        this.imageService = imageService;
        this.myUserService = myUserService;
        this.itemService = itemService;
        this.authGroupRepoI = authGroupRepoI;
    }

    @Override
    public void run(String... args) throws Exception {
        imageService.init();
         itemService.saveType(new Type("Electronics"));
         itemService.saveType(new Type("Home & Kitchen"));
         itemService.saveType(new Type("Beauty & Personal Care"));
         itemService.saveType(new Type("Toys & Games"));
         itemService.saveType(new Type("Sports & Outdoors"));
        itemService.saveType(new Type("Toys & Games"));


         itemService.saveBrand(new Brand("Samsung"));
         itemService.saveBrand(new Brand("Apple"));
         itemService.saveBrand(new Brand("HP"));
         itemService.saveBrand(new Brand("Lenovo"));



        myUserService.createOrUpdate(new MyUser("mike", "mike@gmail.com", "123"));
        myUserService.createOrUpdate(new MyUser("Mok", "mok@gmail.com", "123"));


        authGroupRepoI.save(new AuthGroup("mike@gmail.com", "ROLE_ADMIN"));
        authGroupRepoI.save(new AuthGroup("mike@gmail.com", "ROLE_USER"));
        authGroupRepoI.save(new AuthGroup("mok@gmail.com", "ROLE_USER"));


    }

}
