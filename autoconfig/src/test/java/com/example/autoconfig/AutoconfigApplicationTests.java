package com.example.autoconfig;

import com.yiche.om.common.component.model.dto.PageDTO;
import com.yiche.om.common.component.model.dto.ResultDTO;
import com.yiche.om.order.api.order.client.OrderRunningClient;
import com.yiche.om.order.model.dto.common.OrderAuditTypeEnum;
import com.yiche.om.order.model.dto.orderrunning.OrderRunningDTO;
import com.yiche.om.order.model.request.orderrunning.OrderRunningRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AutoconfigApplicationTests {

    @Autowired
    private OrderRunningClient client;
    @Test
    void contextLoads() {
        OrderRunningRequest request = new OrderRunningRequest();
        request.setStaffNo("5941");
        request.setAuditType(OrderAuditTypeEnum.ORDER_APPROVE.getCode());
        ResultDTO<PageDTO<OrderRunningDTO>> orderRunningTaskList = client.findOrderRunningTaskList(request);
        System.out.println(orderRunningTaskList);
    }

}
