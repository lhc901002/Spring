package org.michaelliu.spring.task;

import org.springframework.core.task.TaskExecutor;

/**
 * Created by Michael on 2016/7/11.
 */
public class MessagePrinterTaskExecutor {

    private TaskExecutor taskExecutor;

    public MessagePrinterTaskExecutor(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void printMessages() {
        for(int i = 0; i < 25; i++) {
            taskExecutor.execute(new MessagePrinterTask("Message" + i));
        }
    }

}
