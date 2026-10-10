package base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

import java.util.Locale;

public class BaseTest {

    @BeforeEach
    public void setUp() {
        Locale.setDefault(Locale.ENGLISH);
        RestAssured.baseURI = "https://dummyjson.com";
    }
}