package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lib.Assertions;
import lib.BaseTestCase;
import lib.DataGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import lib.ApiCoreRequests;

import java.util.HashMap;
import java.util.Map;


@Epic("User register cases")
@Feature("Register")
public class UserRegisterTest extends BaseTestCase {

    private final ApiCoreRequests apiCoreRequests = new ApiCoreRequests();

    @Test
    public void testCreateUserWithExistingEmail(){     //Создание пользователя с уже существующим email
        String email = "vinkotov@example.com";
        Map<String,String> userData = new HashMap<>();
        userData.put("email",email);
        userData = DataGenerator.getRegistrationData(userData);

        Response responseCreateAuth = apiCoreRequests
                .makePostRegistrationRequest("https://playground.learnqa.ru/api/user/", userData);

        Assertions.assertResponseCodeEquals(responseCreateAuth, 400);
        Assertions.assertResponseTextEquals(responseCreateAuth, "Users with email '" + email + "' already exists");
    }

    @Test
    public void testCreateUserSuccsessfully(){   //Создание пользователя с уникальными данными
        Map<String,String> userData = DataGenerator.getRegistrationData();

        Response responseCreateAuth = apiCoreRequests
                .makePostRegistrationRequest("https://playground.learnqa.ru/api/user/", userData);

        Assertions.assertResponseCodeEquals(responseCreateAuth, 200);
        Assertions.assertJsonHasField(responseCreateAuth, "id");
    }

    @Test
    @Description("Testing the rejection of registration with an invalid email")
    @DisplayName("Test negative registration with an invalid email")
    public void testCreateUserIncorrectEmail(){   //Создание пользователя с некорректным email без @
        Map<String,String> email = new HashMap<>();
        email.put("email", DataGenerator.getIncorrectEmail());
        Map<String,String> userData = DataGenerator.getRegistrationData(email); //передаем сгенерированный без @ мэйл

        Response responseCreateAuth = apiCoreRequests
                .makePostRegistrationRequest("https://playground.learnqa.ru/api/user/", userData);

        Assertions.assertResponseCodeEquals(responseCreateAuth, 400);
        Assertions.assertResponseTextEquals(responseCreateAuth, "Invalid email format");
    }

    @Description("Testing registration rejection in the absence of required fields")
    @DisplayName("Test negative registration without required fields")
    @ParameterizedTest
    @ValueSource(strings = {"username", "firstName", "lastName", "email", "password"})
    public void testCreateUserWithoutRequiredField(String missingField){   //Создание пользователя с незаполненными обязательными полями
        Map<String,String> userData = DataGenerator.getRegistrationData();
        userData.remove(missingField);  //удаляем одно из полей

        Response responseCreateAuth = apiCoreRequests
                .makePostRegistrationRequest("https://playground.learnqa.ru/api/user/", userData);

           Assertions.assertResponseCodeEquals(responseCreateAuth, 400);
        }

    @Test
    @Description("Testing registration with userName length 1 char")
    @DisplayName("Test positive registration with userName length 1 char")
    public void testCreateUserShortName(){   //Создание пользователя с именем в 1 символ
        Map<String,String> userData = DataGenerator.getRegistrationData();
        String str = RandomStringUtils.randomAlphabetic(1);  //генерация строки 1 символ
        userData.replace("firstName", str); // замена имени на сгенерированную строку

        Response responseCreateAuth = apiCoreRequests
                .makePostRegistrationRequest("https://playground.learnqa.ru/api/user/", userData);

        Assertions.assertResponseCodeEquals(responseCreateAuth, 200);
    }

    @Test
    @Description("Testing registration with userName length 255 char")
    @DisplayName("Test positive registration with userName length 255 char")
    public void testCreateUserLongName(){   //Создание пользователя с именем в 255 символов
        Map<String,String> userData = DataGenerator.getRegistrationData();
        String str = RandomStringUtils.randomAlphabetic(255);  //генерация строки 255 символов
        userData.replace("firstName", str); // замена имени на сгенерированную строку

        Response responseCreateAuth = apiCoreRequests
                .makePostRegistrationRequest("https://playground.learnqa.ru/api/user/", userData);

        Assertions.assertResponseCodeEquals(responseCreateAuth, 200);
    }







}
