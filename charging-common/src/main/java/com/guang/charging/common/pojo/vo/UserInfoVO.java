package com.guang.charging.common.pojo.vo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author guang
 * @date 2025/2/20 - 23:03
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserInfoVO {

    /**
     * 车辆id（暂定一个用户绑定一辆车）
     */
    Integer carId;

}
