package com.demo.BaristaBucks.Controller;

import com.demo.BaristaBucks.Dto.RequestDto.CoffeeRequestDto;
import com.demo.BaristaBucks.Dto.RequestDto.CouponDto;
import com.demo.BaristaBucks.Service.CouponService;
import com.demo.BaristaBucks.Util.ApiResponse;
import com.demo.BaristaBucks.Util.EndPoints;
import com.demo.BaristaBucks.Util.SuccessMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @PostMapping(EndPoints.Coupon.ADD_COUPON)
    public ResponseEntity<?> addCoupon(@Valid @RequestBody CouponDto requestDto) {
        CouponDto coupon = couponService.addCoupon(requestDto);
        return ApiResponse.sendCreatedResponse(SuccessMessages.Coupons.COUPON_ADDED_SUCCESSFULLY, coupon);
    }
}
