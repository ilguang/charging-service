package com.guang.charging.device.controller;

import com.guang.charging.common.pojo.JsonResult;
import com.guang.charging.common.pojo.param.GunStatusUpdateParam;
import com.guang.charging.common.pojo.vo.StationInfoVO;
import com.guang.charging.device.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 设备控制器
 * @author guang
 * @date 2025/3/6 - 22:06
 */
@Slf4j
@RestController
@RequestMapping ("/device")
@Api(tags = "设备接口")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @ApiOperation("获取场站信息")
    @GetMapping("/station/info/{gunId}")
    public JsonResult getStationInfo(@PathVariable("gunId") Integer gunId) {
        log.info("获取场站信息：{}", gunId);
        StationInfoVO stationInfoVO = deviceService.getStationInfo(gunId);
        JsonResult ok = JsonResult.ok(stationInfoVO);
        log.info("获取场站信息:{}，入参：{}", gunId, ok);
        return ok;
    }

    @ApiOperation("更新枪的状态")
    @PostMapping("/station/gun/status/update")
    public JsonResult updateGunStatus(@RequestBody GunStatusUpdateParam param) {
        log.info("更新枪状态：{}", param);
        boolean success = deviceService.updateGunStatus(param);
        JsonResult ok = JsonResult.ok(success);
        log.info("更新枪状态:{}，入参：{}", param, ok);
        return ok;
    }


}
