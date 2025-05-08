package com.jb.appointments.repository;

import com.jb.appointments.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}

