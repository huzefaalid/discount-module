package com.assignment.discount.implementation;

import com.assignment.discount.interfaces.DiscountPolicy;
import com.assignment.discount.pojo.OrderDetailTO;
import com.assignment.discount.pojo.ProductType;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

public abstract class PercentDiscountPolicy implements DiscountPolicy {
    protected BigDecimal calculateDiscount(final BigDecimal percentFactor,final OrderDetailTO orderDetailTO){
        return Optional
            .ofNullable(orderDetailTO)
            .map(order -> order.getProductTOList())
            .map(productList -> productList
                .stream()
                .filter(p -> p!=null && !p
                    .getProductType()
                    .equals(ProductType.GROCERY))
                .map(product -> product.getSellingPrice())
                .reduce(BigDecimal.ZERO, (val1, val2) -> val1.add(val2.multiply(percentFactor))))
            .orElse(BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP);
    }
}
