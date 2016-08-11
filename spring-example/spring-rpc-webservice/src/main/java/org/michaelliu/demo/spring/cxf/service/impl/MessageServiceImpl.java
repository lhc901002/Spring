package org.michaelliu.demo.spring.cxf.service.impl;

import org.michaelliu.demo.spring.cxf.service.MessageService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

/**
 * Created by Michael on 8/11/16.
 */
@Service("messageService")
@WebService(endpointInterface = "org.michaelliu.demo.spring.cxf.service.MessageService")
public class MessageServiceImpl implements MessageService {

    @Override
    public String sayHello(String message) {
        return "Hello " + message;
    }

}
