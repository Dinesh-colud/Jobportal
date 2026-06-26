package com.dinesh.jobportal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "title is required")
    private String title;

    @NotBlank(message = "description is required")
    private String description;

    @NotBlank(message = "company is required")
    private String company;

    @NotBlank(message = "location is required")
    private String location;

    @NotNull(message = "salary is required")
    @Positive(message = "salary must be greater than 0")
    private Double salary;

    @NotNull(message = "Created date is required")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "job")
    @JsonIgnore
    private List<Application> applications;

}
