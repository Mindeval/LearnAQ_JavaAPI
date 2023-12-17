import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Junit2 {
    @Test
    public  void junitTestHelloWithoutName() {
        JsonPath response = RestAssured
                .get("https://playground.learnqa.ru/api/hello")
                .jsonPath();
        String answer = response.getString("answer");
        assertEquals("Hello, someone", answer, "The answer is not expected");
    }

    @Test
    public  void junitTestHelloWithName() {
        String name = "Username";
        JsonPath response = RestAssured
                .given()
                .queryParam("name", name)
                .get("https://playground.learnqa.ru/api/hello")
                .jsonPath();
        String answer = response.getString("answer");
        assertEquals("Hello, " + name, answer, "The answer is not expected");
    }





   //     Response response= RestAssured
      //          .get("https://playground.learnqa.ru/api/map")
      //          .andReturn();
        //   assertTrue(response.statusCode()==200, "Fail, status not 200"); // Проверка что статус 200, иначе вывод текста ошибки
       // assertEquals(210, response.statusCode(),"Fail, status not 200"); // более понятный вывод, ожидаемый, фактический, сообщение при ошибке
   // }
}
