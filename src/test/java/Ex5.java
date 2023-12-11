import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;



public class Ex5 {
    @Test
    public void testRestAssured(){

        JsonPath response = RestAssured

                .get("https://playground.learnqa.ru/api/get_json_homework")

                .jsonPath();

        ArrayList messages = response.get("messages");

//        System.out.println(messages.get(0));
        System.out.println(messages.get(1));
//        System.out.println(messages.get(2));
    }

}
