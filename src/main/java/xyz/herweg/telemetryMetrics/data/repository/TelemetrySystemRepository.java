package xyz.herweg.telemetryMetrics.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.herweg.telemetryMetrics.data.entity.TelemetrySystem;

import java.util.UUID;

public interface TelemetrySystemRepository extends JpaRepository<TelemetrySystem, UUID> {
}