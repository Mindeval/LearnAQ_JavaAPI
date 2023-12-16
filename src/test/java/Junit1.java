import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Junit1 {
    @Test
    public  void junitTest1(){
        Response response= RestAssured
                .get("https://playground.learnqa.ru/api/map")
                .andReturn();
        //   assertTrue(response.statusCode()==200, "Fail, status not 200"); // Проверка что статус 200, иначе вывод текста ошибки
        assertEquals(210, response.statusCode(),"Fail, status not 200"); // более понятный вывод, ожидаемый, фактический, сообщение при ошибке
    }
}
