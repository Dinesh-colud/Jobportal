package com.dinesh.jobportal.serviceImpl;

import com.dinesh.jobportal.entity.Application;
import com.dinesh.jobportal.repositories.ApplicationRepository;
import com.dinesh.jobportal.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public Application createApp(Application application) {
        return applicationRepository.save(application);
    }
}
