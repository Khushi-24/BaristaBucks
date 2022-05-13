package com.demo.BaristaBucks.Dto.ResponseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoffeeListResponseDto {

    private Long id;
    private String name;
    private String price;
    private String description;
    private String image;
    private String size;
    private Boolean is_featured;
    private String rating;
    private Long no_of_times_ordered;
}
