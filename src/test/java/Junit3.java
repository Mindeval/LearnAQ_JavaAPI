import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Junit3 {
    @ParameterizedTest
    @ValueSource(strings = {"", "John", "Pete"})
    public  void junitTestHelloWithoutName(String name) {
        Map<String,String> queryParams = new HashMap<>();
        if (name.length() > 0){
            queryParams.put("name", name);
        }
        JsonPath response = RestAssured
                .given()
                .queryParams(queryParams)
                .get("https://playground.learnqa.ru/api/hello")
                .jsonPath();
        String answer = response.getString("answer");
        String expectedName = (name.length()>0) ? name: "someone2";
        assertEquals("Hello, "+expectedName, answer, "The answer is not expected");
    }

}
