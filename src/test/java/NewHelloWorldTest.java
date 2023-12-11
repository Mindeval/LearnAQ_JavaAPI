import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


public class NewHelloWorldTest {
    @Test
    public void testRestAssured(){
        Map<String,Object> body = new HashMap();
        body.put ("param1", "value123");
        body.put ("param2", "value222");
        Response response = RestAssured
                .given()
                .body(body)
                .post("https://playground.learnqa.ru/api/check_type")
                .andReturn();

        response.print();


    }
}
