package ro.fasttrackit.homework10.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.homework10.model.entity.Location;

public interface LocationRepository extends MongoRepository<Location, String> {
}
