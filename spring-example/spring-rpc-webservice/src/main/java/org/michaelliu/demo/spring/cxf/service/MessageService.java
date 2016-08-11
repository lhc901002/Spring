package org.michaelliu.demo.spring.cxf.service;

import javax.jws.WebService;

/**
 * Created by Michael on 7/14/16
 *
 * cxf: http://localhost:8080/cxf/MessageService
 */
@WebService
public interface MessageService {

    String sayHello(String message);

}
