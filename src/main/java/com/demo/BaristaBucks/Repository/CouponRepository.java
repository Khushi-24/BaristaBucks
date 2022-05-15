package com.demo.BaristaBucks.Repository;

import com.demo.BaristaBucks.Entity.Coffee;
import com.demo.BaristaBucks.Entity.Coupons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupons, Long> {
    boolean existsByCouponName(String couponName);
}
