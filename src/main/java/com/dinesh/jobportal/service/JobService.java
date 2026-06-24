package com.dinesh.jobportal.service;

import com.dinesh.jobportal.entity.Job;

import java.util.List;

public interface JobService {

    Job createJob(Job job);

    List<Job> getAllJobs();

    Job getJobById(Long id);

    Job updateJobById(Job job, Long id);

    void deleteJobById(Long id);


}
