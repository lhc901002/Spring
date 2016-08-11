package org.michaelliu.demo.spring.task.thread;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by Michael on 2016/7/11.
 */
public class MessagePrinterTask implements Runnable {

    private static final Log log = LogFactory.getLog(MessagePrinterTask.class);

    private String message;

    public MessagePrinterTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        log.info(message);
    }

}
