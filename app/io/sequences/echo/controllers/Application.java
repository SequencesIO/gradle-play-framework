package io.sequences.echo.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;

import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

public class Application extends Controller {

    // Health Check API
    public Result healthHandler() {

        ObjectNode result = Json.newObject();

        result.put("name", "echo");
        result.put("status", "OK");
        result.put("version", "1.0");

        return Results.ok(result);
    }

    public Result readyStatusHandler() {

        return Results.ok();
    }

    @BodyParser.Of(BodyParser.Raw.class)
    public Result echoHandler() throws Exception {

        // Get request document
        String requestText = new String(request().body().asRaw().asBytes().toArray(), "UTF-8");

        ObjectNode responseNode = Json.mapper().createObjectNode();
        responseNode.put("input", requestText);

        String response = Json.mapper().writeValueAsString(responseNode);
        return Results.ok(response);
    }
}
