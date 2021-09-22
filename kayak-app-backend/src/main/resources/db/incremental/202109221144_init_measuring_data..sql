--liquibase formatted sql
--changeset mkowalewski:202109202032_init_stations.sql

CREATE TABLE public.measuring_data (
    id BIGINT NOT NULL,
    station_id BIGINT NOT NULL,
    water_level BIGINT NOT NULL,
    measuring_time timestamp with time zone NOT NULL
);

CREATE SEQUENCE public.measuring_data_s INCREMENT 1 START 1;