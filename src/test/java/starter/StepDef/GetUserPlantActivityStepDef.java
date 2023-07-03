package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.TemanPetani.TemanPetaniAPI;
import starter.Utils.Constant;

import java.io.File;

public class GetUserPlantActivityStepDef {
    @Steps
    TemanPetaniAPI temanPetaniAPI;

    @Given("get user plant activities with valid auth")
    public void getUserPlantActivitiesWithValidAuth() {
        temanPetaniAPI.getUserPlantActivity();
    }

    @When("Send get user plant activities")
    public void sendGetUserPlantActivities() {
        SerenityRest.when().get(TemanPetaniAPI.USERS_PLANTS);
    }

    @And("Validate get user plant activities JSON Schema")
    public void validateGetUserPlantActivitiesJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "UserProfile/GetDataUsersMessage.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("get user plant activities with empty auth")
    public void getUserPlantActivitiesWithEmptyAuth() {
        temanPetaniAPI.getUserPlantActivityNoAuth();
    }

    @Given("get user plant activities with invalid auth")
    public void getUserPlantActivitiesWithInvalidAuth() {
        temanPetaniAPI.getUserPlantActivityInvalidAuth();
    }
}
