package org.michaelliu.spring.orm.mybatis.mapper;

import org.michaelliu.spring.beans.dto.Product;
import org.michaelliu.spring.beans.vo.ProductFieldUpdateParam;
import org.michaelliu.spring.beans.vo.ProductVo;

import java.util.List;

/**
 * Created by Michael on 6/29/16.
 */
public interface ProductMapper {

    ProductVo selectByPrimaryKey(Long id);

    List<ProductVo> selectByProperties(Product product);

    List<ProductVo> selectByIdList(List<Long> idList);

    List<ProductVo> selectAllWithOrder();

    int insertSelective(Product product);

    int updateByPrimaryKeySelective(Product product);

    int updateByDecreaseBalance(ProductFieldUpdateParam productFieldUpdateParam);

}
