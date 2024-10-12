package dev.himbra.productservice;

import dev.himbra.productservice.model.Product;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {
    @ServiceConnection
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo");

    @LocalServerPort
    private Integer port;

    static {
        mongoDBContainer.start();
    }
    @BeforeEach
    void setUp(){
        RestAssured.port=port;
    }
    @Test
    void shouldCreateProduct() {
        Product product = new Product("1","Samsung","an amazing phone",2000);

        RestAssured.given()
                .contentType("application/json")
                .body(product)
                .when()
                .post("/api/product/create")
                .then()
                .statusCode(201)
                .body("name", Matchers.equalTo("Samsung"))
                .body("price", Matchers.equalTo(2000.0F));

    }
    @Test
    void shouldReturnAllProducts(){
        RestAssured.given()
                .contentType("application/json")
                .when()
                .get("api/product/products")
                .then()
                .statusCode(200)
                .body(Matchers.equalTo(""));
    }


}
