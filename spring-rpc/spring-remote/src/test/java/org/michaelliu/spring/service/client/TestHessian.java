package org.michaelliu.spring.service.client;

/**
 * Created by michael on 2016/8/4.
 */
public class TestHessian extends RemoteServiceConsumer {

    public TestHessian(String context) {
        super(context);
    }

    public static void main(String[] args) {
//        new TestRmi("classpath:config/hessian-client.xml").testSave();
        new TestRmi("classpath:config/hessian-client.xml").testFind();
    }

}
