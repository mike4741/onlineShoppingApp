package org.perscholas.onlineshoppingapp.service.catalog.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.perscholas.onlineshoppingapp.dao.BrandRepository;
import org.perscholas.onlineshoppingapp.dao.ImageRepository;
import org.perscholas.onlineshoppingapp.dao.ItemRepository;
import org.perscholas.onlineshoppingapp.dao.TypeRepository;
import org.perscholas.onlineshoppingapp.dto.cart.ItemsResponse;
import org.perscholas.onlineshoppingapp.dto.catalog.ItemDto;
import org.perscholas.onlineshoppingapp.exception.ResourceNotFoundException;
import org.perscholas.onlineshoppingapp.models.catalog.Brand;
import org.perscholas.onlineshoppingapp.models.catalog.Item;
import org.perscholas.onlineshoppingapp.service.catalog.ItemService;
import org.perscholas.onlineshoppingapp.models.catalog.Type;
//import org.modelmapper.ModelMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper, BrandRepository brandRepository, TypeRepository typeRepository, ImageRepository imageRepository) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.brandRepository = brandRepository;
        this.typeRepository = typeRepository;
        this.imageRepository = imageRepository;
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
        Brand oldBrand = brandRepository.findByBrand(brand.getBrand());

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
        Type oldType = typeRepository.findByType(type.getType());

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

        ItemsResponse itemsResponse = new ItemsResponse();

        itemsResponse.setItemDtos(listOfItems);
        itemsResponse.setPageNo(pageItems.getNumber());
        itemsResponse.setTotalElements(pageItems.getTotalElements());
        itemsResponse.setTotalPages(pageItems.getTotalPages());
        itemsResponse.setPageSize(pageItems.getSize());
        itemsResponse.setLast(pageItems.isLast());

        return itemsResponse;
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
