package xyz.herweg.telemetryMetrics.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class TelemetrySystem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    protected TelemetrySystem() {
    }

    public UUID getId() {
        return id;
    }
}