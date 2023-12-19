package tests;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex12 {
    @Test
    public  void HeaderTest(){
        String Url = "https://playground.learnqa.ru/api/homework_header";
        Response testHeader = RestAssured
                .get(Url)
                .andReturn();
        Headers headers = testHeader.getHeaders();
        String secret = headers.getValue("x-secret-homework-header");

        assertTrue(headers.hasHeaderWithName("x-secret-homework-header"),"Response doesn't have 'x-secret-homework-header");
        assertTrue("Some secret value".equals(secret), "Secret is not valid");
    }
}
