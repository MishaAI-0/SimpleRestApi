package kremelv.RestSensorApp.services;

import kremelv.RestSensorApp.models.Sensor;
import kremelv.RestSensorApp.repository.SensorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SensorService {
    private final SensorRepository sensorRepository;

    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Transactional
    public void saveSensor(Sensor sensor) {
        sensorRepository.save(sensor);
    }

    @Transactional
    public Optional<Sensor> findByName(String name) {
        return sensorRepository.findByName(name);
    }

    @Transactional
    public boolean existByName(String name) {
        return sensorRepository.existsByName(name);
    }

}
