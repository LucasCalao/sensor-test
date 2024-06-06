package eu.arrowhead.application.skeleton.provider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.arrowhead.application.skeleton.provider.model.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    // Métodos personalizados de consulta, se necessário
}