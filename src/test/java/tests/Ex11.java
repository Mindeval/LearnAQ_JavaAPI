package tests;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Ex11 {
    @Test
    public  void CookieTest(){
        String Url = "https://playground.learnqa.ru/api/homework_cookie";
        Response getCookie = RestAssured
                .get(Url)
                .andReturn();

        Map<String,String> cookies = getCookie.getCookies();
        String cookieValue = cookies.get("HomeWork");

        assertTrue(cookies.containsKey("HomeWork"), "Cookie is not valid");
        assertTrue("hw_value".equals(cookieValue), "Cookie value is not valid");

        //System.out.println(cookies);
        //System.out.println(cookieValue);

    }
}
