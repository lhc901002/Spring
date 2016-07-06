package org.mliuframework.spring.demo.onlineshopping.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mliuframework.spring.demo.onlineshopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Michael on 7/1/16.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    private static final Log log = LogFactory.getLog(ProductController.class);

    @Autowired
    private ProductService productService;



}
