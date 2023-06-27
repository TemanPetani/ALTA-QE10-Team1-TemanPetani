package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.TemanPetani.TemanPetaniAPI;
import starter.TemanPetani.TemanPetaniResponse;
import starter.Utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.*;

public class PostUserStepDef {
    @Steps
    TemanPetaniAPI temanPetaniAPI;
    @Given("post new user with valid req body")
    public void postNewUserWithValidReqBody() {
        File json = new File(Constant.REQ_BODY_DIR+ "UserProfile/PostNewUser/ValidCredential.json");
        temanPetaniAPI.postUser(json);
    }

    @When("Send post create new user")
    public void sendPostCreateNewUser() {
        SerenityRest.when().post(temanPetaniAPI.USERS);
    }

    @And("Response body post create new user status should be {string} and message contains {string}")
    public void responseBodyPostCreateNewUserStatusShouldBeAndMessageContains(String status, String message) {
        SerenityRest.and()
                .body(TemanPetaniResponse.STATUS, equalTo(status))
                .body(TemanPetaniResponse.MESSAGE, containsString(message));
    }

    @And("Validate post create new user JSON Schema")
    public void validatePostCreateNewUserJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "UserProfile/CreateNewUser.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("post new user with registered email")
    public void postNewUserWithRegisteredEmail() {
        File json = new File(Constant.REQ_BODY_DIR+ "UserProfile/PostNewUser/RegisteredEmail.json");
        temanPetaniAPI.postUser(json);
    }

    @Given("post new user with registered phone")
    public void postNewUserWithRegisteredPhone() {
        File json = new File(Constant.REQ_BODY_DIR+ "UserProfile/PostNewUser/RegisteredPhone.json");
        temanPetaniAPI.postUser(json);
    }

    @Given("post new user with empty fullname")
    public void postNewUserWithEmptyFullname() {
        File json = new File(Constant.REQ_BODY_DIR+ "UserProfile/PostNewUser/EmptyFullname.json");
        temanPetaniAPI.postUser(json);
    }

    @Given("post new user with empty email")
    public void postNewUserWithEmptyEmail() {
        File json = new File(Constant.REQ_BODY_DIR+ "UserProfile/PostNewUser/EmptyEmail.json");
        temanPetaniAPI.postUser(json);
    }

    @Given("post new user with empty password")
    public void postNewUserWithEmptyPassword() {
        File json = new File(Constant.REQ_BODY_DIR+ "UserProfile/PostNewUser/EmptyPassword.json");
        temanPetaniAPI.postUser(json);
    }

    @Given("post new user with empty phone")
    public void postNewUserWithEmptyPhone() {
        File json = new File(Constant.REQ_BODY_DIR+ "UserProfile/PostNewUser/EmptyPhone.json");
        temanPetaniAPI.postUser(json);
    }

    @Given("post new user with empty address")
    public void postNewUserWithEmptyAddress() {
        File json = new File(Constant.REQ_BODY_DIR+ "UserProfile/PostNewUser/EmptyAddress.json");
        temanPetaniAPI.postUser(json);
    }

    @Given("post new user with password less than 8")
    public void postNewUserWithPasswordLessThan() {
        File json = new File(Constant.REQ_BODY_DIR+ "UserProfile/PostNewUser/PasswordLessThan.json");
        temanPetaniAPI.postUser(json);
    }

    @Given("post new user with password length is 8")
    public void postNewUserWithPasswordLengthIs() {
        File json = new File(Constant.REQ_BODY_DIR+ "UserProfile/PostNewUser/PasswordEqualTo.json");
        temanPetaniAPI.postUser(json);
    }

    @Given("post new user with password more than 8")
    public void postNewUserWithPasswordMoreThan() {
        File json = new File(Constant.REQ_BODY_DIR+ "UserProfile/PostNewUser/PasswordMoreThan.json");
        temanPetaniAPI.postUser(json);
    }

    @Given("post new user with password without uppercase")
    public void postNewUserWithPasswordWithoutUppercase() {
        File json = new File(Constant.REQ_BODY_DIR+ "UserProfile/PostNewUser/PasswordWithoutUppercase.json");
        temanPetaniAPI.postUser(json);
    }

    @Given("post new user with password without special char")
    public void postNewUserWithPasswordWithoutSpecialChar() {
        File json = new File(Constant.REQ_BODY_DIR+ "UserProfile/PostNewUser/PasswordWithoutSpecialChar.json");
        temanPetaniAPI.postUser(json);
    }

    @Given("post new user with password without number")
    public void postNewUserWithPasswordWithoutNumber() {
        File json = new File(Constant.REQ_BODY_DIR+ "UserProfile/PostNewUser/PasswordWithoutNumber.json");
        temanPetaniAPI.postUser(json);
    }
}
