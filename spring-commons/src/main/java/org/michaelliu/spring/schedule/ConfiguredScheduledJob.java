package org.michaelliu.spring.schedule;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by Michael on 7/4/16.
 */
public class ConfiguredScheduledJob {

    private static final Log log = LogFactory.getLog(ConfiguredScheduledJob.class);

    private static int count1 = 0;
    private static int count2 = 0;
    private static int count3 = 0;
    private static int count4 = 0;

    public void runTask1() {
        log.info("Task1 run " + (++count1) + " times");
    }

    public void runTask2() {
        log.info("Task2 run " + (++count2) + " times");
    }

    public void runTask3() {
        log.info("Task3 run " + (++count3) + " times");
    }

    public void runTask4() {
        log.info("Task4 run " + (++count4) + " times");
    }

}
