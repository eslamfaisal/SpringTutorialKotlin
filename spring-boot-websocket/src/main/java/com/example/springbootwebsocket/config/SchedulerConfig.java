package com.example.springbootwebsocket.config;

import com.example.springbootwebsocket.model.UserResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulerConfig {

    // from beans
    final SimpMessagingTemplate template;

    public SchedulerConfig(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Scheduled(fixedDelay = 5000)
    public void sendAdhocMessage() {
        template.convertAndSend("topic/user", new UserResponse("Scheduler"));
    }

}
