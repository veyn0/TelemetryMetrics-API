package xyz.herweg.telemetryMetrics.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.herweg.telemetryMetrics.data.entity.TelemetryService;

import java.util.List;
import java.util.UUID;

public interface TelemetryServiceRepository extends JpaRepository<TelemetryService, UUID> {

    List<TelemetryService> findAllBySystemId(UUID systemId);

    List<TelemetryService> findAllByCategoryId(UUID categoryId);
}