package com.guang.charging.order.service.impl;

import com.guang.charging.order.pojo.param.OrderAddParam;
import com.guang.charging.order.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @author guang
 * @date 2025/2/17 - 17:06
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public String createOrder(OrderAddParam orderAddParam) {
        return "666";
    }
}
