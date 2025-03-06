package com.guang.charging.user.controller;

import com.guang.charging.common.pojo.JsonResult;
import com.guang.charging.common.pojo.vo.UserInfoVO;
import com.guang.charging.user.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guang
 * @date 2025/2/20 - 22:08
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api(tags = "用户接口")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户信息
     * @param userId    用户id
     * @return
     */
    @GetMapping("/info/{userId}")
    public JsonResult getUserById(@PathVariable("userId") Integer userId) {

        log.info("获取用户信息，userId:{}", userId);

        // 获取用户信息
        UserInfoVO userInfo = userService.queryUserById(userId);

        // 封装响应结果
//        JsonResult<UserInfoVO> result = new JsonResult<>();
//        result.setCode(2000);
//        result.setData(userInfo);

        log.info("用户信息，userInfo:{}", userInfo);

        return JsonResult.ok(userInfo);
    }

}
