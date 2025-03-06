package com.guang.charging.user.service;

import com.guang.charging.common.pojo.vo.UserInfoVO;

/**
 * 用户服务
 * @author guang
 * @date 2025/2/20 - 22:45
 */
public interface UserService {

    UserInfoVO queryUserById(Integer userId);

}
