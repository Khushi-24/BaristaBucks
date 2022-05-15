package com.demo.BaristaBucks.ServiceImpl;

import com.demo.BaristaBucks.Dto.RequestDto.CouponDto;
import com.demo.BaristaBucks.Entity.Coupons;
import com.demo.BaristaBucks.Exception.AlreadyExistsException;
import com.demo.BaristaBucks.Repository.CouponRepository;
import com.demo.BaristaBucks.Service.CouponService;
import com.demo.BaristaBucks.Util.ObjectMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;

    @Override
    public CouponDto addCoupon(CouponDto requestDto) {
        if(!couponRepository.existsByCouponName(requestDto.getCouponName())){
            Coupons coupons = ObjectMapperUtil.map(requestDto, Coupons.class);
            couponRepository.save(coupons);
            return ObjectMapperUtil.map(coupons, CouponDto.class);
        }else{
            throw new AlreadyExistsException(Coupons.class,requestDto.getCouponName());
        }
    }
}
