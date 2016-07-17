package org.michaelliu.spring.task;

/**
 * Created by Michael on 2016/7/11.
 */
public class MessagePrinterTask implements Runnable {

    private String message;

    public MessagePrinterTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(message);
    }

}
