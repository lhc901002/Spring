package org.mliuframework.spring.orm.ibatis.mapper;

import org.mliuframework.spring.orm.ibatis.vo.ProductFieldUpdateParam;

/**
 * Created by Michael on 6/29/16.
 */
public interface ProductMapper {

    int updateByDecreaseBalance(ProductFieldUpdateParam param);

}
