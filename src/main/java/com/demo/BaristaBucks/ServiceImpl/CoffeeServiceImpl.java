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

@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository coffeeRepository;


    @Override
    public CoffeeRequestDto addUpdateCoffee(CoffeeRequestDto requestDto) {
        Coffee coffee;
        Coffee oldCoffee = coffeeRepository.findByName(requestDto.getName());
        if(requestDto.getId() != null){
            coffee = coffeeRepository.findById(requestDto.getId()).orElseThrow(() -> new EntityNotFoundException(Coffee.class, requestDto.getId()));
            if(coffee != null && oldCoffee != null && oldCoffee.getSize().equals(coffee.getSize())){
                throw new AlreadyExistsException(Coffee.class, requestDto.getName());
            }
            assert coffee != null;
            Long id = coffee.getId();
            ObjectMapperUtil.map(requestDto, coffee);
            coffee.setId(id);
            coffeeRepository.save(coffee);
        }else {
            coffee = new Coffee();
            if(oldCoffee != null && oldCoffee.getSize().equals(requestDto.getSize())){
                throw new AlreadyExistsException(Coffee.class, requestDto.getName());
            }
            ObjectMapperUtil.map(requestDto, coffee);
            coffeeRepository.save(coffee);
            requestDto.setId(coffee.getId());
        }
        return requestDto;
    }

    @Override
    public Boolean featureCoffee(FeatureDto requestDto) {
        Coffee coffee = coffeeRepository.findById(requestDto.getId()).orElseThrow(() -> new EntityNotFoundException(Coffee.class, requestDto.getId()));
        coffee.setIs_featured(requestDto.getIs_featured());
        coffeeRepository.save(coffee);
        return requestDto.getIs_featured();
    }
}
