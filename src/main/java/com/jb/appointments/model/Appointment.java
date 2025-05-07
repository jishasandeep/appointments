package com.jb.appointments.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "appointments")
public class Appointment {
    @Id
    private String id;
    private String title;
    private String description;
    private LocalDateTime dateTime;
    @Value("spring.application.prefix")
    private String appPrefix;
}

