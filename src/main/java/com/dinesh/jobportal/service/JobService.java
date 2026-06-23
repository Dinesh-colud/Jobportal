package com.dinesh.jobportal.service;

import com.dinesh.jobportal.entity.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {

    Job createJob(Job job);

    List<Job> getAllJobs();

    Job getJobById(Long id);

    Job updateJobById(Job job, Long id);

    void deleteJobById(Long id);


}
