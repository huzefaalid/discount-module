package com.assignment.discount.implementation;

import com.assignment.discount.interfaces.DiscountPolicy;
import com.assignment.discount.pojo.OrderDetailTO;
import com.assignment.discount.pojo.ProductTO;
import com.assignment.discount.pojo.ProductType;
import com.assignment.discount.pojo.UserType;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class EmployeeDiscountPolicy extends PercentDiscountPolicy {

    @Override public boolean supports(final UserType userType) {
        return userType.equals(UserType.EMPLOYEE);
    }

    @Override public BigDecimal calculateDiscount(final OrderDetailTO orderDetailTO) {
        return calculateDiscount(new BigDecimal(0.3),orderDetailTO);
    }


}
