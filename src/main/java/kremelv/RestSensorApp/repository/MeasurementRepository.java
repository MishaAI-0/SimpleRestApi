package kremelv.RestSensorApp.repository;

import kremelv.RestSensorApp.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository  extends JpaRepository<Measurement,Integer> {
}
