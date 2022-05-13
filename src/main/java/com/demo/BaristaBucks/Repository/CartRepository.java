package com.demo.BaristaBucks.Repository;

import com.demo.BaristaBucks.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByCoffeeIdAndUserId(Long coffeeId, Long userId);
}
