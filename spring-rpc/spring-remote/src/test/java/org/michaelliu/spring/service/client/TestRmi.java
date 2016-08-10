package org.michaelliu.spring.service.client;

/**
 * Created by Michael on 8/4/16.
 */
public class TestRmi extends RemoteServiceConsumer {

    public TestRmi(String context) {
        super(context);
    }

    public static void main(String[] args) {
//        new TestRmi("classpath:config/rmi-client.xml").testSave();
        new TestRmi("classpath:config/rmi-client.xml").testFind();
    }

}
