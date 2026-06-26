package com.dinesh.jobportal.controller;

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
    public ResponseEntity<Job> createJob(@Valid @RequestBody Job job){
        Job create =  jobService.createJob(job);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> getAllJobs(){
        List<Job> getAll = jobService.getAllJobs();
        return new ResponseEntity<>(getAll, HttpStatus.OK);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        return ResponseEntity.ok(job);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<Job> updateJob(@RequestBody Job job,
                                         @PathVariable Long id){
        Job update = jobService.updateJobById(job, id);

        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
         jobService.deleteJobById(id);
        return ResponseEntity.ok("Job deleted successfully!");
    }

}
