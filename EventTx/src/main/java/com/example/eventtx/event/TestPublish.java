package com.example.eventtx.event;

import com.example.eventtx.entity.Account;
import com.example.eventtx.mapper.AccountMapper;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.util.UpdateEntity;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class TestPublish {

    private final ApplicationEventPublisher publisher;


    public void publish(TestEvent testEvent){
        publisher.publishEvent(testEvent);
    }
}
