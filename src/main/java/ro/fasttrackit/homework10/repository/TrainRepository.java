package ro.fasttrackit.homework10.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.fasttrackit.homework10.model.entity.Train;

public interface TrainRepository extends MongoRepository<Train, String> {
}
