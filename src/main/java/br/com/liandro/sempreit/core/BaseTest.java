package br.com.liandro.sempreit.core;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class BaseTest implements IData {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = APP_BASE_URL;
        RestAssured.port = APP_PORT;
        RestAssured.basePath = APP_BASE_PATH;
    }

}
