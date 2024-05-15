package kremelv.RestSensorApp.services;

import kremelv.RestSensorApp.models.Measurement;
import kremelv.RestSensorApp.repository.MeasurementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    private final SensorService sensorService;



    public MeasurementService(MeasurementRepository measurementRepository, SensorService sensorService) {
        this.measurementRepository = measurementRepository;
        this.sensorService = sensorService;
    }

    @Transactional
    public void save (Measurement measurement) {
        enrichMesuremet(measurement);
        measurementRepository.save(measurement);
    }

    @Transactional
    public List<Measurement> findAll(){
        return measurementRepository.findAll();
    }

    private void enrichMesuremet(Measurement measurement) {
        measurement.setSensor(sensorService.findByName(measurement.getSensor().getName()).get());
        measurement.setCreated_at(LocalDateTime.now());
    }


}
