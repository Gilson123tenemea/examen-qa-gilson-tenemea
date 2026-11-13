package com.demoblaze.models;

public record DatosCompra(
        String nombre,
        String pais,
        String ciudad,
        String tarjeta,
        String mes,
        String anio) {
}