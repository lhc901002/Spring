package org.michaelliu.spring.mybatis.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.service.MessageService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

/**
 * Created by Michael on 7/14/16.
 */
@Service("messageService")
@WebService(endpointInterface = "org.michaelliu.spring.service.MessageService")
public class MessageServiceImpl implements MessageService {

    private static final Log log = LogFactory.getLog(MessageServiceImpl.class);

    @Override
    public String echo(String message) {
        log.info("echo receives: " + message);
        String rspStr;
        if (StringUtils.isEmpty(message)) {
            rspStr = "Message server has not received any message from client!";
        } else if (message.equals("quit") || message.equals("exit")) {
            rspStr = "Message server will be shutdown!";
        } else {
            rspStr = "Message server responses: " + message;
        }
        log.info("echo responses: " + rspStr);
        return rspStr;
    }

}
