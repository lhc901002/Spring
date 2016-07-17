package org.michaelliu.spring.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by Michael on 2016/7/11.
 */
//@Component
public class ScheduledTaskJob {

    @Autowired
    private MessagePrinterTaskExecutor messagePrinterTaskExecutor;

    @Scheduled(fixedDelay = 500)
    public void runTask() {
        messagePrinterTaskExecutor.printMessages();
    }

}
