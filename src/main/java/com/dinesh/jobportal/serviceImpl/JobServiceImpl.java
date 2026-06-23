package com.dinesh.jobportal.serviceImpl;

import com.dinesh.jobportal.entity.Job;
import com.dinesh.jobportal.repositories.JobRepository;
import com.dinesh.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Job createJob(Job job) {

        return jobRepository.save(job);
    }

    @Override
    public List<Job> getAllJobs() {

        return jobRepository.findAll();
    }

    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id: "+id));
    }

    @Override
    public Job updateJobById(Job job, Long id) {

        Job job1 = jobRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Job not found with id: "+id));

        job1.setTitle(job.getTitle());
        job1.setDescription(job.getDescription());
        job1.setCompany(job.getCompany());
        job1.setLocation(job.getLocation());
        job1.setSalary(job.getSalary());
        job1.setCreatedAt(job.getCreatedAt());

        return jobRepository.save(job1);
    }

    @Override
    public void deleteJobById(Long id) {

        Job job = jobRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Jon not found with id: "+id));

        jobRepository.deleteById(id);
    }


}
