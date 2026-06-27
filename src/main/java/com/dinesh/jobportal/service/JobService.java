package com.dinesh.jobportal.service;

import com.dinesh.jobportal.dto.JobRequest;
import com.dinesh.jobportal.dto.JobResponse;
import com.dinesh.jobportal.entity.Job;

import java.util.List;

public interface JobService {

    JobResponse createJob(JobRequest request);

    List<JobResponse> getAllJobs();

    JobResponse getJobById(Long id);

    JobResponse updateJobById(JobRequest request, Long id);

    void deleteJobById(Long id);


}
