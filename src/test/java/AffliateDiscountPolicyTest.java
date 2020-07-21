
import com.assignment.discount.implementation.AffiliateDiscountPolicy;
import com.assignment.discount.implementation.EmployeeDiscountPolicy;
import com.assignment.discount.interfaces.DiscountPolicy;
import com.assignment.discount.pojo.OrderDetailTO;
import com.assignment.discount.pojo.ProductTO;
import com.assignment.discount.pojo.ProductType;
import com.assignment.discount.pojo.UserTO;
import com.assignment.discount.pojo.UserType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Unit Test - Discount Tests")

public class AffliateDiscountPolicyTest {

    private DiscountPolicy discountPolicy;
    private OrderDetailTO orderDetailTO;

    @BeforeEach
    public void setUp() throws Exception {
        UserTO userTO = new UserTO();
        userTO.setUserName("Huzefa Diwanji");
        userTO.setUserType(UserType.AFFILIATE);
        userTO.setDateOfRegistration(LocalDate.now());


        ProductTO productTO1 = new ProductTO();
        productTO1.setProductName("Vass");
        productTO1.setProductType(ProductType.OTHERS);
        productTO1.setSellingPrice(new BigDecimal(210));

        List<ProductTO> productTOList = new ArrayList<>();
        productTOList.add(productTO1);
        orderDetailTO = new OrderDetailTO();
        orderDetailTO.setProductTOList(productTOList);
        orderDetailTO.setUserTO(userTO);
        discountPolicy = new AffiliateDiscountPolicy();

    }
    @Test
    public void testDiscountCalculation(){
       final BigDecimal value = discountPolicy.calculateDiscount(orderDetailTO);
        Assertions.assertNotNull(value);
        Assertions.assertTrue(value.compareTo(BigDecimal.ZERO)>0);
    }

}