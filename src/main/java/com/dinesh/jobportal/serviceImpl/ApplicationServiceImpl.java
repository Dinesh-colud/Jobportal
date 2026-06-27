package com.dinesh.jobportal.serviceImpl;

import com.dinesh.jobportal.dto.ApplicationRequest;
import com.dinesh.jobportal.dto.ApplicationResponse;
import com.dinesh.jobportal.entity.Application;
import com.dinesh.jobportal.entity.Job;
import com.dinesh.jobportal.entity.User;
import com.dinesh.jobportal.exception.ResourceNotFoundException;
import com.dinesh.jobportal.repositories.ApplicationRepository;
import com.dinesh.jobportal.repositories.JobRepository;
import com.dinesh.jobportal.repositories.UserRepository;
import com.dinesh.jobportal.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobRepository jobRepository;

    @Override
    public ApplicationResponse createApp(ApplicationRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Job job = jobRepository.findById(request.getJobId())
                .orElseThrow(() -> new RuntimeException("Job not found"));

        Application application = new Application();

        application.setStatus(request.getStatus());
        application.setAppliedAt(LocalDateTime.now());

        application.setUser(user);
        application.setJob(job);

        Application savedApplication = applicationRepository.save(application);

        ApplicationResponse response = new ApplicationResponse();

        response.setId(savedApplication.getId());
        response.setStatus(savedApplication.getStatus());
        response.setAppliedAt(savedApplication.getAppliedAt());

        response.setUserId(user.getId());
        response.setUserName(user.getName());

        response.setJobId(job.getId());
        response.setJobTitle(job.getTitle());
        response.setCompany(job.getCompany());

        return response;
    }

    @Override
    public List<ApplicationResponse> getAllApp() {

        List<Application> applications = applicationRepository.findAll();

        return applications.stream()
                .map(application -> {
                    ApplicationResponse response = new ApplicationResponse();
                    response.setId(application.getId());
                    response.setStatus(application.getStatus());
                    response.setAppliedAt(application.getAppliedAt());

                    response.setUserId(application.getUser().getId());
                    response.setUserName(application.getUser().getName());

                    response.setJobId(application.getJob().getId());
                    response.setJobTitle(application.getJob().getTitle());
                    response.setCompany(application.getJob().getCompany());

                    return response;
                }).toList();
    }

    @Override
    public ApplicationResponse getAppById(Long id) {

        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found with id: "+id));

        ApplicationResponse response = new ApplicationResponse();
        response.setId(application.getId());
        response.setStatus(application.getStatus());
        response.setAppliedAt(application.getAppliedAt());

        response.setUserId(application.getUser().getId());
        response.setUserName(application.getUser().getName());

        response.setJobId(application.getJob().getId());
        response.setJobTitle(application.getJob().getTitle());
        response.setCompany(application.getJob().getCompany());

        return response;
    }

    @Override
    public ApplicationResponse updateApp(ApplicationRequest request, Long id) {

        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Application not found with id: "+id));

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"+request.getUserId()));

        Job job = jobRepository.findById(request.getJobId())
                .orElseThrow(() -> new ResourceNotFoundException("Job not found"+request.getJobId()));

        application.setStatus(request.getStatus());

        application.setUser(user);
        application.setJob(job);

        Application updatedApplication = applicationRepository.save(application);

        ApplicationResponse response = new ApplicationResponse();

        response.setId(updatedApplication.getId());
        response.setStatus(updatedApplication.getStatus());
        response.setAppliedAt(updatedApplication.getAppliedAt());

        response.setUserId(updatedApplication.getUser().getId());
        response.setUserName(updatedApplication.getUser().getName());

        response.setJobId(updatedApplication.getJob().getId());
        response.setJobTitle(updatedApplication.getJob().getTitle());
        response.setCompany(updatedApplication.getJob().getCompany());


        return response;
    }

    @Override
    public void deleteApp(Long id) {

        Application application = applicationRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Application not found with id: "+id));

        applicationRepository.deleteById(id);
    }


}
