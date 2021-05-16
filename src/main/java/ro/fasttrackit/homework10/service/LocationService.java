package ro.fasttrackit.homework10.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.homework10.model.entity.Location;
import ro.fasttrackit.homework10.repository.LocationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }

    public void deleteLocation(String locationId) {
        locationRepository.deleteById(locationId);
    }
}
