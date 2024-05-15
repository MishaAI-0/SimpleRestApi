package kremelv.RestSensorApp.util;

import kremelv.RestSensorApp.dto.MeasurementDTO;


import java.util.List;

public class MeasurementsResponse {

    private List<MeasurementDTO> measurementList;

    public MeasurementsResponse() {
    }

    public List<MeasurementDTO> getMeasurementList() {
        return measurementList;
    }

    public void setMeasurementList(List<MeasurementDTO> measurementList) {
        this.measurementList = measurementList;
    }
}
