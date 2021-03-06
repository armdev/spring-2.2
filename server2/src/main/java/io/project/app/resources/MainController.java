package io.project.app.resources;

import io.project.app.api.responses.ApiResponseMessage;
import io.project.app.domain.Notification;
import io.project.app.services.NotificationService;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author armena
 */
@RestController
@RequestMapping("/api/v2/server2")
@Slf4j
public class MainController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping(path = "/two", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<?> start(@RequestBody Notification notification) {
        
        Optional<Notification> continuePost = notificationService.continuePost(notification);
        if (continuePost.isPresent()) {
            log.info("Received request from server 1");
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseMessage("ReceivedData"));
        }

        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ApiResponseMessage("Error response"));
    }

}
