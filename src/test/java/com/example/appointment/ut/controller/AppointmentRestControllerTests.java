package com.example.appointment.ut.controller;

import com.example.appointment.controller.AppointmentRestController;
import com.example.appointment.service.AppointmentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(AppointmentRestController.class)
public class AppointmentRestControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private AppointmentRestController appointmentRestController;

    @MockBean
    private AppointmentService appointmentService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(appointmentRestController).build();
    }

    @Test
    public void whenFindById_thenOneObjectIsReturned() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/appointments/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void whenFindByAll_thenAllObjectsAreReturned() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/appointments/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void whenDeleteById_thenStatusOk() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/api/v1/appointments/1"))
                .andExpect(status().isOk());
    }
}
