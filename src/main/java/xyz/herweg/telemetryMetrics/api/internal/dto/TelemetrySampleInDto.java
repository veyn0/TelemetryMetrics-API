package xyz.herweg.telemetryMetrics.api.internal.dto;

import java.time.Instant;

public record TelemetrySampleInDto (Instant timestamp, double value) {}