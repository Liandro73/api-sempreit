package br.com.liandro.sempreit.rest.testes;

import br.com.liandro.sempreit.core.BaseTest;

import io.restassured.path.json.JsonPath;

import org.json.JSONObject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Weather extends BaseTest {

    JsonPath forecast = given().get().getBody().jsonPath();

    @Test
    public void CasoTeste001() {

        JSONObject forecastArray = new JSONObject(given().get().getBody().asString());

        assertEquals(forecastArray.toString().toLowerCase().contains("description"), true);
        assertEquals(forecastArray.toString().toLowerCase().contains("max"), true);

        int size = Integer.parseInt(forecast.getString("results.forecast.size()"));
        for(int index = 0; index != size; index++) {
            int max = Integer.parseInt(forecast.getString("results.forecast["+ index +"].max"));
            assertTrue(max > 0);
        }

        when()
                .get()
            .then()
                .statusCode(200)
        ;

    }

    @Test
    public void CasoTeste002() {

        int size = Integer.parseInt(forecast.getString("results.forecast.size()"));
        for(int index = 0; index != size; index++) {
            String date = forecast.getString("results.forecast["+ index +"].date");
            String weather = forecast.getString("results.forecast["+ index +"].description");
            System.out.println("Date: " + date + " | the weather will be: " + weather);
            assertEquals(10, size);
        }

        when()
                .get()
            .then()
                .statusCode(200)
        ;

    }

}
