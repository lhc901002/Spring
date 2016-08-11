package org.michaelliu.demo.spring.rmi.service.impl;

import org.michaelliu.demo.spring.rmi.service.MessageService;

/**
 * Created by Michael on 8/11/16.
 */
public class MessageServiceImpl implements MessageService {

    @Override
    public String sayHello(String message) {
        return "Hello " + message;
    }

}
