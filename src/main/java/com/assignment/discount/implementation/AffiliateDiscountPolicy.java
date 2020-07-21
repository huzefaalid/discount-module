package com.assignment.discount.implementation;

import com.assignment.discount.interfaces.DiscountPolicy;
import com.assignment.discount.pojo.OrderDetailTO;
import com.assignment.discount.pojo.UserType;
import java.math.BigDecimal;

public class AffiliateDiscountPolicy extends PercentDiscountPolicy {

    @Override public boolean supports(final UserType userType) {
        return userType.equals(UserType.AFFILIATE);
    }

    @Override public BigDecimal calculateDiscount(final OrderDetailTO orderDetailTO) {
        return calculateDiscount(new BigDecimal(0.1),orderDetailTO);
    }


}
