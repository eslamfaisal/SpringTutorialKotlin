package com.eslam.webservices.service;

import com.eslam.webservices.entity.Location;
import com.eslam.webservices.reposatory.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    final
    LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> retrieveLocations() {
        return (List<Location>) locationRepository.findAll();
    }

    @Override
    public Location retrieveLocationsById(Long id) {

        Optional<Location> location = locationRepository.findById(id);
        return location.get();
    }
}
