package com.guang.charging.order.controller;

import com.guang.charging.common.pojo.JsonResult;
import com.guang.charging.order.pojo.dto.StationInfoDto;
import com.guang.charging.order.pojo.dto.UserInfoDto;
import com.guang.charging.order.pojo.param.OrderAddParam;
import com.guang.charging.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.DocumentationCache;

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
    @Autowired
    private DocumentationCache resourceGroupCache;


    /**
     * 创建订单
     *  1. 生成订单号
     *  2. 获取 场站信息 和 设备信息
     *  3. 获取用户车辆信息
     *  4. 订单服务 给 设备 发送开始充电指令  （物联网 订单服务 调用 充电桩设备 服务与 设备之间通信）
     *  5. 修改 充电枪 的 状态 为 使用中
     *
     *
     * @param orderAddParam
     * @return
     */
    @ApiOperation("创建订单")
    @PostMapping("/create")
    public JsonResult createOrder(OrderAddParam orderAddParam) {

        // 创建订单
        String orderNo = orderService.createOrder(orderAddParam);

        // 封装响应结果
        JsonResult<String> result = new JsonResult<>();
        result.setCode(2000);
        result.setMessage("创建订单成功！");
        result.setData(orderNo);

        return result;
    }

}
