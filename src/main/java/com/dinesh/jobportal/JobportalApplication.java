package com.dinesh.jobportal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobportalApplication {

    private static final Logger log = LoggerFactory.getLogger(JobportalApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JobportalApplication.class, args);
        log.info("Jobportal application started successfully");
	}

}
