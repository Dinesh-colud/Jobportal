package com.dinesh.jobportal.service;

import com.dinesh.jobportal.entity.Application;

import java.util.List;

public interface ApplicationService {

    Application createApp(Application application);

    List<Application> getAllApp();

    Application getAppById(Long id);

    Application updateApp(Application application, Long id);


    void deleteApp(Long id);
}
