package io.project.app.resources;

import io.project.app.api.responses.ApiResponseMessage;
import io.project.app.services.NotificationService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author armena
 */
@RestController
@RequestMapping("/api/v2/server")
@Slf4j
public class MainController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping(path = "/one", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<?> start() {
        notificationService.gen();
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseMessage("RequestDone"));
    }

}
