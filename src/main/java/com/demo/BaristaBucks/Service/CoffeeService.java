package com.demo.BaristaBucks.Service;

import com.demo.BaristaBucks.Dto.RequestDto.CoffeeRequestDto;
import com.demo.BaristaBucks.Dto.RequestDto.FeatureDto;

public interface CoffeeService {
    CoffeeRequestDto addUpdateCoffee(CoffeeRequestDto requestDto);

    Boolean featureCoffee(FeatureDto requestDto);
}
