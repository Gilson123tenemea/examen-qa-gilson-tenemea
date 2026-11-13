package com.demoblaze.api;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Codificador {

    public static String aBase64(String texto) {
        return Base64.getEncoder().encodeToString(texto.getBytes(StandardCharsets.UTF_8));
    }

    private Codificador() {
    }
}