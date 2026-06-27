package com.dinesh.jobportal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequest {

    @NotBlank(message = "Status is required")
    private String status;

    @NotNull(message = "User id is required")
    private Long userId;

    @NotNull(message = "Job id is required")
    private Long jobId;

}
