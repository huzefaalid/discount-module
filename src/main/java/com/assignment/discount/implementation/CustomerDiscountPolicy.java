package com.assignment.discount.implementation;

import com.assignment.discount.interfaces.DiscountPolicy;
import com.assignment.discount.pojo.OrderDetailTO;
import com.assignment.discount.pojo.UserType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CustomerDiscountPolicy extends PercentDiscountPolicy {

    @Override public boolean supports(final UserType userType) {
        return userType.equals(UserType.CUSTOMER);
    }

    @Override public BigDecimal calculateDiscount(final OrderDetailTO orderDetailTO) {
        if (orderDetailTO
            .getUserTO()
            .getDateOfRegistration() != null && orderDetailTO
            .getUserTO()
            .getDateOfRegistration()
            .isAfter(LocalDate
                .now()
                .minus(2, ChronoUnit.YEARS))){
            return BigDecimal.ZERO;
        }
        return calculateDiscount(new BigDecimal(0.05),orderDetailTO);
    }


}
