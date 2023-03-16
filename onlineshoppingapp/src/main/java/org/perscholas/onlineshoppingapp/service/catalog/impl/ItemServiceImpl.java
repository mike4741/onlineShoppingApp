package org.perscholas.onlineshoppingapp.service.catalog.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.perscholas.onlineshoppingapp.dao.BrandRepository;
import org.perscholas.onlineshoppingapp.dao.ImageRepository;
import org.perscholas.onlineshoppingapp.dao.ItemRepository;
import org.perscholas.onlineshoppingapp.dao.TypeRepository;
import org.perscholas.onlineshoppingapp.dto.cart.ItemsResponse;
import org.perscholas.onlineshoppingapp.dto.catalog.ItemDto;
import org.perscholas.onlineshoppingapp.dto.catalog.ItemDto2;
import org.perscholas.onlineshoppingapp.exception.ResourceNotFoundException;
import org.perscholas.onlineshoppingapp.models.catalog.Brand;
import org.perscholas.onlineshoppingapp.models.catalog.Image;
import org.perscholas.onlineshoppingapp.models.catalog.Item;
import org.perscholas.onlineshoppingapp.service.catalog.ImageService;
import org.perscholas.onlineshoppingapp.service.catalog.ItemService;
import org.perscholas.onlineshoppingapp.models.catalog.Type;
//import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final BrandRepository brandRepository;
    private final TypeRepository typeRepository;
    private final ImageRepository imageRepository;
    private  final ImageService imageService;
    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper, BrandRepository brandRepository, TypeRepository typeRepository, ImageRepository imageRepository, ImageService imageService) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.brandRepository = brandRepository;
        this.typeRepository = typeRepository;
        this.imageRepository = imageRepository;
        this.imageService = imageService;
    }



    @Override
    public ItemDto saveItem(ItemDto itemDto, Long typeId, Long brandId) {

        Optional<Brand> brand = brandRepository.findById(brandId);

        Optional<Type> type = typeRepository.findById(typeId);

        if (brand.isPresent() && type.isPresent()) {
            Item item = MapToEntity(itemDto);
            item.setType(type.get());
            item.setBrand(brand.get());
            Item newItem = itemRepository.save(item);
            return mapToDTO(newItem);
        } else {
            throw new ResourceNotFoundException("type", "id", typeId);
        }



    }

    @Override
    public Brand saveBrand(Brand brand) {
        Brand oldBrand = brandRepository.findByBrandName(brand.getBrandName());

         if(oldBrand == null ){
             return brandRepository.saveAndFlush(brand);
         }

        return  oldBrand;

    }


    @Override
    public List<Brand> getAllBrands() {
        return  brandRepository.findAll();
    }

    @Override
    public Optional<Brand>getBrandById(long brandId) {
        Optional<Brand> brand = brandRepository.findById(brandId);
        if(brand.isPresent()){
            return brand;
        } else {
            throw new ResourceNotFoundException("brand", "id", brandId);
        }
    }

    @Override
    public Type saveType(Type type) {
        Type oldType = typeRepository.findByTypeName(type.getTypeName());

        if(oldType == null ){
            return typeRepository.saveAndFlush(type);
        }

        return  oldType;
    }


    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public Optional<Type> getTypeById(long typeId) {
        Optional<Type> type = typeRepository.findById(typeId);
        if(type.isPresent()){
            return type;
        } else {
            throw new ResourceNotFoundException("type", "id", typeId);
        }
    }

    @Override
    public ItemsResponse getAllItems(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        PageRequest pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Item> pageItems = itemRepository.findAll(pageable);
        List<Item> items = pageItems.getContent();


        List<ItemDto> listOfItems = items.stream().map(this::mapToDTO).collect(Collectors.toList());
        for ( ItemDto x:listOfItems) {
//            x.setImage((Image) imageService.load(x.getName()));

        }
        ItemsResponse itemsResponse = new ItemsResponse();

        itemsResponse.setItemDtos(listOfItems);
        itemsResponse.setPageNo(pageItems.getNumber());
        itemsResponse.setTotalElements(pageItems.getTotalElements());
        itemsResponse.setTotalPages(pageItems.getTotalPages());
        itemsResponse.setPageSize(pageItems.getSize());
        itemsResponse.setLast(pageItems.isLast());

        return itemsResponse;
    }

    @Override
    public ItemDto saveItem(MultipartFile image, ItemDto2 itemDto2) throws Exception {
        Image savedImage = imageService.save(image, itemDto2.getName() );
        ItemDto newItemDto =  new ItemDto();
            newItemDto.setImage(savedImage);
            newItemDto.setType(itemDto2.getType());
            newItemDto.setBrand(itemDto2.getBrand());
            newItemDto.setPrice(itemDto2.getPrice());
            newItemDto.setDescription(itemDto2.getDescription());
            newItemDto.setName(itemDto2.getName());
 System.out.println("add new item "+newItemDto);
        newItemDto = mapToDTO( itemRepository.save(MapToEntity(newItemDto)));
        return  newItemDto;
    }

    @Override
    public Image saveImageforTest(String s, String s1) {
        Image image = new Image();
        image.setName(s);
        image.setUrl(s1);
      return   imageRepository.save(image);

    }

    @Override
    public void saveItem2(String samsungPhone, String phone, double v, int i, int i1, int i2) {
            Item item = new Item();
            Brand brand = brandRepository.findById((long)i).get();
            Image image = imageRepository.findById(i1).get();
            Type type = typeRepository.findById((long)i2).get();
            item.setDescription(samsungPhone);
            item.setName(phone);
            item.setPrice((float) v);
            item.setBrand(brand);
            item.setImage(image);
            item.setType(type);

            itemRepository.save(item);
    }


    private Item MapToEntity(ItemDto itemDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Item item = modelMapper.map(itemDto, Item.class);
        return item;
    }

    private ItemDto mapToDTO(Item item) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ItemDto itemDto = modelMapper.map(item, ItemDto.class);
        return itemDto;
    }

}
