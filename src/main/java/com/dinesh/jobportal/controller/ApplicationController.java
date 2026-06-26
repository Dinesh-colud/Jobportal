package com.dinesh.jobportal.controller;

import com.dinesh.jobportal.entity.Application;
import com.dinesh.jobportal.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/application")
    public ResponseEntity<Application> createApplication(@Valid @RequestBody
                                                         Application application){
        Application app1 = applicationService.createApp(application);
        return new ResponseEntity<>(app1, HttpStatus.CREATED);
    }

    @GetMapping("/application")
    public ResponseEntity<List<Application>> getAllApplication(){
        List<Application> applications = applicationService.getAllApp();

        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @GetMapping("/application/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable
                                                          Long id){
        Application application = applicationService.getAppById(id);
        return new ResponseEntity<>(application, HttpStatus.OK);
    }

    @PutMapping("/application/{id}")
    public ResponseEntity<Application> updateApplication(@RequestBody Application application,
                                                         @PathVariable Long id){
        Application application1 = applicationService.updateApp(application, id);

        return new ResponseEntity<>(application1, HttpStatus.OK);
    }

    @DeleteMapping("/application/{id}")
    public ResponseEntity<String> deleteApplicationById(@PathVariable Long id){
        applicationService.deleteApp(id);
        return ResponseEntity.ok("Application deleted successfully!");
    }
}
