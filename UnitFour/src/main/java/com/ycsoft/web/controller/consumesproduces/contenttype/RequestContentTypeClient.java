package com.ycsoft.web.controller.consumesproduces.contenttype;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

public class RequestContentTypeClient {
    
    public static void main(String[] args) throws IOException, URISyntaxException {
        
        //请求的地址
        String url = "http://localhost:8080/request/ContentType";
        
        //①创建Http Request(内部使用HttpURLConnection)
        ClientHttpRequest request = 
            new SimpleClientHttpRequestFactory().   
                createRequest(new URI(url), HttpMethod.POST);
        //②设置请求头的内容类型头和内容编码（UTF-8）
        request.getHeaders().set("Content-Type", "application/json;charset=utf-8");
        //③以GBK编码写出响应内容体
        String jsonData = "{\"username\":\"zhang\", \"password\":\"123\"}";
        request.getBody().write(jsonData.getBytes("utf-8"));
        
        //④发送请求并得到响应
        ClientHttpResponse response = request.execute();
        System.out.println(response);
        System.out.println(response.getStatusCode());
    }
}
