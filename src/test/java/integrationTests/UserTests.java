package integrationTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.UsersService;
import users.create.CreateUserRequestBody;

import java.util.UUID;

public class UserTests {
    private UsersService usersService;

    @BeforeClass
    public void beforeClass() {
        usersService = new UsersService();
    }

    @Test
    public void ShouldCreateAndGetUser() {

      /*  String email = String.format("%s@gmail.com", UUID.randomUUID());
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("nikhil pande").gender("male").email(email).status("active").build();*/

        //Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().build();
        //Act
        int id = usersService.createUser(requestBody).getData().getId();
        //Assert
        usersService.getUser(id).assertUser(requestBody);
    }

    @Test
    public void ShouldDeleteUser() {

      /*  String email = String.format("%s@gmail.com", UUID.randomUUID());
        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("nikhil pande").gender("male").email(email).status("active").build();*/

        //Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().build();
        //Act
        int id = usersService.createUser(requestBody).getData().getId();
     int statusCode= usersService.deleteUser(id);

        //Assert
        Assert.assertEquals(statusCode,204);
        usersService.getUserExpectingError(id)
                .assertError(404,"Resource not found");
    }
}
