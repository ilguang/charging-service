package com.guang.charging.order.common;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * 统一放回结果
 * @author guang
 * @date 2025/2/17 - 17:34
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE) // 将类中所有字段设置为 private 私有字段
public class JsonResult<T> {

    /**
     * 状态码
     */
    Integer code;

    /**
     * 提示消息
     */
    String message;

    /**
     * 响应体（具体的数据）
     */
    T data;


}
