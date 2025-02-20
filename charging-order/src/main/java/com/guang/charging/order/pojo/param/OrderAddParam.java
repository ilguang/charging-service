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

    @ApiModelProperty(value = "充电枪id")
    Integer gunId;

    @ApiModelProperty(value = "充电桩id")
    Integer pileId;

}
