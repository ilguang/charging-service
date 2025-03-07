package com.guang.charging.order.service.impl;

import com.guang.charging.common.pojo.JsonResult;
import com.guang.charging.common.pojo.param.GunStatusUpdateParam;
import com.guang.charging.common.pojo.vo.StationInfoVO;
import com.guang.charging.common.pojo.vo.UserInfoVO;
import com.guang.charging.order.constant.Constants;
import com.guang.charging.order.pojo.dto.StationInfoDto;
import com.guang.charging.order.pojo.dto.UserInfoDto;
import com.guang.charging.order.pojo.param.OrderAddParam;
import com.guang.charging.order.remote.DeviceClient;
import com.guang.charging.order.remote.UserClient;
import com.guang.charging.order.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guang
 * @date 2025/2/17 - 17:06
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private DeviceClient deviceClient;

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
        GunStatusUpdateParam param = new GunStatusUpdateParam();
        param.setGunId(gunId);
        param.setStatus(Constants.GUN_STATUS_BUSY);
        // 调用远程设备服务，修改枪的状态
        JsonResult<Boolean> jsonResult = deviceClient.updateGunStatus(param);
        if (jsonResult != null) {
            return jsonResult.getData();
        }
        return false;
    }

    @Autowired
    private UserClient userClient;

    /**
     * 根据用户id获取用户车辆信息
     * 订单服务 调用 用户服务 获取 车辆信息
     *
     * @param userId
     * @return
     */
    private UserInfoDto getUserInfoByUserId(Integer userId) {

        // 根据用户Id调用远程服务
        JsonResult<UserInfoVO> jsonResult = userClient.getUserCarInfo(userId);

        UserInfoDto userInfoDto = null;

        if (jsonResult != null && jsonResult.getCode() == 2000) {
            UserInfoVO data = jsonResult.getData();
            userInfoDto = new UserInfoDto();
            if (data != null) {
                BeanUtils.copyProperties(data, userInfoDto);
            }
        }

        return userInfoDto;
    }

    /**
     * 根据枪id获取场站信息
     * @param gunId
     * @return
     */
    private StationInfoDto getStationInfoByGunId(Integer gunId) {

        // 调用远程设备服务获取场站信息
        JsonResult<StationInfoVO> stationInfo = deviceClient.getStationInfo(gunId);

        StationInfoDto stationInfoDto = null;

        if (stationInfo != null) {
            // 从远程服务响结果中拿到场站信息
            StationInfoVO data = stationInfo.getData();
            if (data != null) {
                stationInfoDto = new StationInfoDto();
//                stationInfoDto.setStationId(data.getStationId());
                // todo copyProperties 底层实现
                BeanUtils.copyProperties(data, stationInfoDto);
            }
        }

        return stationInfoDto;
    }

    /**
     * 生成订单号
     * @return
     */
    private String getOrderNo() {
        return "666";
    }
}
