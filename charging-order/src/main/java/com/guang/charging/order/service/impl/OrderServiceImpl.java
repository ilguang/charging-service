package com.guang.charging.order.service.impl;

import com.guang.charging.order.pojo.dto.StationInfoDto;
import com.guang.charging.order.pojo.dto.UserInfoDto;
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

        return "666";
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
     * 订单服务 调用 用户服务 获取 车辆信息
     *
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
