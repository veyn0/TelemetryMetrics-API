> [!CAUTION]
> This project is **not intended for public or production deployments**.
> It currently has no authentication on admin and public endpoints.
> See [Development Status](#development-status) for details.

# Telemetry Metrics

A Spring Boot backend service for collecting time-series telemetry data and serving configurable status pages.

## Overview

This project provides a REST API for ingesting metric samples from services and exposing them through customizable status pages. Samples are organized by services, which belong to systems and categories. Status pages are built from layouts, widgets, and graphs, backed by raw or composed datasources.

## Features

- **Sample ingestion** – Internal endpoint (API key protected) for writing metric samples in bulk
- **Admin API** – CRUD endpoints for managing systems, categories, services, status pages, widgets, graphs, datasources, layouts and tooltips
- **Public API** – Read-only endpoints for listing status pages and fetching their layout and time-series data
- **Datasource composition** – Datasources can be `RAW` (backed by a single service) or `COMPOSED` (aggregating multiple services via `ADD` or `AVERAGE`)
- **Adaptive downsampling** – Data responses are limited to a maximum number of points using linear interpolation over a uniform timeline

## Tech Stack

- Java / Spring Boot
- Spring Data JPA (Hibernate)
- MariaDB

## Project Structure

```
api/admin      – Admin CRUD controllers and service layer
api/internal   – Sample ingestion endpoint
api/pub        – Public read-only endpoints for status pages and data
data/entity    – JPA entities
data/repository – Spring Data repositories
data/dto       – Request and response records
```

## Configuration

Configure the datasource and the internal API key in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mariadb://host:3306/telemetry_metrics
spring.datasource.username=...
spring.datasource.password=...

telemetry.internal.api-key=...
```

The internal ingestion endpoint expects the configured key in the `X-Api-Key` header.

CORS is currently configured to allow requests from `http://localhost:5173` for the `/api/**` paths.

## Development Status

Early development. The API surface is functional but still evolving. **There is currently no authentication or authorization on the admin or public endpoints**. only the internal sample ingestion endpoint is protected by a shared API key. Do not expose this service to untrusted networks in its current state.

The internal API key is currently shared across all ingesting services and configured statically via application properties. This is a temporary solution; per-service credentials and a proper authentication mechanism are planned.
