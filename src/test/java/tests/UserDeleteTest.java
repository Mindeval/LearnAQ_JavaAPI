package tests;

import io.qameta.allure.*;

import io.restassured.response.Response;
import lib.ApiCoreRequests;
import lib.Assertions;
import lib.BaseTestCase;
import lib.DataGenerator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@Epic("User delete cases")
@Feature("DeleteUser")
@Story("Delete")
public class UserDeleteTest extends BaseTestCase {

    private final ApiCoreRequests apiCoreRequests = new ApiCoreRequests();

    String cookie;
    String header;
    int userIdOnAuth;

    @Test
    @Description("test of delete user with id=2")
    @DisplayName("Test positive reject delete user with id=2")
    @TmsLink ("123")
    @Link ("www.google.com")
    @Owner ("Mindeval")
    @Severity(value = SeverityLevel.CRITICAL)
    public void loginUser(){
        Map<String,String> authData = new HashMap<>();
        authData.put("email", "vinkotov@example.com");
        authData.put("password", "1234");

        Response responseGetAuth = apiCoreRequests
                .makePostRequest("https://playground.learnqa.ru/api/user/login", authData);

        this.cookie = this.getCookie(responseGetAuth, "auth_sid");
        this.header = this.getHeader(responseGetAuth, "x-csrf-token");
        this.userIdOnAuth = this.getIntFromJson(responseGetAuth, "user_id");

        Response responseDelUser2 = apiCoreRequests
                .makeDeleteUserWithAuth("https://playground.learnqa.ru/api/user/" +userIdOnAuth, this.header, this.cookie);

        Assertions.assertResponseCodeEquals(responseDelUser2, 400);
        Assertions.assertResponseTextEquals(responseDelUser2, "Please, do not delete test users with ID 1, 2, 3, 4 or 5.");
    }

    @Test
    @Description("test of delete user with auth")
    @DisplayName("Test positive delete user with auth")
    public void testDeleteNewUser(){   //Создание пользователя с уникальными данными и его удаление
        //GENERATE USER
        Map<String,String> userData = DataGenerator.getRegistrationData();
        Response responseCreateAuth = apiCoreRequests
                .makePostRequest("https://playground.learnqa.ru/api/user/", userData);
        this.userIdOnAuth = this.getIntFromJson(responseCreateAuth,"id");

        //Login USER
        Map<String,String> authData = new HashMap<>();
        authData.put("email", userData.get("email"));
        authData.put("password", userData.get("password"));
        Response responseGetAuth = apiCoreRequests
                .makePostRequest("https://playground.learnqa.ru/api/user/login", authData);
        this.cookie = this.getCookie(responseGetAuth, "auth_sid");
        this.header = this.getHeader(responseGetAuth, "x-csrf-token");

        //Dellete User
        Response responseDelUser2 = apiCoreRequests
                .makeDeleteUserWithAuth("https://playground.learnqa.ru/api/user/" +userIdOnAuth, header, cookie);
        //Get Deleted user info
        Response responseGetDeletedUser = apiCoreRequests
                .makeGetRequestWithoutAuth("https://playground.learnqa.ru/api/user/" +userIdOnAuth);

        Assertions.assertResponseCodeEquals(responseGetDeletedUser, 404);
        Assertions.assertResponseTextEquals(responseGetDeletedUser, "User not found");
    }

    @Test
    @Description("test of delete user with auth another user")
    @DisplayName("Test negative delete user with auth another user")
    @Flaky
    public void testDeleteAnotherUser(){
        //GENERATE USER 1
        Map<String,String> userData1 = DataGenerator.getRegistrationData();
        Response responseCreateAuth = apiCoreRequests
                .makePostRequest("https://playground.learnqa.ru/api/user/", userData1);
        this.userIdOnAuth = this.getIntFromJson(responseCreateAuth,"id");

        //GENERATE USER 2
        Map<String,String> userData2 = DataGenerator.getRegistrationData();
        Response responseCreateAuth2 = apiCoreRequests
                .makePostRequest("https://playground.learnqa.ru/api/user/", userData2);

        //Login USER 2
        Map<String,String> authData2 = new HashMap<>();
        authData2.put("email", userData2.get("email"));
        authData2.put("password", userData2.get("password"));
        Response responseGetAuth = apiCoreRequests
                .makePostRequest("https://playground.learnqa.ru/api/user/login", authData2);
        this.cookie = this.getCookie(responseGetAuth, "auth_sid");
        this.header = this.getHeader(responseGetAuth, "x-csrf-token");

        //Delete User1 Auth with User 2
        Response responseDelUser1 = apiCoreRequests
                .makeDeleteUserWithAuth("https://playground.learnqa.ru/api/user/" +userIdOnAuth, header, cookie);
        Assertions.assertResponseCodeEquals(responseDelUser1, 400);
        //Check User 1 info
        Response responseGetDeletedUser = apiCoreRequests
                .makeGetRequestWithoutAuth("https://playground.learnqa.ru/api/user/" +userIdOnAuth);
        Assertions.asserJsonByName(responseGetDeletedUser, "username", "learnqa");
    }
}
