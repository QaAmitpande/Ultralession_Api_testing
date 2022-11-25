import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.UsersService;
import users.getAll.GetAllUsersResponse;

import static io.restassured.RestAssured.given;

public class GetAllUsersTests {
    //Arrange
   private UsersService usersService;
   @BeforeClass
   public void beforeClass(){
       usersService= new UsersService();
   }

        @Test
        public void shouldGetAllUsers() {
//Act
        GetAllUsersResponse getAllUsersResponse= usersService.GetAllUsers();
                //    .then()

                   //Assert
     Assert.assertEquals(getAllUsersResponse.getStatusCode(),200);
     Assert.assertEquals(getAllUsersResponse.getDataList().size(),10);
     Assert.assertTrue(getAllUsersResponse.hasMaleUser());

                /*   .statusCode(200)
                     .body("data", Matchers.hasSize(10))
                     .body("data", Matchers.hasItem(Matchers.hasEntry("gender", "male")))
                     .log().body();*/

        }
}

