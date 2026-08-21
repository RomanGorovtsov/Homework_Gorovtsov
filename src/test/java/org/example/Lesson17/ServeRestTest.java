package org.example.Lesson17;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ServeRestTest {

    private static final String BASE_URI = "https://serverest.dev";
    private static final String PASSWORD = "secret123";

    private static final String MSG_USER_CREATED = "Cadastro realizado com sucesso";
    private static final String MSG_USER_UPDATED = "Registro alterado com sucesso";
    private static final String MSG_LOGIN_SUCCESS = "Login realizado com sucesso";
    private static final String MSG_USER_DELETED = "Registro excluído com sucesso";
    private static final String MSG_USER_NOT_FOUND = "Usuário não encontrado";

    private static RequestSpecification baseSpec;

    private static String userId;
    private static String uniqueEmail;
    private static String token;

    @BeforeAll
    static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        baseSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    @Test
    @Order(1)
    void shouldGetAllUsers() {
        given()
                .spec(baseSpec)
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
                .spec(baseSpec)
                .when()
                .get("/usuarios")
                .then()
                .statusCode(200)
                .contentType(containsString("application/json"))
                .extract()
                .path("usuarios[0].email");

        given()
                .spec(baseSpec)
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
        uniqueEmail = generateUniqueEmail();

        userId = given()
                .spec(baseSpec)
                .body(usuarioJson("Тайный Покупатель", uniqueEmail, "true"))
                .when()
                .post("/usuarios")
                .then()
                .statusCode(201)
                .body("message", equalTo(MSG_USER_CREATED))
                .extract()
                .path("_id");
    }

    @Test
    @Order(4)
    void shouldUpdateUser() {
        given()
                .spec(baseSpec)
                .pathParam("id", userId)
                .body(usuarioJson("Обновлённый Покупатель", uniqueEmail, "false"))
                .when()
                .put("/usuarios/{id}")
                .then()
                .statusCode(200)
                .body("message", equalTo(MSG_USER_UPDATED));
    }

    @Test
    @Order(5)
    void shouldLogin() {
        token = given()
                .spec(baseSpec)
                .body(loginJson(uniqueEmail))
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .body("message", equalTo(MSG_LOGIN_SUCCESS))
                .body("authorization", notNullValue())
                .extract()
                .path("authorization");
    }

    @Test
    @Order(6)
    void shouldDeleteUser() {
        given()
                .spec(baseSpec)
                .header("Authorization", token)
                .pathParam("id", userId)
                .when()
                .delete("/usuarios/{id}")
                .then()
                .statusCode(200)
                .body("message", equalTo(MSG_USER_DELETED));

        given()
                .spec(baseSpec)
                .pathParam("id", userId)
                .when()
                .get("/usuarios/{id}")
                .then()
                .statusCode(400)
                .body("message", equalTo(MSG_USER_NOT_FOUND));
    }

    @Test
    @Order(7)
    void shouldGetAllProducts() {
        given()
                .spec(baseSpec)
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
    void shouldCreateNewUserFromDto() {
        uniqueEmail = generateUniqueEmail();
        Usuario userDto = new Usuario(
                "Тайный Покупатель",
                uniqueEmail,
                PASSWORD,
                "true"
        );

        userId = given()
                .spec(baseSpec)
                .body(userDto)
                .when()
                .post("/usuarios")
                .then()
                .statusCode(201)
                .body("message", equalTo(MSG_USER_CREATED))
                .extract()
                .path("_id");
    }

    private static String generateUniqueEmail() {
        return "spy_HOMER" + System.currentTimeMillis() + "@qa.com";
    }

    private static String usuarioJson(String nome, String email, String administrador) {
        return """
                {
                    "nome": "%s",
                    "email": "%s",
                    "password": "%s",
                    "administrador": "%s"
                }
                """.formatted(nome, email, PASSWORD, administrador);
    }

    private static String loginJson(String email) {
        return """
                {
                    "email": "%s",
                    "password": "%s"
                }
                """.formatted(email, PASSWORD);
    }
}
