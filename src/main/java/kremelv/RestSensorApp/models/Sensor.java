package kremelv.RestSensorApp.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id")
    private int id;

    @Column(name = "sensor_name")
    @Size(min = 2, max = 30, message = "Length of name should be 2 between 30 characters")
    @NotEmpty(message = "Name can not be empty")
    private String name;

    @Size(min = 2, max = 30, message = "Length of location should be 2 between 30 characters")
    @NotEmpty(message = "Location can not be empty")
    @Column(name = "location")
    private String location;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sensor")
    private List<Measurement> measurements;

    public Sensor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
