package com.assignment.discount.interfaces;

import com.assignment.discount.pojo.OrderDetailTO;
import java.math.BigDecimal;

public interface DiscountCalculation {
     BigDecimal calculateTotalDiscount(final OrderDetailTO orderDetailTO);

}
