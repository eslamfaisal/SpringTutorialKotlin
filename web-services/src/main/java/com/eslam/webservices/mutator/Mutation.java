package com.eslam.webservices.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.eslam.webservices.entity.Location;
import com.eslam.webservices.exception.LocationNotFoundException;
import com.eslam.webservices.reposatory.LocationRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    final
    LocationRepository locationRepository;

    public Mutation(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location newLocation(String name, String address) {
        Location location = new Location(name, address);
        locationRepository.save(location);
        return location;
    }

    public boolean deleteLocation(Long id) {
        try {
            locationRepository.deleteById(id);
            return true;
        } catch (Exception ignored) {
            throw new LocationNotFoundException("Location not found", id);
        }

    }

    public Location updateLocationName(String name, Long id) {
        Optional<Location> optionalLocation = locationRepository.findById(id);
        if (optionalLocation.isPresent()) {
            Location location = optionalLocation.get();
            location.setName(name);
            locationRepository.save(location);
            return location;
        } else {
            throw new LocationNotFoundException("Location not found", id);
        }
    }
}
