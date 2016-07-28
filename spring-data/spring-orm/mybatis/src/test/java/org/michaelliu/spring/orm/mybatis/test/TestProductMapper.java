package org.michaelliu.spring.orm.mybatis.test;

import com.alibaba.fastjson.JSON;
import org.michaelliu.spring.beans.dto.Product;
import org.michaelliu.spring.beans.vo.ProductVo;
import org.michaelliu.spring.orm.mybatis.mapper.ProductMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Michael on 7/28/16.
 */
public class TestProductMapper {

    public static void testSelectByPrimaryKey(Long id) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/mapper-config.xml");
        ProductMapper productMapper = (ProductMapper) context.getBean("productMapper");
        ProductVo productVo = productMapper.selectByPrimaryKey(id);
        System.out.println(JSON.toJSONString(productVo));
    }

    public static void testInsertSelective(Product product) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/mapper-config.xml");
        ProductMapper productMapper = (ProductMapper) context.getBean("productMapper");
        System.out.println("insert data: " + JSON.toJSONString(product));
        int result = productMapper.insertSelective(product);
        System.out.println("insert result: " + result);
        System.out.println("insert result: " + JSON.toJSONString(product));
    }

    public static void testUpdateByPrimaryKeySelective(Product product) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/mapper-config.xml");
        ProductMapper productMapper = (ProductMapper) context.getBean("productMapper");
        System.out.println("update data: " + JSON.toJSONString(product));
        int result = productMapper.updateByPrimaryKeySelective(product);
        System.out.println("update result: " + result);
    }

    public static void main(String[] args) {
        testSelectByPrimaryKey(1l);

        Product product = new Product.Builder()
                .setName("Michael Liu")
                .setBalance(13)
                .setPrice(378)
                .setStatus((byte) 1)
                .build();
//        testInsertSelective(product);
        testUpdateByPrimaryKeySelective(product);

    }

}
