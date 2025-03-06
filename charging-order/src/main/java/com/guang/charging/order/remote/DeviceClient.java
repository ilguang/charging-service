package com.guang.charging.order.remote;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * 远程调用——设备服务
 * @author guang
 * @date 2025/3/6 - 21:40
 */
@FeignClient("deviceService")
public interface DeviceClient {
}
