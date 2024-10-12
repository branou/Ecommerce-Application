package dev.himbra.orderservice;

import dev.himbra.orderservice.dto.OrderRequest;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.math.BigDecimal;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceApplicationTests {
    @LocalServerPort
    private Integer port;

    @ServiceConnection
    static PostgreSQLContainer postgreSQLContainer=new PostgreSQLContainer("postgres");
    @BeforeEach
    public void SetUp(){
        RestAssured.port=port;
    }
    static {
        postgreSQLContainer.start();
    }
    @Test
    void shouldPlaceAnOrder() {
        OrderRequest order=new OrderRequest(1,"123Y3",new BigDecimal("2000"),2);
        RestAssured.given()
                .contentType("application/json")
                .body(order)
                .log().all()  // Log the request
                .when()
                .post("/api/order/placeOrder")
                .then()
                .log().all()  // Log the response
                .statusCode(201)
                .body("id", Matchers.equalTo(1))
                .body("orderNumber", Matchers.equalTo("123Y3"));

    }

}
