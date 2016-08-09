package org.michaelliu.spring.remote;

/**
 * Created by Michael on 7/14/16
 *
 * RMI: rmi://localhost:1199/rmi/MessageService
 * Hessian: http://localhost:8080/hessian/MessageService
 */
public interface MessageService {

    String echo(String message);

}
