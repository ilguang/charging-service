package com.guang.charging.order.controller;

import com.guang.charging.order.common.JsonResult;
import com.guang.charging.order.pojo.param.OrderAddParam;
import com.guang.charging.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author guang
 * @date 2025/2/17 - 17:06
 */

@Slf4j
@RestController
@RequestMapping("/order")
@Api(tags = "订单接口")
public class OrderController {

    @Autowired
    private OrderService orderService;


    /**
     * 创建订单
     * @param orderAddParam
     * @return
     */
    @ApiOperation("创建订单")
    @PostMapping("/create")
    public JsonResult createOrder(OrderAddParam orderAddParam) {
        System.out.println("用户Id：" + orderAddParam.getUserId());
        String orderNo = orderService.createOrder(orderAddParam);
        JsonResult<Object> result = new JsonResult<>();
        result.setCode(2000);
        result.setMessage("创建订单成功！");
        result.setData(orderNo);
        return result;
    }

}
