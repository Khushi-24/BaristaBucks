package com.demo.BaristaBucks.ServiceImpl;

import com.demo.BaristaBucks.Dto.RequestDto.CartRequestDto;
import com.demo.BaristaBucks.Entity.Cart;
import com.demo.BaristaBucks.Entity.Coffee;
import com.demo.BaristaBucks.Entity.User;
import com.demo.BaristaBucks.Exception.EntityNotFoundException;
import com.demo.BaristaBucks.Repository.CartRepository;
import com.demo.BaristaBucks.Repository.CoffeeRepository;
import com.demo.BaristaBucks.Repository.UserRepository;
import com.demo.BaristaBucks.Service.CartService;
import com.demo.BaristaBucks.Util.ObjectMapperUtil;
import com.demo.BaristaBucks.Util.SuccessMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    private final CoffeeRepository coffeeRepository;

    private final UserRepository userRepository;

    @Override
    public CartRequestDto addItemToCart(CartRequestDto requestDto) {
        Coffee coffee = coffeeRepository.findById(requestDto.getCoffeeId()).orElseThrow(() -> new EntityNotFoundException(Cart.class, requestDto.getCoffeeId()));
        User user = userRepository.findById(requestDto.getUserId()).orElseThrow(() -> new EntityNotFoundException(User.class, requestDto.getUserId()));
        Cart cart = cartRepository.findByCoffeeIdAndUserId(requestDto.getCoffeeId(), requestDto.getUserId());
        if(cart != null){
            cart.setQuantity(cart.getQuantity() + requestDto.getQuantity());
            cart.setTotalPrice(coffee.getPrice() * cart.getQuantity());
        }else{
            ObjectMapperUtil.map(requestDto, cart);
            cartRepository.save(cart);
            requestDto.setCartId(cart.getId());
        }
        return requestDto;
    }
}
