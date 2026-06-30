package com.dinesh.jobportal.controller;

import com.dinesh.jobportal.dto.ApplicationRequest;
import com.dinesh.jobportal.dto.ApplicationResponse;
import com.dinesh.jobportal.entity.Application;
import com.dinesh.jobportal.service.ApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    @Tag(name = "Applications APIs", description = "APIs related to job applications")
    @Operation(description = "Create Application", summary = "APIs to create an application")
    public ResponseEntity<ApplicationResponse> createApplication(@Valid @RequestBody
                                                                 ApplicationRequest request){
        ApplicationResponse app1 = applicationService.createApp(request);
        return new ResponseEntity<>(app1, HttpStatus.CREATED);
    }

    @GetMapping("/application")
    @Tag(name = "Applications APIs", description = "APIs related to job applications")
    @Operation(description = "Get all Applications", summary = "APIs to get all applications")
    public ResponseEntity<List<ApplicationResponse>> getAllApplication(){
        List<ApplicationResponse> applications = applicationService.getAllApp();

        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @GetMapping("/application/{id}")
    @Tag(name = "Applications APIs", description = "APIs related to job applications")
    @Operation(description = "Get Application By Id", summary = "APIs to get an application by id")
    public ResponseEntity<ApplicationResponse> getApplicationById(@PathVariable
                                                          Long id){
        ApplicationResponse application = applicationService.getAppById(id);
        return new ResponseEntity<>(application, HttpStatus.OK);
    }

    @PutMapping("/application/{id}")
    @Tag(name = "Applications APIs", description = "APIs related to job applications")
    @Operation(description = "Update Application", summary = "APIs to update an application")
    public ResponseEntity<ApplicationResponse> updateApplication(@RequestBody ApplicationRequest request,
                                                         @PathVariable Long id){
        ApplicationResponse application1 = applicationService.updateApp(request, id);

        return new ResponseEntity<>(application1, HttpStatus.OK);
    }

    @DeleteMapping("/application/{id}")
    @Tag(name = "Applications APIs", description = "APIs related to job applications")
    @Operation(description = "Delete Application", summary = "APIs to delete an application")
    public ResponseEntity<String> deleteApplicationById(@PathVariable Long id){
        applicationService.deleteApp(id);
        return ResponseEntity.ok("Application deleted successfully!");
    }
}
