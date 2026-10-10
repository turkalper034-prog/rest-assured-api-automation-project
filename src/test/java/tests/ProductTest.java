package tests;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import base.BaseTest;
public class ProductTest extends BaseTest{
    @Test
    public void getAllProducts(){
        given()
                .when()
                .get("/products")
                .then()
                .statusCode(200)
                .body("products[0].id",equalTo(1))
                .body("products[0].title",equalTo("Essence Mascara Lash Princess"))
                .body("products[0].price",equalTo(9.99F))
                .body("products[0].stock",equalTo(99));
        System.out.println("PASS - Status Code doğru: 200");
        System.out.println("PASS - Ürün ID doğru: 1");
        System.out.println("PASS - Ürün başlığı doğru");
        System.out.println("PASS - Fiyat doğru: 9.99");
        System.out.println("PASS - Stok doğru: 99");
    }
    @Test
    public void getAllProductsCount(){
        given()
                .when()
                .get("/products")
                .then()
                .body("products.size()", greaterThan(0));
    }
    @Test
    public void getSingleProducts(){
        given()
                .when()
                .get("/products/1")
                .then()
                .statusCode(200)
                .body("id",equalTo(1));
    }
    @Test
    public void SearchProducts(){
        given()
                .queryParam("q","phone")
                .when()
                .get("/products/search")
                .then()
                .statusCode(200)
                .body("products.size()",greaterThan(0));
    }
    @Test
    public void createProduct(){
        Map<String,Object> product = new HashMap<>();
        product.put("title","QA Test Product");
        product.put("price",1000);
        given()
                .body(product)
                .when()
                .post("/products/add")
                .then()
                .log().body()
                .statusCode(201)
                .body("id",greaterThan(0));
    }

    @Test
    public void updateProduct(){
        given()

                .pathParam("id", 1)
                .contentType("application/json")
                .body("""
                    {
                        "price": "500"
                    }
                    """)
                .when()
                .put("/products/{id}")
                .then()
                .log().body()
                .statusCode(200)
                .body("price",equalTo("500"));

    }
    @Test
    public void deleteProduct(){
        given()
                .pathParam("id",1)
                .when()
                .delete("/products/{id}")
                .then()
                .statusCode(200)
                .log().body();


    }@Test
    public void  getNonExistingProduct(){
        given()
                .expect()
                .statusCode(404)
                .when()
                .get("/products/9999");
    }

}


