package com.assignment.discount.interfaces;

import com.assignment.discount.pojo.OrderDetailTO;
import com.assignment.discount.pojo.UserType;
import java.math.BigDecimal;

public interface DiscountPolicy {
    default boolean supports(final UserType userType){
        return true;
    }
    public BigDecimal calculateDiscount(final OrderDetailTO orderDetailTO);



}
