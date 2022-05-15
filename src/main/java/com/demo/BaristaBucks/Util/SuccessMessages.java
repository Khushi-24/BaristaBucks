package com.demo.BaristaBucks.Util;

public interface SuccessMessages {

    interface User {
        String USER_ADDED_SUCCESSFULLY = "User Added Successfully";
        String USER_LOGGED_IN = "User logged in successfully";
        String LOGOUT_SUCCESS = "You logged out successfully.";

    }

    interface Coffee{
        String COFFEE_ADDED_SUCCESSFULLY = "Coffee Added Successfully";
        String COFFEE_FEATURED_SUCCESSFULLY = "Coffee featured Successfully";
        String COFFEE_UN_FEATURED_SUCCESSFULLY = "Coffee unfeatured Successfully";
    }

    interface Cart{
        String ITEM_ADDED_SUCCESSFULLY = "Item Added Successfully";
    }

    interface Coupons {
        String COUPON_ADDED_SUCCESSFULLY = "coupon Added Successfully";
    }
}
