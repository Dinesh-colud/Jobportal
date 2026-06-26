package com.dinesh.jobportal.serviceImpl;

import com.dinesh.jobportal.entity.Application;
import com.dinesh.jobportal.entity.Job;
import com.dinesh.jobportal.entity.User;
import com.dinesh.jobportal.repositories.ApplicationRepository;
import com.dinesh.jobportal.repositories.JobRepository;
import com.dinesh.jobportal.repositories.UserRepository;
import com.dinesh.jobportal.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Application createApp(Application application) {

        User user = userRepository.findById(application.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Job job = jobRepository.findById(application.getUser().getId())
                .orElseThrow(() -> new RuntimeException("Job not found"));

        application.setUser(user);
        application.setJob(job);

        return applicationRepository.save(application);
    }

    @Override
    public List<Application> getAllApp() {
        return applicationRepository.findAll();
    }

    @Override
    public Application getAppById(Long id) {

        return applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found with id: "+id));
    }

    @Override
    public Application updateApp(Application application, Long id) {

        Application app = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found with id: "+id));

        User user = userRepository.findById(application.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Job job = jobRepository.findById(application.getJob().getId())
                .orElseThrow(() -> new RuntimeException("Job not found"));

        app.setStatus(application.getStatus());
        app.setAppliedAt(application.getAppliedAt());
        app.setUser(user);
        app.setJob(job);

        return applicationRepository.save(app);
    }

    @Override
    public void deleteApp(Long id) {

        Application application = applicationRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Application not found with id: "+id));

        applicationRepository.deleteById(id);
    }


}
