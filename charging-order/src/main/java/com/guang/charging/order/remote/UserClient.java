package com.guang.charging.order.remote;

import com.guang.charging.common.pojo.JsonResult;
import com.guang.charging.order.pojo.vo.UserInfoVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 远程调用——用户服务
 * @author guang
 * @date 2025/3/6 - 20:13
 */
// userService表示的是服务的名字，要和nacos里服务列表的服务名称一致
@FeignClient("userService")
public interface UserClient {

    @GetMapping("/user/info/{userId}")  // 要调用的地址 用户服务的接口地址
    JsonResult<UserInfoVO> getUserCarInfo(@PathVariable("userId") Integer  userId);

}
