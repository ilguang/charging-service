package com.guang.charging.order.remote;

import com.guang.charging.common.pojo.JsonResult;
import com.guang.charging.common.pojo.param.GunStatusUpdateParam;
import com.guang.charging.common.pojo.vo.StationInfoVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 远程调用——设备服务
 * @author guang
 * @date 2025/3/6 - 21:40
 */
@FeignClient("deviceService")
public interface DeviceClient {

    @GetMapping("/device/station/info/{gunId}")
    JsonResult getStationInfo(@PathVariable("gunId") Integer gunId);

    @PostMapping("/device/station/gun/status/update")
    JsonResult updateGunStatus(@RequestBody GunStatusUpdateParam param);

}
