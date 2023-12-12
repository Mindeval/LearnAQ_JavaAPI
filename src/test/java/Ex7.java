import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


public class Ex7 {
    @Test
    public void testRestAssured(){
        String URL = "https://playground.learnqa.ru/api/long_redirect";
        int count = 0;
        int responseCode = 0;
        String lastURL;
        do {
            Response response = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .when()
                    .get(URL)
                    .andReturn();
            String location = response.getHeader("Location");
            lastURL = URL;
            if (location != null){

                URL = location;
                count = count + 1;

            }
            else {
                URL = "null";
                responseCode = response.getStatusCode();
            }
        }
        while (!URL.equals("null"));
        System.out.println(responseCode);
        System.out.println("Конечный URL:"+ lastURL);
        System.out.println("Количество редиректов: "+ count);
        }
}
