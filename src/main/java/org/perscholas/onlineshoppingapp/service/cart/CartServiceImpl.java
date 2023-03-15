package org.perscholas.onlineshoppingapp.service.cart;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.perscholas.onlineshoppingapp.dao.CartRepository;
import org.perscholas.onlineshoppingapp.dao.ItemRepository;
import org.perscholas.onlineshoppingapp.dto.cart.CartResponse;
import org.perscholas.onlineshoppingapp.dto.catalog.ItemDto;
import org.perscholas.onlineshoppingapp.models.cart.CartItem;
import org.perscholas.onlineshoppingapp.models.catalog.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CartServiceImpl implements  CartService{
    private CartRepository cartRepository;
    private ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    public CartServiceImpl(CartRepository cartRepository, ModelMapper modelMapper  ,ItemRepository itemRepository) {
        this.cartRepository = cartRepository;
        this.modelMapper = modelMapper;
        this.itemRepository =itemRepository;
    }

    @Override
    public void addToCart(int itemId) {
        log.info(itemId+"data from front end ");
        int quantity =1;
        String userID = "abc@gmail.com";
        CartItem newcartItem = cartRepository.save(new CartItem(itemId, userID));

    }

    @Override
    public CartResponse getCartByUserId(String userId) {

        List<CartItem>  cartItems = cartRepository.findByUserId(userId);
        List<Item>  inCartList = new ArrayList<>();
        for (CartItem x:cartItems) {
            Item data = itemRepository.findById((long) x.getItemId()).get();
            inCartList.add(data);

        }

        List<ItemDto> listOfItems = inCartList.stream().map(this::mapToDTO).collect(Collectors.toList());
        log.info("FINAL OUT3333"+listOfItems.toString());
        CartResponse xxx = new CartResponse();
        xxx.setItemDto( listOfItems);
        xxx.setUserId(userId);
        log.info("FINAL OUT2"+xxx.toString());

        return xxx;
    }
    private ItemDto mapToDTO(Item item) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ItemDto itemDto = modelMapper.map(item, ItemDto.class);
        return itemDto;
    }

    private CartResponse mapToDTO2(CartItem cartItem) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        CartResponse cartResponse = modelMapper.map(cartItem, CartResponse.class);
        return cartResponse;
    }
}