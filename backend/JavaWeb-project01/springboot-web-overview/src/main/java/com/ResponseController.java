package com;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/18 15:44
 */

@RestController
public class ResponseController {

    /**
     * 方式一：HttpServletResponse 设置响应数据
     * @param response
     * @throws IOException
     */
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException {
        //1. 设置响应状态码
        response.setStatus(401);

        //2. 设置响应头
        response.setHeader("Tenerife", "Su san");

        //3. 设置响应体
        response.getWriter().write("<h1>hello response</h1>");
    }


    /**
     * 方式二 ResponseEntity<String> - spring里面提供的方式
     * @return
     */
    @RequestMapping("/response2")
    public ResponseEntity<String> response2(){
        return ResponseEntity
                .status(401)//响应状态码
                .header("Tenerife", "Su san")//响应头
                .body("<h1>hello response2</h1>");//响应体
    }
}
