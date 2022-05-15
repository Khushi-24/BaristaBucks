package com.demo.BaristaBucks.Util;

public class EndPoints {

    public interface User {
        String USER = "/user";
        String ADD_USER = USER + "/addUser";
        String LOGOUT = USER + "/logout";
        String LOGIN = USER + "/login";
        String REFRESH_TOKEN = USER + "/refreshToken";
    }

    public interface Role{
        String ROLE = "/role";
        String ADD_ROLE = ROLE + "/addRole";
    }

    public interface Coffee{
        String COFFEE = "/coffee";
        String ADD_UPDATE_COFFEE = COFFEE + "/addUpdateCoffee";
        String FEATURE_UN_FEATURE_COFFEE = COFFEE + "/featureUnFeatureCoffee";
    }

    public interface Cart{
        String CART = "/cart";
        String ADD_TO_CART = CART + "/addToCart";
        String ADD_OR_REMOVE_FROM_CART = CART + "/addOrRemoveFromCart";
    }

    public interface Coupon{
        String COUPON = "/coupon";
        String ADD_COUPON = COUPON + "/addCoupon";
        String APPLY_COUPON = COUPON + "/applyCoupon";

    }
}
