package com.assignment.discount.implementation;

import com.assignment.discount.interfaces.DiscountCalculation;
import com.assignment.discount.interfaces.DiscountPolicy;
import com.assignment.discount.pojo.OrderDetailTO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DiscountCalculationImpl implements DiscountCalculation {
    private List<DiscountPolicy> discountPolicies;

    public DiscountCalculationImpl() {
        this.discountPolicies = new ArrayList<DiscountPolicy>(){{
            add(new CustomerDiscountPolicy());
            add(new AffiliateDiscountPolicy());
            add(new EmployeeDiscountPolicy());
            add(new DefaultDiscountPolicy());
        }};
    }

    public void init(){

    }

    @Override public BigDecimal calculateTotalDiscount(OrderDetailTO orderDetailTO) {
        return this.discountPolicies
            .stream()
            .filter(policy -> policy.supports(orderDetailTO
                .getUserTO()
                .getUserType()))
            .map(t -> t.calculateDiscount(orderDetailTO)).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

}
