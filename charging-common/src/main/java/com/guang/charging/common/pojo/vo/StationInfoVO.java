package com.guang.charging.common.pojo.vo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author guang
 * @date 2025/3/6 - 22:21
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StationInfoVO {

    /**
     * 场站Id
     */
    Integer stationId;

}
