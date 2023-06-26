package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.TemanPetani.TemanPetaniAPI;
import starter.TemanPetani.TemanPetaniResponse;
import starter.Utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PostLoginStepDef {

    @Steps
    TemanPetaniAPI temanPetaniAPI;

    @Given("post login with valid email and password")
    public void postLoginWithValidEmailAndPassword() {
        File json = new File(Constant.REQ_BODY_DIR+ "Login/ValidEmailAndPassword.json");
        temanPetaniAPI.postLogin(json);
    }

    @When("Send post login user")
    public void sendPostLoginUser() {
        SerenityRest.when().post(temanPetaniAPI.LOGIN);
    }

    @And("Response body status should be {string} and message should be {string}")
    public void responseBodyStatusShouldBeAndMessageShouldBe(String status, String message) {
        SerenityRest.and()
                .body(TemanPetaniResponse.STATUS, equalTo(status))
                .body(TemanPetaniResponse.MESSAGE, equalTo(message));
    }

    @And("Validate failed post login JSON Schema")
    public void validatePostFailedLoginJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Login/FailedLogin.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("post login with valid email and empty password")
    public void postLoginWithValidEmailAndEmptyPassword() {
        File json = new File(Constant.REQ_BODY_DIR+ "Login/ValidEmailAndEmptyPassword.json");
        temanPetaniAPI.postLogin(json);
    }

    @Given("post login with valid empty email and valid password")
    public void postLoginWithValidEmptyEmailAndValidPassword() {
        File json = new File(Constant.REQ_BODY_DIR+ "Login/EmptyEmailAndValidPassword.json");
        temanPetaniAPI.postLogin(json);
    }

    @Given("post login with valid empty email and password")
    public void postLoginWithValidEmptyEmailAndPassword() {
        File json = new File(Constant.REQ_BODY_DIR+ "Login/EmptyEmailAndPassword.json");
        temanPetaniAPI.postLogin(json);
    }

    @And("Response body status should be {string}, message should be {string}, and token is exist")
    public void responseBodyStatusShouldBeMessageShouldBeAndTokenIsExist(String status, String message) {
        SerenityRest.and()
                .body(TemanPetaniResponse.STATUS, equalTo(status))
                .body(TemanPetaniResponse.MESSAGE, equalTo(message))
                .body(TemanPetaniResponse.TOKEN_USERS, notNullValue());
    }

    @And("Validate post login JSON Schema")
    public void validatePostLoginJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Login/SuccessLogin.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("post login with unregistered email and wrong password")
    public void postLoginWithUnregisteredEmailAndWrongPassword() {
        File json = new File(Constant.REQ_BODY_DIR+ "Login/UnregisteredEmailAndWrongPassword.json");
        temanPetaniAPI.postLogin(json);
    }

    @Given("post login with valid email and wrong password")
    public void postLoginWithValidEmailAndWrongPassword() {
        File json = new File(Constant.REQ_BODY_DIR+ "Login/ValidEmailAndWrongPassword.json");
        temanPetaniAPI.postLogin(json);
    }
}
