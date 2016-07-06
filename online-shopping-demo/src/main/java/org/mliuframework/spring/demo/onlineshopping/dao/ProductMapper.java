package org.mliuframework.spring.demo.onlineshopping.dao;

import org.mliuframework.spring.demo.onlineshopping.vo.ProductFieldUpdateParam;

/**
 * Created by Michael on 6/29/16.
 */
public interface ProductMapper {

    int updateByDecreaseBalance(ProductFieldUpdateParam param);

}
