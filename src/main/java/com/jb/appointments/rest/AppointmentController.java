package com.jb.appointments.rest;

import com.jb.appointments.model.Appointment;
import com.jb.appointments.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@Tag(name="Appointment Service Apis", description = "Operation related to appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    @GetMapping
    @Operation(summary = "get all appointments", description = "Fetch all available appointments from db")
    @ApiResponse(responseCode = "200", description = "Found the records")
    @ApiResponse(responseCode = "404", description = "Records not found")
    @Cacheable("appointments")
    public List<Appointment> getAllAppointments() {
        System.out.println("executing getAllAppointments!");
        return appointmentService.findAll();
    }

    @GetMapping("/{id}")
    @Cacheable(value = "appointments", key = "#p0")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") Long id) {
        System.out.println("executing getAppointmentById!");
        if (id == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null");
        }
        return appointmentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @CachePut("appointments")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.save(appointment);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "appointments", key = "#p0")
    public ResponseEntity<Void> deleteAppointment(@PathVariable("id") Long id) {
        appointmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}