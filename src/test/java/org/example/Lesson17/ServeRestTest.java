package org.example.Lesson17;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServeRestTest {

    private static final String BASE_URI = "https://serverest.dev/";
    private static String userId;
    private static String uniqueEmail;
    private static String token;

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = BASE_URI;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    @Order(1)
    void shouldGetAllUsers() {
        given()
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .contentType(containsString("application/json"))
                .body("quantidade", greaterThan(0))
                .body("usuarios", not(empty()));
    }

    @Test
    @Order(2)
    void shouldFindUserByEmail() {
        String firstUserEmail = given()
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .contentType(containsString("application/json"))
                .extract()
                .path("usuarios[0].email");

        given()
                .queryParam("email", firstUserEmail)
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .body("quantidade", equalTo(1))
                .body("usuarios[0].email", equalTo(firstUserEmail));
    }

    @Test
    @Order(3)
    void shouldCreateNewUser() {
        uniqueEmail = "spy_HOMER" + System.currentTimeMillis() + "@qa.com";
        String requestBody = """
                {
                    "nome": "Тайный Покупатель",
                    "email": "%s",
                    "password": "secret123",
                    "administrador": "true"
                }
                """.formatted(uniqueEmail);

        userId = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/usuarios")
                .then()
                .statusCode(201)
                .body("message", equalTo("Cadastro realizado com sucesso"))
                .extract().path("_id");
    }

    @Test
    @Order(4)
    void shouldUpdateUser() {
        String requestBody = """
                {
                    "nome": "Обновлённый Покупатель",
                    "email": "%s",
                    "password": "secret123",
                    "administrador": "false"
                }
                """.formatted(uniqueEmail);
        given()
                .contentType(ContentType.JSON)
                .pathParam("id", userId)
                .body(requestBody)
                .when()
                .put("/usuarios/{id}")
                .then()
                .statusCode(200)
                .body("message", equalTo("Registro alterado com sucesso"));
    }

    @Test
    @Order(5)
    void shouldLogin() {
        String requestBody = """
                {
                    "email": "%s",
                    "password": "secret123"
                }
                """.formatted(uniqueEmail);
        token = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .body("message", equalTo("Login realizado com sucesso"))
                .body("authorization", notNullValue())
                .extract()
                .path("authorization");
    }

    @Test
    @Order(6)
    void shouldDeleteUser() {
        given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .when()
                .delete("/usuarios/" + userId)
                .then()
                .statusCode(200)
                .body("message", equalTo("Registro excluído com sucesso"));

        given()
                .when()
                .contentType(ContentType.JSON)
                .get("/usuarios/" + userId)
                .then()
                .statusCode(400)
                .body("message", equalTo("Usuário não encontrado"));
    }

    @Test
    @Order(7)
    void shouldGetAllProducts(){
        given()
                .when()
                .get("/produtos")
                .then()
                .statusCode(200)
                .body("quantidade", greaterThan(0))
                .body("produtos.preco", everyItem(greaterThan(0)))
                .body("produtos.nome", everyItem(allOf(notNullValue(), not(emptyOrNullString()))))
                .body("produtos.nome", hasItem("Logitech MX Vertical"));
    }

    @Test
    @Order(8)
    void shouldCreateNewUserFromDto(){
        uniqueEmail = "spy_HOMER" + System.currentTimeMillis() + "@qa.com";
        Usuario userDto = new Usuario(
                "Тайный Покупатель",
                uniqueEmail,
                "secret123",
                "true"
        );

        userId = given()
                .contentType(ContentType.JSON)
                .body(userDto) // Просто передаем объект сюда! Rest Assured сам сделает из него JSON
                .when()
                .post("/usuarios")
                .then()
                .statusCode(201)
                .body("message", equalTo("Cadastro realizado com sucesso"))
                .extract().path("_id");
    }
}
