package com.demo.BaristaBucks.Controller;

import com.demo.BaristaBucks.Dto.RequestDto.CoffeeRequestDto;
import com.demo.BaristaBucks.Dto.RequestDto.FeatureDto;
import com.demo.BaristaBucks.Dto.RequestDto.UserRequestDto;
import com.demo.BaristaBucks.Service.CoffeeService;
import com.demo.BaristaBucks.Util.ApiResponse;
import com.demo.BaristaBucks.Util.EndPoints;
import com.demo.BaristaBucks.Util.SuccessMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CoffeeController {

    private final CoffeeService coffeeService;

    @PostMapping(EndPoints.Coffee.ADD_UPDATE_COFFEE)
    public ResponseEntity<?> addUpdateCoffee(@Valid @RequestBody CoffeeRequestDto requestDto) {
        CoffeeRequestDto coffee = coffeeService.addUpdateCoffee(requestDto);
        return ApiResponse.sendCreatedResponse(SuccessMessages.Coffee.COFFEE_ADDED_SUCCESSFULLY, coffee);
    }

    @PostMapping(EndPoints.Coffee.FEATURE_UN_FEATURE_COFFEE)
    public ResponseEntity<?> featureCoffee(@Valid @RequestBody FeatureDto requestDto) {
        Boolean featured = coffeeService.featureCoffee(requestDto);
        if(featured){
            return ApiResponse.sendCreatedResponse(SuccessMessages.Coffee.COFFEE_FEATURED_SUCCESSFULLY, null);
        }else{
            return ApiResponse.sendCreatedResponse(SuccessMessages.Coffee.COFFEE_UN_FEATURED_SUCCESSFULLY, null);
        }
    }

//    @PostMapping(EndPoints.Coffee.ADD_UPDATE_COFFEE)
//    public ResponseEntity<?> getListOfCoffee() {
//        CoffeeRequestDto coffee = coffeeService.getListOfCoffee();
//        return ApiResponse.sendCreatedResponse(SuccessMessages.Coffee.COFFEE_ADDED_SUCCESSFULLY, coffee);
//    }

}
