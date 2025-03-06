package com.guang.charging.order;

import com.guang.charging.common.pojo.JsonResult;
import com.guang.charging.order.pojo.param.OrderAddParam;
import com.guang.charging.common.pojo.vo.UserInfoVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author guang
 * @date 2025/2/27 - 20:30
 */
@SpringBootTest
public class RestTemplateTests {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test(){

        // get请求 getForEntity
        ResponseEntity<String> forEntity = restTemplate.getForEntity("https://www.baidu.com", String.class);
        // 获取状态码
        System.out.println(forEntity.getStatusCode());  // 200 OK
        // 获取响应体
        System.out.println(forEntity.getBody());    // <!DOCTYPE html> ...

    }


    @Test
    public void testRestTemplateGetUser() {

//        String url = "http://localhost:8080/user/info/8";

        String url = "http://localhost:8080/user/info/{1}"; // {1} 占位符，使用占位符可以实现传一个参数或多个参数

        // get请求 getForEntity
        ResponseEntity<JsonResult> entity = restTemplate.getForEntity(url, JsonResult.class, 8);
        if (entity != null) {
            // 获取状态码
            HttpStatus statusCode = entity.getStatusCode();
            if(HttpStatus.OK == statusCode) {
                // 获取响应体
                JsonResult body = entity.getBody();
                System.out.println(body);

                // 获取data
                Object data = body.getData();
                System.out.println(data);

                // 如何将 Object data 转换成 UserInfoVO
                /**
                 * ClassCastException（类型转换异常）:
                 * class java.util.LinkedHashMap
                 * cannot be cast to class
                 * com.guang.charging.common.pojo.vo.UserInfoVO
                 * 从这个异常可以知道，data本身是Json，实际是 排序的k-v LinkedHashMap
                 */
                UserInfoVO userInfoV = (UserInfoVO) data;
                System.out.println(userInfoV);

            }
        }
    }

    /**
     * ParameterizedTypeReference 指定返回的类型，无需我们自己反序列化
     */
    @Test
    public void testRestTemplateExchangeGetUser() {

        String url = "http://localhost:8080/user/info/{1}"; // {1} 占位符，使用占位符可以实现传一个参数或多个参数

        /**
         * spring 提供了一个用于 反序列化 泛型数据 的类
         */
        ParameterizedTypeReference<JsonResult<UserInfoVO>> repBody =
                new ParameterizedTypeReference<JsonResult<UserInfoVO>>() {
        };

        /**
         * 将 ParameterizedTypeReference对象 传入 exchange方法
         */
        ResponseEntity<JsonResult<UserInfoVO>> exchange = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                repBody,
                8, 2
        );

        if (exchange != null) {
            // 获取并验证状态码
            if(HttpStatus.OK == exchange.getStatusCode()) {
                // 获取响应体
                JsonResult<UserInfoVO> body = exchange.getBody();
                System.out.println(body);
                // 获取data
                UserInfoVO userInfoVO = body.getData();
                System.out.println(userInfoVO);
                System.out.println(userInfoVO.getCarId());
            }
        }
    }

    @Test
    public void testRestTemplatePostOrder() {

        String url = "http://localhost:7070/order/create"; // {1} 占位符，使用占位符可以实现传一个参数或多个参数

        OrderAddParam orderAddParam = new OrderAddParam();
        orderAddParam.setUserId(1);
        orderAddParam.setPileId(1);
        orderAddParam.setGunId(1);

        /**
         * 一般的post请求
         */
//        ResponseEntity<JsonResult> entity = restTemplate.postForEntity(url, orderAddParam, JsonResult.class);

        /**
         * 使用 ParameterizedTypeReference类，反序列化响应体的 post请求
         */
        ParameterizedTypeReference<JsonResult<String>> repBody =
                new ParameterizedTypeReference<JsonResult<String>>() {
        };
        // 请求体不能直接传入 exchange方法，需要使用 HttpEntity方法封装传入
        HttpEntity<OrderAddParam> httpEntity = new HttpEntity<>(orderAddParam);
        ResponseEntity<JsonResult<String>> entity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                httpEntity,
                repBody
        );

        if (entity != null) {
            // 获取并验证状态码
            if(HttpStatus.OK == entity.getStatusCode()) {
                // 获取响应体
                JsonResult<String> body = entity.getBody();
                System.out.println(body);
                String data = body.getData();
                System.out.println(data);
            }
        }
    }

}
