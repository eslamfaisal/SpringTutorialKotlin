package com.eslam.webservices.integration_test;

import com.eslam.webservices.entity.Location;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LocationControllerIntegrationTest {

    @LocalServerPort
    private int port;

//    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() {
        restTemplate = new TestRestTemplate("admin",
                "password", TestRestTemplate.HttpClientOption.ENABLE_COOKIES);
    }

    @Test
    public void getAllLocations() {
        ResponseEntity<List> response =
                this.restTemplate.getForEntity("http://localhost:" + port + "/location/", List.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getLocation() {
        ResponseEntity<Location> response =
                this.restTemplate.getForEntity("http://localhost:" + port + "/location/1", Location.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.INTERNAL_SERVER_ERROR));
    }
}