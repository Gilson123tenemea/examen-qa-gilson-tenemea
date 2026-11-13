package com.demoblaze.utils;

import com.demoblaze.models.DatosCompra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class LectorCsv {

    private static final String RUTA = "data/compradores.csv";

    public static DatosCompra compradorPorCaso(String caso) {
        try (BufferedReader lector = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(LectorCsv.class.getClassLoader().getResourceAsStream(RUTA)),
                StandardCharsets.UTF_8))) {
            return lector.lines()
                    .skip(1)
                    .map(linea -> linea.split(","))
                    .filter(c -> c[0].trim().equals(caso))
                    .findFirst()
                    .map(c -> new DatosCompra(c[1].trim(), c[2].trim(), c[3].trim(),
                            c[4].trim(), c[5].trim(), c[6].trim()))
                    .orElseThrow(() -> new IllegalArgumentException(
                            "No existe el caso '" + caso + "' en " + RUTA));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private LectorCsv() {
    }
}