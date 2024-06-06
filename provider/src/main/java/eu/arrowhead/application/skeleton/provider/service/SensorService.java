package eu.arrowhead.application.skeleton.provider.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.arrowhead.application.skeleton.provider.model.Sensor;
import eu.arrowhead.application.skeleton.provider.repository.SensorRepository;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;
    
    public Sensor createSensor(Sensor sensor) {
        return sensorRepository.save(sensor);
    }
    
    public Sensor updateSensor(Long id, Sensor sensorDetails) {
        if (sensorRepository.existsById(id)) {
            sensorDetails.setId(id);
            return sensorRepository.save(sensorDetails);
        }
        return null;
    }
   
    public void deleteSensor(Long id) {
        sensorRepository.deleteById(id);
    }
   
    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    public Optional<Sensor> getSensorById(Long id) {
        return sensorRepository.findById(id);
    }    
}