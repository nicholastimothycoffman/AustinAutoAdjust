// Provides basic CRUD (Create, Read, Update, Delete) operations for the `TrafficData`
// entity using Spring Data JPA.
//
// The `CrudRepository` interface provides methods such as `save()`, `findById()`,
// `findAll()`, `deleteById()`, etc., to interact with the database.
// 
// `TrafficData` is the entity class, and `Long` is the type of the entity's primary key.

package github.com.nicholastimothycoffman.AustinAutoAdjust.trafficdata;

import org.springframework.data.repository.CrudRepository;

// Extends CrudRepository to provide basic database operations for TrafficData
public interface TrafficDataRepository extends CrudRepository<TrafficData, Long> {
}

