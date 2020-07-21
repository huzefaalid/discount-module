import com.assignment.discount.implementation.DiscountCalculationImpl;
import com.assignment.discount.implementation.EmployeeDiscountPolicy;
import com.assignment.discount.interfaces.DiscountCalculation;
import com.assignment.discount.pojo.OrderDetailTO;
import com.assignment.discount.pojo.ProductTO;
import com.assignment.discount.pojo.ProductType;
import com.assignment.discount.pojo.UserTO;
import com.assignment.discount.pojo.UserType;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class DiscountCalculationTest {
    private DiscountCalculation discountCalculation;
    @BeforeEach
    public void setUp(){
      discountCalculation = new DiscountCalculationImpl();
    }

    @Test
    public void testDiscountCalculationForEmployees(){
        OrderDetailTO orderDetailTO = setUpDataForEmployee();
        BigDecimal discount = this.discountCalculation.calculateTotalDiscount(orderDetailTO);
        Assertions.assertNotNull(discount);
        Assertions.assertEquals(discount,BigDecimal.valueOf(83).setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    public void testDiscountCalculationForAffiliate(){
        OrderDetailTO orderDetailTO = setUpDataForAffiliate();
        BigDecimal discount = this.discountCalculation.calculateTotalDiscount(orderDetailTO);
        Assertions.assertNotNull(discount);
        Assertions.assertEquals(discount,BigDecimal.valueOf(41).setScale(2, RoundingMode.HALF_UP));
    }


    @Test
    public void testDiscountCalculationForCustomerJoinedRecently(){
        OrderDetailTO orderDetailTO = setUpDataForCustomers();
        BigDecimal discount = this.discountCalculation.calculateTotalDiscount(orderDetailTO);
        Assertions.assertNotNull(discount);
        Assertions.assertEquals(discount,BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    public void testDiscountCalculationForCustomerJoinedTwoYearsBefore(){
        OrderDetailTO orderDetailTO = setUpDataForOldCustomers();
        BigDecimal discount = this.discountCalculation.calculateTotalDiscount(orderDetailTO);
        Assertions.assertNotNull(discount);
        Assertions.assertEquals(discount,BigDecimal.valueOf(30.5).setScale(2, RoundingMode.HALF_UP));
    }

    private OrderDetailTO setUpDataForEmployee() {
        UserTO userTO = new UserTO();
        userTO.setUserName("Huzefa Diwanji");
        userTO.setUserType(UserType.EMPLOYEE);
        userTO.setDateOfRegistration(LocalDate.now());


        ProductTO productTO1 = new ProductTO();
        productTO1.setProductName("Chamber");
        productTO1.setProductType(ProductType.OTHERS);
        productTO1.setSellingPrice(new BigDecimal(210));

        ProductTO productTO2 = new ProductTO();
        productTO2.setProductName("Soap");
        productTO2.setProductType(ProductType.GROCERY);
        productTO2.setSellingPrice(new BigDecimal(210));

        List<ProductTO> productTOList = new ArrayList<>();
        productTOList.add(productTO1);
        productTOList.add(productTO2);

        OrderDetailTO orderDetailTO = new OrderDetailTO();
        orderDetailTO.setProductTOList(productTOList);
        orderDetailTO.setUserTO(userTO);
        return orderDetailTO;
        //discountPolicy = new EmployeeDiscountPolicy();
    }

    private OrderDetailTO setUpDataForAffiliate() {
        UserTO userTO = new UserTO();
        userTO.setUserName("Huzefa Diwanji");
        userTO.setUserType(UserType.AFFILIATE);
        userTO.setDateOfRegistration(LocalDate.now());


        ProductTO productTO1 = new ProductTO();
        productTO1.setProductName("Chamber");
        productTO1.setProductType(ProductType.OTHERS);
        productTO1.setSellingPrice(new BigDecimal(210));

        ProductTO productTO2 = new ProductTO();
        productTO2.setProductName("Soap");
        productTO2.setProductType(ProductType.GROCERY);
        productTO2.setSellingPrice(new BigDecimal(210));

        List<ProductTO> productTOList = new ArrayList<>();
        productTOList.add(productTO1);
        productTOList.add(productTO2);

        OrderDetailTO orderDetailTO = new OrderDetailTO();
        orderDetailTO.setProductTOList(productTOList);
        orderDetailTO.setUserTO(userTO);
        return orderDetailTO;
        //discountPolicy = new EmployeeDiscountPolicy();
    }

    private OrderDetailTO setUpDataForCustomers() {
        UserTO userTO = new UserTO();
        userTO.setUserName("Huzefa Diwanji");
        userTO.setUserType(UserType.CUSTOMER);
        userTO.setDateOfRegistration(LocalDate.now());


        ProductTO productTO1 = new ProductTO();
        productTO1.setProductName("Chamber");
        productTO1.setProductType(ProductType.OTHERS);
        productTO1.setSellingPrice(new BigDecimal(210));

        ProductTO productTO2 = new ProductTO();
        productTO2.setProductName("Soap");
        productTO2.setProductType(ProductType.GROCERY);
        productTO2.setSellingPrice(new BigDecimal(210));

        List<ProductTO> productTOList = new ArrayList<>();
        productTOList.add(productTO1);
        productTOList.add(productTO2);

        OrderDetailTO orderDetailTO = new OrderDetailTO();
        orderDetailTO.setProductTOList(productTOList);
        orderDetailTO.setUserTO(userTO);
        return orderDetailTO;
        //discountPolicy = new EmployeeDiscountPolicy();
    }

    private OrderDetailTO setUpDataForOldCustomers() {
        UserTO userTO = new UserTO();
        userTO.setUserName("Huzefa Diwanji");
        userTO.setUserType(UserType.CUSTOMER);
        userTO.setDateOfRegistration(LocalDate.now().minus(3, ChronoUnit.YEARS));


        ProductTO productTO1 = new ProductTO();
        productTO1.setProductName("Chamber");
        productTO1.setProductType(ProductType.OTHERS);
        productTO1.setSellingPrice(new BigDecimal(210));

        ProductTO productTO2 = new ProductTO();
        productTO2.setProductName("Soap");
        productTO2.setProductType(ProductType.GROCERY);
        productTO2.setSellingPrice(new BigDecimal(210));

        List<ProductTO> productTOList = new ArrayList<>();
        productTOList.add(productTO1);
        productTOList.add(productTO2);

        OrderDetailTO orderDetailTO = new OrderDetailTO();
        orderDetailTO.setProductTOList(productTOList);
        orderDetailTO.setUserTO(userTO);
        return orderDetailTO;
        //discountPolicy = new EmployeeDiscountPolicy();
    }
}
