/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import io.project.app.api.responses.ApiResponseMessage;
import io.project.app.domain.EventMessage;
import io.project.app.domain.Notification;
import io.project.app.repositories.NotificationRepository;
import io.vavr.control.Try;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author armena
 */
@Slf4j
@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private EurekaClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;

    public void gen() {
        Notification notification = new Notification();
        EventMessage eventMessage = new EventMessage();
        eventMessage.setServerName("server1");
        eventMessage.setTimestamp(new Date(System.currentTimeMillis()).getTime());
        notification.getEventMessage().add(eventMessage);
        Notification savedRecord = notificationRepository.save(notification);
        this.postDate(notification);
    }

    public void postDate(Notification notification) {

        HttpEntity<Notification> request = new HttpEntity<>(notification);
        
        final String url = this.nextServer() + "api/v2/server2/two";

        Try<ApiResponseMessage> serverResponse = Try.of(() -> restTemplate.postForObject(url, request, ApiResponseMessage.class));

        if (serverResponse.isSuccess()) {
            log.info("Server1: isSuccess");
            log.info("Status code ");

        }

        if (serverResponse.isAsync()) {
            log.error("Server1: isAsync");
             

        }

        if (serverResponse.isEmpty()) {
            log.error("Server1: isEmpty");
            

        }

        if (serverResponse.isFailure()) {
            log.error("Server1: isFailure");            
        }

    }

    private String nextServer() {

        InstanceInfo instance = discoveryClient.getNextServerFromEureka("server2", false);

        return instance.getHomePageUrl();

    }

}
