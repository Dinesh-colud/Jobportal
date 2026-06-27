package com.dinesh.jobportal.service;

import com.dinesh.jobportal.dto.ApplicationRequest;
import com.dinesh.jobportal.dto.ApplicationResponse;
import com.dinesh.jobportal.entity.Application;

import java.util.List;

public interface ApplicationService {

    ApplicationResponse createApp(ApplicationRequest request);

    List<ApplicationResponse> getAllApp();

    ApplicationResponse getAppById(Long id);

    ApplicationResponse updateApp(ApplicationRequest request, Long id);


    void deleteApp(Long id);
}
