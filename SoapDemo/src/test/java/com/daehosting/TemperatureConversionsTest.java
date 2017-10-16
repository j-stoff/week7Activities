package com.daehosting;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TemperatureConversionsTest {
    private TemperatureConversionsSoapType service;
    @Before
    public void init() {
        service = new TemperatureConversions().getTemperatureConversionsSoap12();
    }

    @Test
    public void getTemperatureConversionsSoap12() throws Exception {
        BigDecimal answer = service.celsiusToFahrenheit(BigDecimal.valueOf(5.0));

        assertEquals("Celsius to coversion failed", BigDecimal.valueOf(41), answer);
    }

    @Test
    public void calculateWindChill() throws Exception {
        BigDecimal answer = service.windChillInCelsius(BigDecimal.valueOf(5), BigDecimal.valueOf(7.0));

        assertEquals("Not the value calculated by the SOAPUI", BigDecimal.valueOf(-0.5689), answer);
    }

    @Test
    public void calculateFahrenheitToCelsius()  throws Exception {
        BigDecimal answer = service.fahrenheitToCelsius(BigDecimal.valueOf(100));

        assertEquals("Not the value calculated by the SOAPUI", BigDecimal.valueOf(37.77777775), answer);
    }
}