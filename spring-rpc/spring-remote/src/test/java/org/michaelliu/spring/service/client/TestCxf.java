package org.michaelliu.spring.service.client;

/**
 * Created by Michael on 8/10/16.
 */
public class TestCxf extends RemoteServiceConsumer {

    public TestCxf(String context) {
        super(context);
    }

    public static void main(String[] args) {
//        new TestRmi("classpath:config/cxf-client.xml").testSave();
        new TestRmi("classpath:config/cxf-client.xml").testFind();
    }

}
