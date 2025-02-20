package com.guang.charging.order.controller;

import com.guang.charging.order.common.JsonResult;
import com.guang.charging.order.pojo.dto.StationInfoDto;
import com.guang.charging.order.pojo.dto.UserInfoDto;
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
        // 1. 生成订单号
        String orderNo = getOrderNo();

        // 2. 获取 场站信息 和 设备信息
        StationInfoDto stationInfo = getStationInfoByGunId(orderAddParam.getGunId());

        // 3. 获取用户车辆信息
        UserInfoDto userInfoDto = getUserInfoByUserId(orderAddParam.getUserId());

        // 4. 给设备发送开始充电指令
        startCharging(orderNo, orderAddParam.getPileId(), orderAddParam.getGunId());

        // 5. 修改 充电枪 的 状态 为 使用中
        boolean success = updateGunStatusToBusy(orderAddParam.getGunId());

        return null;
    }

    /**
     * 给设备发送开始充电指令
     *
     * @param orderNo   订单id
     * @param pileId    充电桩id
     * @param gunId     充电枪id
     */
    private void startCharging(String orderNo, Integer pileId, Integer gunId) {
    }

    /**
     * 5. 修改 充电枪 的 状态 为 使用中
     *
     * @param gunId
     * @return
     */
    private boolean updateGunStatusToBusy(Integer gunId) {
        return true;
    }

    /**
     * 根据用户id获取用户车辆信息
     * @param userId
     * @return
     */
    private UserInfoDto getUserInfoByUserId(Integer userId) {
        return null;
    }

    /**
     * 根据枪id获取场站信息
     * @param gunId
     * @return
     */
    private StationInfoDto getStationInfoByGunId(Integer gunId) {

        return null;
    }

    /**
     * 生成订单号
     * @return
     */
    private String getOrderNo() {
        return "666";
    }

}
