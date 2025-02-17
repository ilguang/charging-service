package com.guang.charging.order.service;

import com.guang.charging.order.pojo.param.OrderAddParam;

/**
 * @author guang
 * @date 2025/2/17 - 17:06
 */
public interface OrderService {
    String createOrder(OrderAddParam orderAddParam);
}
