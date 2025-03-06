package com.guang.charging.order;

import com.guang.charging.common.pojo.JsonResult;
import com.guang.charging.order.pojo.vo.UserInfoVO;
import com.guang.charging.order.remote.UserClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * OpenFeign远程调用 单元测试
 * @author guang
 * @date 2025/3/6 - 20:41
 */
@SpringBootTest
class FeignTests {

    @Autowired
    private UserClient  userClient;

    @Test
    public void testGetUserInfo() {
        JsonResult<UserInfoVO> userInfo = userClient.getUserCarInfo(5);
        UserInfoVO data = userInfo.getData();
        System.out.println("carId = "  + data.getCarId());
    }

}
