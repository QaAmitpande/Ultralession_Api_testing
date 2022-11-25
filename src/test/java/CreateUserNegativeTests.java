import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.UsersService;
import users.create.CreateUserRequestBody;
import users.create.response.CreateUserErrorResponse;

public class CreateUserNegativeTests {

    private UsersService usersService;
    @BeforeClass
    public void beforeClass(){
        usersService=new UsersService();
    }
    @Test
    public void shouldNotAllowToCreateUserWithInvalidEmail(){


      //  String name="sunita pande";
      //  String gender="female";
      //  String email="sunitapande1980gmail.com";
      //  String status="active";
     /*   String body="{\n" +
                "    \"name\": \"sunita pande\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"email\": \"sunitapande1980gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";*/
  // CreateUserRequestBody requestBody= new CreateUserRequestBody(name,gender,email,status);

      /*  CreateUserRequestBody requestBody=  CreateUserRequestBody
                .builder().name("sunita pande").gender("female").email("sunitapande1980gmail.com")
                .status("active").build();*/
        //Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().email("sunitapande1980gmail.com").build();
        //Act
      CreateUserErrorResponse errorResponse= usersService.createUserExpectingError(requestBody);
                //Assert
        Assert.assertEquals(errorResponse.getStatusCode(),422);
        errorResponse.assertMasError("email","is invalid");



        /* .then().log().body()
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));*/
    }
    @Test
    public void shouldNotAllowToCreateUserWithBlankGenderAndStatus(){

      /*  CreateUserRequestBody requestBody=  CreateUserRequestBody
                .builder().name("sunita pande").gender("").email("sunitapande1989@gmail.com")
                .status("").build();*/
        //Arrange
        CreateUserRequestBody requestBody = new CreateUserRequestBody.Builder().gender("").status("").build();
        //Act
        CreateUserErrorResponse errorResponse= usersService.createUserExpectingError(requestBody);
        //Assert
        Assert.assertEquals(errorResponse.getStatusCode(),422);
        errorResponse.assertMasError("gender","can't be blank, can be male of female");
        errorResponse.assertMasError("status","can't be blank");

    }
}
