package tests;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex10 {
    @Test
    public  void LengthTest(){
        String Url = "https://playground.learnqa.ru/ajax/api/longtime_job";
        JsonPath getTask = RestAssured
                .get(Url)
                .jsonPath();

        String token = getTask.get("token");
        assertTrue(token.length()>15, "Token length <= 15");
    }
}
