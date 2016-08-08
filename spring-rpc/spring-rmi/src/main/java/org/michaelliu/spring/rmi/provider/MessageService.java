package org.michaelliu.spring.rmi.provider;

/**
 * Created by Michael on 7/14/16
 *
 * RMI: rmi://localhost:1199/RmiMessageService
 */
public interface MessageService {

    String echo(String message);

}
