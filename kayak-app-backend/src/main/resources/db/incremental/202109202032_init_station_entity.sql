--liquibase formatted sql
--changeset mkowalewski:202109202032_init_station_entity.sql

CREATE TABLE public.measuring_stations (
    id BIGINT NOT NULL,
    api_id VARCHAR(255) NOT NULL,
    station_external_id BIGINT NOT NULL,
    station_name VARCHAR(255) NOT NULL,
    river_name VARCHAR(255) NOT NULL
);

CREATE SEQUENCE public.measuring_stations_s INCREMENT 1 START 1;
