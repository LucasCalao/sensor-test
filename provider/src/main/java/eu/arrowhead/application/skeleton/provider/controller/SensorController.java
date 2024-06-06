package eu.arrowhead.application.skeleton.provider.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import eu.arrowhead.application.skeleton.provider.model.Sensor;
import eu.arrowhead.application.skeleton.provider.service.SensorService;



@RestController
@RequestMapping("/sensors")
public class SensorController {
    
    private final SensorService sensorService;

    @Autowired
    public  SensorController(SensorService sensorService){
        this.sensorService = sensorService;
    }

    @PostMapping("/create")
    public ResponseEntity<Sensor> createSensor(@Valid @RequestBody Sensor sensor) {
        Sensor sensorCreated = sensorService.createSensor(sensor);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(sensorCreated.getId())
                            .toUri();
        return ResponseEntity.created(location).body(sensorCreated);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<Sensor>> getSensors() {
        List<Sensor> sensors = sensorService.getAllSensors();
        return ResponseEntity.ok(sensors);
    }

    @GetMapping(value= "/find/{id}")
    public ResponseEntity<Sensor> getSensorById(@PathVariable Long id) {
        return sensorService.getSensorById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value= "/update/{id}")
    public ResponseEntity<Sensor> updateSensor(@PathVariable("id") Long id, @RequestBody Sensor sensorDetails) {
        Sensor updatedSensor = sensorService.updateSensor(id, sensorDetails);

        if (updatedSensor != null) {
            return ResponseEntity.ok(updatedSensor);  // Sensor foi atualizado com sucesso
        } else {
            return ResponseEntity.notFound().build();  // Sensor com o ID fornecido não foi encontrado
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSensor(@PathVariable Long id) {
        if (sensorService.getSensorById(id).isPresent()) {
            sensorService.deleteSensor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}