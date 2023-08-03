package com.example.eventtx.event;

import com.example.eventtx.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestEvent {

    private Account account;
}
