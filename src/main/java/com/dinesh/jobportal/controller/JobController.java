package com.dinesh.jobportal.controller;

import com.dinesh.jobportal.dto.JobRequest;
import com.dinesh.jobportal.dto.JobResponse;
import com.dinesh.jobportal.entity.Job;
import com.dinesh.jobportal.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JobController {

      @Autowired
      private JobService jobService;

    @PostMapping("/jobs")
    public ResponseEntity<JobResponse> createJob(@Valid @RequestBody JobRequest request){
        JobResponse create =  jobService.createJob(request);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<JobResponse>> getAllJobs(){
        List<JobResponse> getAll = jobService.getAllJobs();
        return new ResponseEntity<>(getAll, HttpStatus.OK);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<JobResponse> getJobById(@PathVariable Long id) {
        JobResponse job = jobService.getJobById(id);
        return ResponseEntity.ok(job);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<JobResponse> updateJob(@RequestBody JobRequest request,
                                         @PathVariable Long id){
        JobResponse update = jobService.updateJobById(request, id);

        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
         jobService.deleteJobById(id);
        return ResponseEntity.ok("Job deleted successfully!");
    }

}
