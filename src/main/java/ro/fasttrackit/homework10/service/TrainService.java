package ro.fasttrackit.homework10.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.homework10.exception.ValidationException;
import ro.fasttrackit.homework10.model.TrainFilters;
import ro.fasttrackit.homework10.model.entity.Train;
import ro.fasttrackit.homework10.repository.TrainDao;
import ro.fasttrackit.homework10.repository.TrainRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainService {
    private final TrainRepository trainRepository;
    private final TrainValidator validator;
    private final TrainDao trainDao;

    public Train addTrain(Train train) {
        validator.validateLocationThrow(train.getLocationId());
        return trainRepository.save(train);
    }

    public void deleteTrain(String trainId) {
        trainRepository.deleteById(trainId);
    }

    public Train updateTrain(String trainId, Train newTrain) {
        newTrain.setTrainId(trainId);
        validator.validateReplaceThrow(trainId, newTrain);

        Train dbTrain = trainRepository.findById(trainId)
                .orElseThrow(() -> new ValidationException("Couldn't find train with id " + trainId));
        copyTrain(newTrain, dbTrain);
        return trainRepository.save(dbTrain);
    }

    public List<Train> getAllByFilters(TrainFilters filters) {
        return trainDao.getAll(filters);
    }

    private void copyTrain(Train newTrain, Train dbTrain) {
        dbTrain.setCarts(newTrain.getCarts());
        dbTrain.setModel(newTrain.getModel());
        dbTrain.setLocationId(newTrain.getLocationId());
    }
}
