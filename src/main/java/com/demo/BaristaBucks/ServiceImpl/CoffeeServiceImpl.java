package com.demo.BaristaBucks.ServiceImpl;

import com.demo.BaristaBucks.Dto.RequestDto.CoffeeRequestDto;
import com.demo.BaristaBucks.Dto.RequestDto.FeatureDto;
import com.demo.BaristaBucks.Entity.Coffee;
import com.demo.BaristaBucks.Exception.AlreadyExistsException;
import com.demo.BaristaBucks.Exception.EntityNotFoundException;
import com.demo.BaristaBucks.Repository.CoffeeRepository;
import com.demo.BaristaBucks.Service.CoffeeService;
import com.demo.BaristaBucks.Util.ObjectMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository coffeeRepository;


    @Override
    public CoffeeRequestDto addUpdateCoffee(CoffeeRequestDto requestDto) {
        Coffee coffee = coffeeRepository.findByNameAndSize(requestDto.getName(), requestDto.getSize());
        if(coffee != null){
            if(requestDto.getId() != null){
                coffee = coffeeRepository.findById(requestDto.getId()).orElseThrow(() -> new EntityNotFoundException(Coffee.class, requestDto.getId()));
                if(coffee.getId().equals(requestDto.getId())){
                    Date createdDate = coffee.getCreatedTimeStamp();
                    Date updatedDate = coffee.getUpdatedTimeStamp();
                    coffee = ObjectMapperUtil.map(requestDto, Coffee.class);
                    coffee.setCreatedTimeStamp(createdDate);
                    coffee.setUpdatedTimeStamp(updatedDate);
                    coffeeRepository.save(coffee);
                    return requestDto;
                }else {
                    throw new AlreadyExistsException(Coffee.class, requestDto.getName());
                }
            } else {
                throw new AlreadyExistsException(Coffee.class, requestDto.getName());
            }
        }else {
            if(requestDto.getId() != null){
                assert false;
                Date createdDate = coffee.getCreatedTimeStamp();
                Date updatedDate = coffee.getUpdatedTimeStamp();
                coffee = coffeeRepository.findById(requestDto.getId()).orElseThrow(() -> new EntityNotFoundException(Coffee.class, requestDto.getId()));
                coffee.setCreatedTimeStamp(createdDate);
                coffee.setUpdatedTimeStamp(updatedDate);
                coffeeRepository.save(coffee);
            }else{
                coffee = ObjectMapperUtil.map(requestDto, Coffee.class);
                coffeeRepository.save(coffee);
                requestDto.setId(coffee.getId());
            }
            return requestDto;
        }

    }

    @Override
    public Boolean featureCoffee(FeatureDto requestDto) {
        Coffee coffee = coffeeRepository.findById(requestDto.getId()).orElseThrow(() -> new EntityNotFoundException(Coffee.class, requestDto.getId()));
        coffee.setIs_featured(requestDto.getIs_featured());
        coffeeRepository.save(coffee);
        return requestDto.getIs_featured();
    }
}
