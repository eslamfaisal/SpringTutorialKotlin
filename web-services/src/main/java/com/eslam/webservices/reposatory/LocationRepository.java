package com.eslam.webservices.reposatory;


import com.eslam.webservices.entity.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
}
