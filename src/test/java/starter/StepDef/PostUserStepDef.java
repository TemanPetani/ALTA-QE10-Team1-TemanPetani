package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import starter.TemanPetani.TemanPetaniAPI;
import starter.TemanPetani.TemanPetaniResponse;
import starter.Utils.Constant;
import org.json.simple.JSONObject;
import java.io.File;
import static net.andreinc.mockneat.unit.user.Emails.emails;
import static net.andreinc.mockneat.unit.user.Names.names;
import static org.hamcrest.Matchers.*;

public class PostUserStepDef {
    @Steps
    TemanPetaniAPI temanPetaniAPI;
    @Given("post new user with valid req body")
    public void postNewUserWithValidReqBody() {
        JSONObject obj = new JSONObject();
        obj.put("fullname", names().full(90).get());
        obj.put("email", emails().domain("temanpetani.id").get());
        obj.put("password", "Ghalda123!");
        obj.put("phone", "0" + RandomStringUtils.randomNumeric(10));
        obj.put("address", "address" );
        temanPetaniAPI.postUser(obj);
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
        JSONObject obj = new JSONObject();
        obj.put("fullname", names().full(90).get());
        obj.put("email", "admin@temanpetani.id");
        obj.put("password", "Ghalda123!");
        obj.put("phone", "0" + RandomStringUtils.randomNumeric(10));
        obj.put("address", "address" );
        temanPetaniAPI.postUser(obj);
    }

    @Given("post new user with registered phone")
    public void postNewUserWithRegisteredPhone() {
        JSONObject obj = new JSONObject();
        obj.put("fullname", names().full(90).get());
        obj.put("email", emails().domain("temanpetani.id").get());
        obj.put("password", "Ghalda123!");
        obj.put("phone", "081213141516");
        obj.put("address", "address" );
        temanPetaniAPI.postUser(obj);
    }

    @Given("post new user with empty fullname")
    public void postNewUserWithEmptyFullname() {
        JSONObject obj = new JSONObject();
        obj.put("fullname", "");
        obj.put("email", emails().domain("temanpetani.id").get());
        obj.put("password", "Ghalda123!");
        obj.put("phone", "0" + RandomStringUtils.randomNumeric(10));
        obj.put("address", "address" );
        temanPetaniAPI.postUser(obj);
    }

    @Given("post new user with empty email")
    public void postNewUserWithEmptyEmail() {
        JSONObject obj = new JSONObject();
        obj.put("fullname", names().full(90).get());
        obj.put("email", "");
        obj.put("password", "Ghalda123!");
        obj.put("phone", "0" + RandomStringUtils.randomNumeric(10));
        obj.put("address", "address" );
        temanPetaniAPI.postUser(obj);
    }

    @Given("post new user with empty password")
    public void postNewUserWithEmptyPassword() {
        JSONObject obj = new JSONObject();
        obj.put("fullname", names().full(90).get());
        obj.put("email", emails().domain("temanpetani.id").get());
        obj.put("password", "");
        obj.put("phone", "0" + RandomStringUtils.randomNumeric(10));
        obj.put("address", "address" );
        temanPetaniAPI.postUser(obj);
    }

    @Given("post new user with empty phone")
    public void postNewUserWithEmptyPhone() {
        JSONObject obj = new JSONObject();
        obj.put("fullname", names().full(90).get());
        obj.put("email", emails().domain("temanpetani.id").get());
        obj.put("password", "Ghalda123!");
        obj.put("phone", "");
        obj.put("address", "address" );
        temanPetaniAPI.postUser(obj);
    }

    @Given("post new user with empty address")
    public void postNewUserWithEmptyAddress() {
        JSONObject obj = new JSONObject();
        obj.put("fullname", names().full(90).get());
        obj.put("email", emails().domain("temanpetani.id").get());
        obj.put("password", "Ghalda123!");
        obj.put("phone", "0" + RandomStringUtils.randomNumeric(10));
        obj.put("address", "" );
        temanPetaniAPI.postUser(obj);
    }

    @Given("post new user with password less than 8")
    public void postNewUserWithPasswordLessThan() {
        JSONObject obj = new JSONObject();
        obj.put("fullname", names().full(90).get());
        obj.put("email", emails().domain("temanpetani.id").get());
        obj.put("password", "G3!");
        obj.put("phone", "0" + RandomStringUtils.randomNumeric(10));
        obj.put("address", "address" );
        temanPetaniAPI.postUser(obj);
    }

    @Given("post new user with password length is 8")
    public void postNewUserWithPasswordLengthIs() {
        JSONObject obj = new JSONObject();
        obj.put("fullname", names().full(90).get());
        obj.put("email", emails().domain("temanpetani.id").get());
        obj.put("password", "Ghalda12!");
        obj.put("phone", "0" + RandomStringUtils.randomNumeric(10));
        obj.put("address", "address" );
        temanPetaniAPI.postUser(obj);
    }

    @Given("post new user with password more than 8")
    public void postNewUserWithPasswordMoreThan() {
        JSONObject obj = new JSONObject();
        obj.put("fullname", names().full(90).get());
        obj.put("email", emails().domain("temanpetani.id").get());
        obj.put("password", "Ghaldaa123!");
        obj.put("phone", "0" + RandomStringUtils.randomNumeric(10));
        obj.put("address", "address" );
        temanPetaniAPI.postUser(obj);
    }

    @Given("post new user with password without uppercase")
    public void postNewUserWithPasswordWithoutUppercase() {
        JSONObject obj = new JSONObject();
        obj.put("fullname", names().full(90).get());
        obj.put("email", emails().domain("temanpetani.id").get());
        obj.put("password", "ghaldaa123!");
        obj.put("phone", "0" + RandomStringUtils.randomNumeric(10));
        obj.put("address", "address" );
        temanPetaniAPI.postUser(obj);
    }

    @Given("post new user with password without special char")
    public void postNewUserWithPasswordWithoutSpecialChar() {
        JSONObject obj = new JSONObject();
        obj.put("fullname", names().full(90).get());
        obj.put("email", emails().domain("temanpetani.id").get());
        obj.put("password", "ghaldaa12345");
        obj.put("phone", "0" + RandomStringUtils.randomNumeric(10));
        obj.put("address", "address" );
        temanPetaniAPI.postUser(obj);
    }

    @Given("post new user with password without number")
    public void postNewUserWithPasswordWithoutNumber() {
        JSONObject obj = new JSONObject();
        obj.put("fullname", names().full(90).get());
        obj.put("email", emails().domain("temanpetani.id").get());
        obj.put("password", "ghaldaputri!");
        obj.put("phone", "0" + RandomStringUtils.randomNumeric(10));
        obj.put("address", "address" );
        temanPetaniAPI.postUser(obj);
    }
}
