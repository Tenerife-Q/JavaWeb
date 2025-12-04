package com;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/18 15:11
 *
 * 请求数据获取
 * 通过 HttpServleiRequest 对象方法获取
 */

@RestController
public class RequestController {
    @RequestMapping("/request")
    public String request(HttpServletRequest request) {
        //1.获取请求方式
        String method = request.getMethod();
        System.out.println("method: " + method);

        //2.获取请求url地址
        //完整请求路径
        String url = request.getRequestURL().toString();
        System.out.println("url: " + url);
        //资源请求路径
        String uri = request.getRequestURI();
        System.out.println("uri: " + uri);

        //3.获取请求协议
        String protocol = request.getProtocol();
        System.out.println("protocol: " + protocol);

        //4.获取请求参数 name age 请求头中请求参数
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("name: " + name + " age: " + age);

        //5.获取请求头 Accept
        String accept = request.getHeader("Accept");
        System.out.println("Accept: " + accept);

        return "OK";
    }

}
