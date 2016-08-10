package org.michaelliu.spring.service.client;

import com.alibaba.fastjson.JSON;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.collect.Lists;
import org.michaelliu.spring.beans.dto.Account;
import org.michaelliu.spring.beans.vo.AccountVo;
import org.michaelliu.spring.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Michael on 8/9/16.
 */
public class RemoteServiceConsumer {

    private ApplicationContext appContext;

    private AccountService accountService;

    public RemoteServiceConsumer() {}

    public RemoteServiceConsumer(String context) {
        appContext = new ClassPathXmlApplicationContext(context);
        accountService = appContext.getBean("accountService", AccountService.class);
    }

    public void testSave() {
        try {
            int result = accountService.saveOrUpdateSelective(new Account("Michael", 500));
            System.out.println("saveOrUpdateSelective result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testFind() {
        AccountVo account = accountService.findById(1l);
        System.out.println(account);
        List<AccountVo> accountList = accountService.findByName("M");
        System.out.println(accountList);
        List<Long> idList = Lists.newArrayList();
        idList.add(1l);
        idList.add(2l);
        idList.add(3l);
        idList.add(4l);
        PageList accountPageList = accountService.findPageListByName("h", 1, 2);
        System.out.println(JSON.toJSONString(accountPageList));
        PageList accountPageList2 = accountService.findPageListByIdList(idList, 2, 2);
        System.out.println(JSON.toJSONString(accountPageList2));
    }

}
