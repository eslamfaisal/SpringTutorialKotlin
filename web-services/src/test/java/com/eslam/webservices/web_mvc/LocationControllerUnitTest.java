package com.eslam.webservices.web_mvc;

import com.eslam.webservices.service.LocationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LocationController.class)
@WithMockUser(username = "admin", password = "password", roles = "USER")
class LocationControllerUnitTest {

    @MockBean
    LocationService locationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllLocations() throws Exception {
        mockMvc.perform(get("/location/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(locationService, times(1)).retrieveLocations();
    }

    @Test
    void getAllLocationById() throws Exception {
        mockMvc.perform(get("/location/1"))
                .andExpect(status().isOk());

        verify(locationService, times(1)).retrieveLocationsById(1L);
    }
}