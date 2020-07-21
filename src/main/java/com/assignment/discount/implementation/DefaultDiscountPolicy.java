package com.assignment.discount.implementation;

import com.assignment.discount.interfaces.DiscountPolicy;
import com.assignment.discount.pojo.OrderDetailTO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

public class DefaultDiscountPolicy implements DiscountPolicy {
    @Override public BigDecimal calculateDiscount(OrderDetailTO orderDetailTO) {
        BigDecimal value = Optional
            .ofNullable(orderDetailTO
                .getProductTOList()
                .stream()
                .map(p -> p.getSellingPrice())
                .reduce(BigDecimal::add).orElse(BigDecimal.ZERO))
                .orElse(BigDecimal.ZERO);
        return value
            .divide(BigDecimal.valueOf(100))
            .setScale(0, RoundingMode.DOWN)
            .multiply(new BigDecimal(5))
            .setScale(2, RoundingMode.HALF_UP);

    }
}
