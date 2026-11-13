package com.demoblaze.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EsperarHasta implements Interaction {

    private final ExpectedCondition<?> condicion;

    public EsperarHasta(ExpectedCondition<?> condicion) {
        this.condicion = condicion;
    }

    public static EsperarHasta que(ExpectedCondition<?> condicion) {
        return new EsperarHasta(condicion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(condicion);
    }
}