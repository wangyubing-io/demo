package com.example.eventtx.test;

import com.example.eventtx.entity.Account;
import com.example.eventtx.event.TestEvent;
import com.example.eventtx.mapper.AccountMapper;
import com.mybatisflex.core.util.UpdateEntity;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Test1 {

    @Autowired
    private ApplicationContext applicationContext;
    @Resource
    private AccountMapper accountMapper;

    @EventListener
    public void consume(TestEvent testEvent){
        Test1 bean = applicationContext.getBean(Test1.class);
        bean.extracted(testEvent);
    }

    @Transactional
    public void extracted(TestEvent testEvent) {
        Account account = UpdateEntity.of(Account.class, testEvent.getAccount().getId());
        account.setAge(22);
        accountMapper.update(account);
    }

}
