package com.liu.club.gateway.exception;

import cn.dev33.satoken.exception.SaTokenException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liu.club.gateway.entity.Result;
import lombok.val;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Global Exception Handling for Gateway
 *
 * @author: Liu Tongxun
 * @date: 2025/07/27
 */
@Component
public class GatewayExceptionHandler implements ErrorWebExceptionHandler {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {
        ServerHttpRequest request = serverWebExchange.getRequest();
        ServerHttpResponse response = serverWebExchange.getResponse();
        Integer code = 200;
        String message = "";
        if (throwable instanceof SaTokenException) {
            code = 401;
            message = "用户无权限";
            throwable.printStackTrace();
        } else {
            code = 500;
            message = "系统繁忙";
            throwable.printStackTrace();
        }
        Result result = Result.fail(code, message);
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
//
//        byte[] valueAsBytes = null;
//        try {
//            valueAsBytes = objectMapper.writeValueAsBytes(result);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        DataBuffer dataBuffer = response.bufferFactory().wrap(valueAsBytes);
//        return response.writeWith(Mono.just(dataBuffer));


        return response.writeWith(Mono.fromSupplier(() -> {
            DataBufferFactory dataBufferFactory = response.bufferFactory();
            byte[] bytes = null;
            try {
                bytes = objectMapper.writeValueAsBytes(result);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return dataBufferFactory.wrap(bytes);
        }));
    }
}
