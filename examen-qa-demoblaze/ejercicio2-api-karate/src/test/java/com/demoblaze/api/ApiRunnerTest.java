package com.demoblaze.api;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApiRunnerTest {

    @Test
    void ejecutarPruebasApi() {
        Results resultados = Runner.path("classpath:features")
                .outputCucumberJson(true)
                .parallel(1);
        assertEquals(0, resultados.getFailCount(), resultados.getErrorMessages());
    }
}