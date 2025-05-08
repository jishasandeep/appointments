package com.jb.appointments.service;

import com.jb.appointments.model.Appointment;
import com.jb.appointments.repository.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppointmentServiceTest {

    private final AppointmentRepository appointmentRepository = Mockito.mock(AppointmentRepository.class);
    private final AppointmentService appointmentService = new AppointmentService(appointmentRepository);


    @Test
    void testAppointmentService() {

        Appointment appointment1 = new Appointment();
        appointment1.setId(1L);
        Appointment appointment2 = new Appointment();
        appointment2.setId(2L);

        Mockito.when(appointmentRepository.findAll()).thenReturn(List.of(appointment1,appointment2));
        List<Appointment> all = appointmentService.findAll();
        assertEquals(2,all.size());
    }
}