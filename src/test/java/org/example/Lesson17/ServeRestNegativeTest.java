package org.example.Lesson17;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ServeRestNegativeTest {

    private static final String BASE_URI = "https://serverest.dev/";

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void shouldRejectCreateProductWithInvalidToken() {
        given()
                .header("Authorization", "invalid_or_expired_token")
                .contentType(ContentType.JSON)
                .body("{\"nome\": \"Produto Negativo\", \"preco\": 100, \"descricao\": \"Teste\", \"quantidade\": 1}")
                .when()
                .post("/produtos")
                .then()
                .statusCode(401)
                .body("message", equalTo("Token de acesso ausente, inválido, expirado ou usuário do token não existe mais"));
    }
}
