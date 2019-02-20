package com.example.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Greeting;
import com.example.demo.model.HelloMessage;

@Controller
public class GreetingController {
	
	//当浏览器向服务端发送请求时,通过@MessageMapping映射/hello这个地址,类似于@ResponseMapping
	@MessageMapping("/hello")
	//当服务器有消息时,会对订阅了@SendTo中的路径的浏览器发送消息
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws InterruptedException {
		Thread.sleep(1000);
		return new Greeting("Hello, " + message.getName() + " !");
	}
	
}
