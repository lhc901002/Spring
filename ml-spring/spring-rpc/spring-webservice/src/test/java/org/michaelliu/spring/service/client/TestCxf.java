package org.michaelliu.spring.service.client;

/**
 * Created by Michael on 8/10/16.
 */
public class TestCxf extends RemoteServiceConsumer {

    public TestCxf(String context) {
        super(context);
    }

    public static void main(String[] args) throws Exception {
        TestCxf test = new TestCxf("classpath:config/cxf-client.xml");
//        test.testSave();
        test.testFind();
//        test.testSaveInSameBank();
//        test.testSaveInDifferentBank();
    }

}
