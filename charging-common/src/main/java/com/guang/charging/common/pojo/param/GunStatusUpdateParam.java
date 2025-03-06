package com.guang.charging.common.pojo.param;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * 更新枪状态请求参数
 * @author guang
 * @date 2025/3/6 - 23:39
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GunStatusUpdateParam {

    /**
     * 枪Id
     */
    Integer gunId;

    /**
     * 枪状态
     */
    Integer status;

}
