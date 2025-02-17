package com.guang.charging.order.pojo.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author guang
 * @date 2025/2/17 - 17:30
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderAddParam {

    @ApiModelProperty(value = "用户id")
    Integer userId;

}
