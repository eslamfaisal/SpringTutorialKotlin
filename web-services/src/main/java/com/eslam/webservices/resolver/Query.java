package com.eslam.webservices.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.eslam.webservices.entity.Location;
import com.eslam.webservices.reposatory.LocationRepository;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    public final LocationRepository locationRepository;

    public Query(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    public Iterable<Location> findAllLocations() {
        return locationRepository.findAll();
    }
}
