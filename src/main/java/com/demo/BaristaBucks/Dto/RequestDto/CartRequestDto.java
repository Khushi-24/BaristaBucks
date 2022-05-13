package com.demo.BaristaBucks.Dto.RequestDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequestDto {

    private Long cartId;

    private Long coffeeId;

    private Long userId;

    private Integer quantity;

    private Long orderId;

    private Double totalPrice;

}
