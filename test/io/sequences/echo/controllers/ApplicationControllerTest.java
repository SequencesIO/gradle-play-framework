package io.sequences.echo.controllers;

import static org.junit.Assert.assertEquals;
import static play.mvc.Http.Status.OK;

import org.junit.Test;

import play.mvc.Result;

public class ApplicationControllerTest {

    @Test
    public void testHealth() {

        Application app = new Application();
        final Result result = app.healthHandler();
        assertEquals(OK, result.status());
    }
}
