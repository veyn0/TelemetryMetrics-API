package xyz.herweg.telemetryMetrics.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.herweg.telemetryMetrics.data.entity.TelemetryServiceCategory;

import java.util.UUID;

public interface TelemetryServiceCategoryRepository extends JpaRepository<TelemetryServiceCategory, UUID> {
}