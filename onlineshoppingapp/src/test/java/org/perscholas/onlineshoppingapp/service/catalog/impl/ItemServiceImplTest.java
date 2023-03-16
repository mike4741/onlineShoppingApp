package org.perscholas.onlineshoppingapp.service.catalog.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.perscholas.onlineshoppingapp.dao.BrandRepository;
import org.perscholas.onlineshoppingapp.dao.TypeRepository;
import org.perscholas.onlineshoppingapp.models.catalog.Brand;
import org.perscholas.onlineshoppingapp.models.catalog.Type;
import org.perscholas.onlineshoppingapp.service.catalog.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceImplTest {

    ItemService itemService;
    BrandRepository brandRepository;
    TypeRepository typeRepository;
@Autowired
    public ItemServiceImplTest(ItemService itemService, BrandRepository brandRepository, TypeRepository typeRepository) {
        this.itemService = itemService;
        this.brandRepository = brandRepository;
        this.typeRepository = typeRepository;
    }




    static List<Brand> expected2() {
        Brand brand= new Brand("Samsung");
        Brand brand2= new  Brand("Apple");
        Brand brand3= new  Brand("HP");
        Brand brand4= new  Brand("Lenovo");

        List<Brand> expected2 = new ArrayList<>();
        expected2.add(brand);
        expected2.add(brand2);
        expected2.add(brand3);
        expected2.add(brand4);;
        return  expected2;
    }



    static List<Type> expected() {
         Type type1= new Type("Electronics");
         Type type2= new Type("Home & Kitchen");
         Type type3= new Type("Beauty & Personal Care");
         Type type4= new Type("Toys & Games");
         Type type5= new Type("Sports & Outdoors");
         Type type6= new  Type("Toys & Games");

    List<Type> expected = new ArrayList<>();
        expected.add(type1);
        expected.add(type2);
        expected.add(type3);
        expected.add(type4);
        expected.add(type5);
        expected.add(type6);

    return expected;
}



    @Test
    void getTypeById() {

    long id = 2 ;
    Type type = itemService.getTypeById(id).get();

        Assertions.assertThat(type.getTypeName().equals("Home & Kitchen"));


    }

    @Test

    void getAllTypes() {
    Assertions.assertThat((long) typeRepository.findAll().size()).isEqualTo(expected().size()-1);

    }

    @Test

    void getAllBrands() {
        Assertions.assertThat((long) brandRepository.findAll().size()).isEqualTo(expected2().size());

    }

    @Test
    void getBrandById() {

        long id = 2 ;
        Brand brand = itemService.getBrandById(id).get();

        Assertions.assertThat(brand.getBrandName().equals("Apple"));


    }
}