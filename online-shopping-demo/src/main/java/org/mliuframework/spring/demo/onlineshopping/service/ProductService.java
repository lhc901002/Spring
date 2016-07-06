package org.mliuframework.spring.demo.onlineshopping.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mliuframework.spring.demo.onlineshopping.dao.ProductMapper;
import org.mliuframework.spring.demo.onlineshopping.vo.ProductFieldUpdateParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Michael on 7/1/16.
 */
@Service
public class ProductService {

    private static final Log log = LogFactory.getLog(ProductService.class);

    @Autowired
    private ProductMapper productMapper;

    public int updateByBalance(ProductFieldUpdateParam param) throws Exception {
        if (param == null || param.getId() == null ||
                param.getBalanceChange() == null) {
            throw new IllegalArgumentException("ID and balanceChange cannot be empty!");
        }
        if (param.getBalanceChange() <= 0) {
            throw new IllegalArgumentException("Balance change cannot be negative!");
        }
        try {
            return productMapper.updateByDecreaseBalance(param);
        } catch (Exception e) {
            throw e;
        }
    }


}
