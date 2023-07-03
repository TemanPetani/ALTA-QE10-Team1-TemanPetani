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

import static org.hamcrest.Matchers.*;

public class GetUserStepDef {
    @Steps
    TemanPetaniAPI temanPetaniAPI;

    @Given("Get user profile with valid auth")
    public void getUserProfileWithValidAuth() {
        temanPetaniAPI.getListUser();
    }

    @When("Send get user profile")
    public void sendGetUserProfile() {
        SerenityRest.when().get(TemanPetaniAPI.USERS_PROFILE);
    }

    @When("Send get user profile invalid path")
    public void sendGetUserProfileInvalidPath() {
        SerenityRest.when().get(TemanPetaniAPI.USER_PROFILE_INVALID);
    }

    @And("Response body get user status should be {string}, message contains {string}, and data is exist")
    public void responseBodyGetUserStatusShouldBeMessageContainsAndDataIsExist(String status, String message) {
        SerenityRest.and()
                .body(TemanPetaniResponse.STATUS, equalTo(status))
                .body(TemanPetaniResponse.MESSAGE, containsString(message))
                .body(TemanPetaniResponse.DATA, notNullValue());
    }

    @And("Validate success get user profile JSON Schema")
    public void validateSuccessGetUserProfileJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "UserProfile/GetDataUsers.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Response body get user message contains {string}")
    public void responseBodyGetUserMessageContains(String message) {
        SerenityRest.and()
                .body(TemanPetaniResponse.MESSAGE, containsString(message));
    }

    @And("Validate failed get user profile JSON Schema message")
    public void validateFailedGetUserProfileJSONSchemaMessage() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "UserProfile/GetDataUsersMessage.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get user profile with invalid auth")
    public void getUserProfileWithInvalidAuth() {
        temanPetaniAPI.getListUserInvalidAuth();
    }

    @Given("Get user profile with invalid path")
    public void getUserProfileWithInvalidPath() {
        temanPetaniAPI.getListUser();
    }
}
