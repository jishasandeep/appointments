package com.jb.appointments.config;

import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;


@Validated
public record AppProperties (
        @NotBlank String user, @NotBlank String password){


}
