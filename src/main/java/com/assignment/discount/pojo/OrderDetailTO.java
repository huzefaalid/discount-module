package com.assignment.discount.pojo;

import java.util.List;

public class OrderDetailTO {
    private List<ProductTO> productTOList;
    private UserTO userTO;

    public List<ProductTO> getProductTOList() {
        return productTOList;
    }

    public void setProductTOList(List<ProductTO> productTOList) {
        this.productTOList = productTOList;
    }

    public UserTO getUserTO() {
        return userTO;
    }

    public void setUserTO(UserTO userTO) {
        this.userTO = userTO;
    }
}
