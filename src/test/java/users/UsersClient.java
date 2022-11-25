package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;
import users.create.response.CreateUserResponse;
import users.get.GetUserResponse;
import users.getAll.GetAllUsersResponse;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public static Response create(CreateUserRequestBody body) {
        Response response =
                given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 77970b9d769496fe209c6251a9ca0ada2e88866ca6ece14b99b380154a3998d7")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
        response
                .then()
                .log().body();
        return response;
    }

    public static Response getAll() {
        Response response = given()
                .when()
                .get("https://gorest.co.in/public/v1/users");
        response
                .then()
                .log().body();
        return response;
    }

    public static Response get(int id) {
        Response response = given()
                .pathParam("id", id)
                .header("Authorization","Bearer 77970b9d769496fe209c6251a9ca0ada2e88866ca6ece14b99b380154a3998d7")
                .when()
                .get("https://gorest.co.in/public/v1/users/{id}");
        response
                .then()
                .log().body();
        return response;
    }

    public static Response delete(int id) {
        Response response = given()
                .pathParam("id", id)
                .header("Authorization","Bearer 77970b9d769496fe209c6251a9ca0ada2e88866ca6ece14b99b380154a3998d7")
                .when()
                .delete("https://gorest.co.in/public/v1/users/{id}");
        response
                .then()
                .log().body();
        return response;
    }
}
