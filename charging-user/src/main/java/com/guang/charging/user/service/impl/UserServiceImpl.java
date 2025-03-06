package com.guang.charging.user.service.impl;

import com.guang.charging.common.pojo.vo.UserInfoVO;
import com.guang.charging.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author guang
 * @date 2025/2/20 - 22:47
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserInfoVO queryUserById(Integer userId) {
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setCarId(777);
        return userInfoVO;
    }
}
