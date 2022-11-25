import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.UsersService;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserResponse;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class CreateUserTests {

    private UsersService usersService;
    @BeforeClass
    public void beforeClass(){
        usersService=new UsersService();

    }
    @Test
    public void shouldCreateMaleUser(){

       // String name="nikhil pande";
       // String gender="male";
       // String status="active";

      /*  String body = String.format("{\n" +
                "    \"name\": \"nikhil pande\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"%s\",\n" +
                "    \"status\": \"active\"\n" +
                "}",email);*/
     //  CreateUserRequestBody requestBody= new CreateUserRequestBody(name,gender,email,status);
      //  String email=String.format("%s@gmail.com",UUID.randomUUID());
   //  CreateUserRequestBody requestBody=  CreateUserRequestBody
         //    .builder().name("nikhil pande").gender("male").email(email).status("active").build();

        //Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().gender("male").build();
        //Act
      CreateUserResponse createUserResponse= usersService.createUser(requestBody);
      //Assert
        Assert.assertEquals(createUserResponse.getStatusCode(),201);
        Assert.assertNotNull(createUserResponse.getData().getId());
        Assert.assertEquals(createUserResponse.getData().getEmail(),requestBody.getEmail());
        Assert.assertEquals(createUserResponse.getData().getName(),requestBody.getName());
        Assert.assertEquals(createUserResponse.getData().getGender(),requestBody.getGender());
        Assert.assertEquals(createUserResponse.getData().getStatus(),requestBody.getStatus());


               // .statusCode(201)
              //  .body("data.id", Matchers.notNullValue())
              //  .body("data.email", Matchers.equalTo(email));


    }
    @Test
    public void shouldCreateFemaleUser(){

      //  String name= "sunita pande";
       // String gender="female";
      //  String status="active";

   /*     String body = String.format("{\n" +
                "    \"name\": \"sunita pande\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"%s\",\n" +
                "    \"status\": \"active\"\n" +
                "}",email);*/

    //  CreateUserRequestBody requestBody=  new CreateUserRequestBody(name,gender,email,status);


      //  String email=String.format("%s@gmail.com",UUID.randomUUID());
      //  CreateUserRequestBody requestBody=  CreateUserRequestBody
         //       .builder().name("sunita pande").gender("female").email(email).status("active").build();

        //Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().gender("female").build();
        //Act
      CreateUserResponse createUserResponse= usersService.createUser(requestBody);

      //Assert
        Assert.assertEquals(createUserResponse.getStatusCode(),201);
        Assert.assertNotNull(createUserResponse.getData().getId());
        Assert.assertEquals(createUserResponse.getData().getEmail(),requestBody.getEmail());
        Assert.assertEquals(createUserResponse.getData().getName(),requestBody.getName());
        Assert.assertEquals(createUserResponse.getData().getGender(),requestBody.getGender());
        Assert.assertEquals(createUserResponse.getData().getStatus(),requestBody.getStatus());

              //  .statusCode(201)
              //  .body("data.id", Matchers.notNullValue())
               // .body("data.email", Matchers.equalTo(email));


    }
}

