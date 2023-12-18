package Lib;

import com.sun.source.tree.AssertTree;
import io.restassured.response.Response;
import io.restassured.http.Headers;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseTestCase {
    protected String getHeader(Response Response, String name){
        Headers headers = Response.getHeaders();
        assertTrue(headers.hasHeaderWithName(name), "Response doesn't have header with name " + name);
        return headers.getValue(name);
    }
    protected String getCookie (Response Response, String name){
        Map<String,String> cookies = Response.getCookies();
        assertTrue(cookies.containsKey(name), "Response doesn't have cookie with name " + name);
        return cookies.get(name);

    }
}
