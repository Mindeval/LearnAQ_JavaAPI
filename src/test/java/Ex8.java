import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import java.lang.Thread;
public class Ex8 {
    @Test
    public void firstTest() {
        String URL = "https://playground.learnqa.ru/ajax/api/longtime_job";


        JsonPath getTask = RestAssured.get(URL).jsonPath(); //Получение задачи
        String token = getTask.get("token");
        int second = getTask.get("seconds");


        JsonPath getTaskStatus = RestAssured // Получение статуса задачи до её выполнения
                .given()
                .queryParams("token", token)
                .get(URL).jsonPath();
        String error = getTaskStatus.get("error");
        String status = getTaskStatus.get("status");
        String result = getTaskStatus.get("result");

       if ("Job is NOT ready".equals(status)) {
            System.out.println("Статус задачи до таймера: " +status);
        }
       else {
           System.out.println("Статус задачи \"" +status +"\"отличается от ожидаемого");
       }

       if (result != null) {
            System.out.println(result);
        }

        if (error != null) {
            System.out.println("Ошибка:" +error);
        }

        System.out.println("Ожидаем выполение задачи: " +second+"сек");
        try {
            Thread.sleep(second * 1000); // Ожидание выполнения задачи
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        JsonPath getTaskFinalStatus = RestAssured // Получение статуса задачи до её выполнения
                .given()
                .queryParams("token", token)
                .get(URL).jsonPath();
        error = getTaskFinalStatus.get("error");
        status = getTaskFinalStatus.get("status");
        result = getTaskFinalStatus.get("result");

        if ("Job is ready".equals(status)) {
            System.out.println("Статус задачи после таймера: "+ status);
        }
        else {
            System.out.println("Статус задачи \"" +status +"\"отличается от ожидаемого");
        }

        if (result != null) {
            System.out.println("Результат: "+ result);
        }
        else {
            System.out.println("Результат отсутствует");
        }

        if (error != null) {
            System.out.println("Ошибка: "+ error);
        }
    }

}
