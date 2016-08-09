package org.michaelliu.spring.service;

import javax.jws.WebService;

/**
 * Created by Michael on 7/14/16
 *
 * RMI: rmi://localhost:1199/rmi/MessageService
 * Hessian: http://localhost:8080/hessian/MessageService
 */
@WebService
public interface MessageService {

    String echo(String message);

}
