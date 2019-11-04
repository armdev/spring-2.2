/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import io.project.app.domain.EventMessage;
import io.project.app.domain.Notification;
import io.project.app.repositories.NotificationRepository;
import io.vavr.control.Try;
import java.util.Date;
import java.util.Optional;
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

    public Optional<Notification> continuePost(Notification notification) {
        Optional<Notification> savedEvent = notificationRepository.findById(notification.getId());
        if (savedEvent.isPresent()) {
            log.info("Found stored object");
            EventMessage eventMessage = new EventMessage();
            eventMessage.setServerName("server2");
            eventMessage.setTimestamp(new Date(System.currentTimeMillis()).getTime());
            savedEvent.get().getEventMessage().add(eventMessage);
            Notification savedRecord = notificationRepository.save(savedEvent.get());
            return Optional.ofNullable(savedRecord);
        }

        return Optional.empty();

        //this.postDate(savedEvent.get());
    }

    public void postDate(Notification notification) {

        HttpEntity<Notification> request = new HttpEntity<>(notification);
        String url = this.nextServer() + "api/v2/server2/two";

        Try<ResponseEntity<String>> serverResponse = Try.of(() -> restTemplate.postForObject(url, request, ResponseEntity.class));

        if (serverResponse.isSuccess()) {
            log.info("Server1: Success sent data");
        }

        if (!serverResponse.isSuccess()) {
            log.error("Server1: Success sent data");
        }

    }

    private String nextServer() {

        InstanceInfo instance = discoveryClient.getNextServerFromEureka("server3", false);

        return instance.getHomePageUrl();

    }

}
