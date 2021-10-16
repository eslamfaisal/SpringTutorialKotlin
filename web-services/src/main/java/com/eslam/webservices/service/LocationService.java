package com.eslam.webservices.service;


import com.eslam.webservices.entity.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocationService {
    List<Location> retrieveLocations();
}
