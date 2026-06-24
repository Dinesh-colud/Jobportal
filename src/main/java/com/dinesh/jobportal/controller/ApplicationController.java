package com.dinesh.jobportal.controller;

import com.dinesh.jobportal.entity.Application;
import com.dinesh.jobportal.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/application")
    public ResponseEntity<Application> createApplication(@RequestBody
                                                         Application application){
        Application app1 = applicationService.createApp(application);

        return new ResponseEntity<>(app1, HttpStatus.OK);
    }



}
