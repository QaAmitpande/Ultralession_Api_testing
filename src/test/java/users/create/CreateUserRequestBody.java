package users.create;


import lombok.Getter;

import java.util.UUID;

@Getter

public class CreateUserRequestBody {

    private String name;
    private String gender;
    private String email;
    private String status;

    public CreateUserRequestBody(Builder builder) {
        this.name=builder.name;
        this.email=builder.email;
        this.gender=builder.gender;
        this.status=builder.status;
    }

    public static class Builder {
        private String name;
        private String gender;
        private String email;
        private String status;


        public Builder() {
            this.name = "nikhil pande";
            this.gender = "male";
            this.email = String.format("%s@gmail.com", UUID.randomUUID());
            this.status = "active";
        }

        public Builder gender(String gender){
            this.gender=gender;
            return this;
        }
        public Builder email(String email){
            this.email=email;
            return this;
        }
        public Builder status(String status){
            this.status=status;
            return this;
        }
        public CreateUserRequestBody build(){
       CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody(this);
       return createUserRequestBody;
        }
    }
}
/* public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }*/

  /*  public CreateUserRequestBody(String name, String gender, String email, String status) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.status = status;*/



