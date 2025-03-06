package com.guang.charging.device.service;

import com.guang.charging.common.pojo.param.GunStatusUpdateParam;
import com.guang.charging.common.pojo.vo.StationInfoVO;

/**
 * @author guang
 * @date 2025/3/6 - 23:45
 */
public interface DeviceService {

    StationInfoVO getStationInfo(Integer gunId);

    boolean updateGunStatus(GunStatusUpdateParam param);

}
