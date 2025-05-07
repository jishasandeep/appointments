package com.jb.appointments.config;

import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "spring.application")
@Validated
public record AppProperties (
    @NotBlank String prefix){


}
