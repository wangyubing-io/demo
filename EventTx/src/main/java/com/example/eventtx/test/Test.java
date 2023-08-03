package com.example.eventtx.test;

import com.example.eventtx.entity.Account;
import com.example.eventtx.event.TestEvent;
import com.example.eventtx.event.TestPublish;
import com.example.eventtx.mapper.AccountMapper;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.util.UpdateEntity;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.example.eventtx.entity.table.AccountTableDef.ACCOUNT;


@Component
public class Test  {
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private TestPublish publish;

    @Transactional
    public void contextLoads() {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select()
                .where(ACCOUNT.AGE.eq(20));
        Account account = accountMapper.selectOneByQuery(queryWrapper);
        System.out.println(account);

        Account account1 = UpdateEntity.of(Account.class, account.getId());
        account1.setAge(21);
        accountMapper.update(account1);

        publish.publish(new TestEvent(account));
    }
}
