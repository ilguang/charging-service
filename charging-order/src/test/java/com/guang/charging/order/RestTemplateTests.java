package com.guang.charging.order;

import com.guang.charging.common.pojo.JsonResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

        String url = "http://localhost:8080/user/info/8";

        // get请求 getForEntity
        ResponseEntity<JsonResult> entity = restTemplate.getForEntity(url, JsonResult.class);
        if (entity != null) {
            // 获取状态码
            HttpStatus statusCode = entity.getStatusCode();
            if(HttpStatus.OK == statusCode) {
                JsonResult body = entity.getBody();
                System.out.println(body);
            }
        }
    }

}
