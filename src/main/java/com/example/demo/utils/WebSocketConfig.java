package com.example.demo.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
//@EnableWebSocketMessageBroker用于配置Web套接字消息代理以创建STOMP端点
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// TODO Auto-generated method stub
		registry.addEndpoint("/yiibai-websocket")// 注册一个STOMP的endpoint
				.setAllowedOrigins("*")  // 允许跨域
				.withSockJS();//指定使用SockJS协议
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// TODO 配置一个/topic代理
		registry.enableSimpleBroker("/topic");
		registry.setApplicationDestinationPrefixes("/app");
	}

}
