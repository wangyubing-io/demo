package com.example.eventtx;

import com.example.eventtx.entity.Account;
import com.example.eventtx.event.TestEvent;
import com.example.eventtx.event.TestPublish;
import com.example.eventtx.mapper.AccountMapper;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.util.UpdateEntity;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static com.example.eventtx.entity.table.AccountTableDef.ACCOUNT;

@SpringBootTest
class EventTxApplicationTests {

    @Resource
    private AccountMapper accountMapper;
    @Resource
    private TestPublish publish;
    @Resource
    private AccountMapper mapper;

    @Test
    @Transactional
    void contextLoads() {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select()
                .where(ACCOUNT.AGE.eq(20));
        Account account = accountMapper.selectOneByQuery(queryWrapper);
        System.out.println(account);

        Account account1 = UpdateEntity.of(Account.class, account.getId());
        account1.setAge(20);
        mapper.update(account1);

        publish.publish(new TestEvent(account));
    }

}
