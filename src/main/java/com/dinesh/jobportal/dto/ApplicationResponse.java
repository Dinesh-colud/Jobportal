package com.dinesh.jobportal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationResponse {

    private Long id;
    private String status;
    private LocalDateTime appliedAt;

    private Long userId;
    private String userName;

    private Long jobId;
    private String jobTitle;
    private String company;

}
