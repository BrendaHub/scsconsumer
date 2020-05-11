package com.loiter.scs.scsconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class ScsconsumerApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ScsconsumerApplication.class, args);
		new SpringApplicationBuilder(ScsconsumerApplication.class)
				.web(WebApplicationType.NONE).run(args);
	}

	// 1、 integration是采用的MessageHandler 来订阅 MessageChannel的消息
	// 1.1、 使用StreamListener 来订阅消息（现在scs体系里）

	@StreamListener("input")
	public void receive(String msg) {
		System.out.println(String.format("receive mesage is %s", msg));
	}
}
