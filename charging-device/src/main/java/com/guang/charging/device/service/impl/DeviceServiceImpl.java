package com.guang.charging.device.service.impl;

import com.guang.charging.common.pojo.param.GunStatusUpdateParam;
import com.guang.charging.common.pojo.vo.StationInfoVO;
import com.guang.charging.device.service.DeviceService;
import org.springframework.stereotype.Service;

/**
 * @author guang
 * @date 2025/3/7 - 0:02
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    @Override
    public StationInfoVO getStationInfo(Integer gunId) {
        StationInfoVO stationInfoVO = new StationInfoVO();
        stationInfoVO.setStationId(66);
        return stationInfoVO;
    }

    @Override
    public boolean updateGunStatus(GunStatusUpdateParam param) {
        return true;
    }
}
