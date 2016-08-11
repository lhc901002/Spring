package org.michaelliu.demo.spring.hessian.service.impl;

import org.michaelliu.demo.spring.hessian.service.MessageService;

/**
 * Created by Michael on 8/11/16.
 */
public class MessageServiceImpl implements MessageService {

    @Override
    public String sayHello(String message) {
        return "Hello " + message;
    }

}
