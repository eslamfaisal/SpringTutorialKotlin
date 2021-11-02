package com.eslam.webservices.service

import com.eslam.webservices.entity.Location
import com.eslam.webservices.reposatory.LocationRepository
import com.eslam.webservices.service.LocationService
import org.springframework.stereotype.Service

@Service
class LocationServiceImpl(private val locationRepository: LocationRepository) : LocationService {
    override fun retrieveLocations(): List<Location> {
        return locationRepository.findAll() as List<Location>
    }

    override fun retrieveLocationsById(id: Long): Location {
        val location = locationRepository.findById(id)
        val save = locationRepository.save(location.get())
        return location.get()
    }
}