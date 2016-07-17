package org.michaelliu.spring.schedule;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by Michael on 7/4/16.
 */
//@Component
public class AnnotatedScheduledJob {

    private static final Log log = LogFactory.getLog(AnnotatedScheduledJob.class);

    private static int count1 = 0;
    private static int count2 = 0;
    private static int count3 = 0;
    private static int count4 = 0;

    /**
     * The following method would be invoked every 5 seconds
     * with a fixed delay, meaning that the period will be
     * measured from the completion time of each preceding invocation.
     */
    @Scheduled(fixedDelay = 5000)
    public void runTask1() {
        log.info("Task1 run " + (++count1) + " times");
    }

    /**
     * The following would be executed every 5 seconds
     * measured between the successive start times of each invocation.
     */
    @Scheduled(fixedRate = 5000)
    public void runTask2() {
        log.info("Task2 run " + (++count2) + " times");
    }

    /**
     * An initial delay may be specified indicating
     * the number of milliseconds to wait before the
     * first execution of the method.
     */
    @Scheduled(initialDelay = 1000, fixedRate = 5000)
    public void runTask3() {
        log.info("Task3 run " + (++count3) + " times");
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void runTask4() {
        log.info("Task4 run " + (++count4) + " times");
    }

}
