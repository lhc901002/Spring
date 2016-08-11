package org.michaelliu.spring.service.client;

/**
 * Created by michael on 2016/8/4.
 */
public class TestHessian extends RemoteServiceConsumer {

    public TestHessian(String context) {
        super(context);
    }

    public static void main(String[] args) throws Exception {
        TestHessian test = new TestHessian("classpath:config/hessian-client.xml");
//        test.testSave();
        test.testFind();
//        test.testSaveInSameBank();
//        test.testSaveInDifferentBank();
    }

}
