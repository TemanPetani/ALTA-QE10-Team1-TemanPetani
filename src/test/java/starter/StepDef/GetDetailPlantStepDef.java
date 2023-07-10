package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import starter.TemanPetani.TemanPetaniAPI;
import starter.TemanPetani.TemanPetaniResponse;
import starter.Utils.Constant;

import java.io.File;

import static org.hamcrest.Matchers.*;

public class GetDetailPlantStepDef {
    @Steps
    TemanPetaniAPI temanPetaniAPI;

    @Given("get plant activity with valid ID")
    public void getPlantActivityWithValidID() {
        temanPetaniAPI.getDetailPlant(Constant.ID_PLANT);
    }

    @And("Response body plant id as id path, status should be {string}, and message contains {string}")
    public void responseBodyPlantIdAsIdPathStatusShouldBeAndMessageContains(String status, String message) {
        SerenityRest.and()
                .body(TemanPetaniResponse.STATUS, equalTo(status))
                .body(TemanPetaniResponse.MESSAGE, containsString(message))
                .body(TemanPetaniResponse.DATA_ID, equalTo(Integer.parseInt(Constant.ID_PLANT)));
    }

    @And("Validate success get plant activity JSON Schema")
    public void validateSuccessGetPlantActivityJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Plants/SuccessGetDetailPlants.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("get plant activity with exceed ID {int}")
    public void getPlantActivityWithExceedID(int id) {
        temanPetaniAPI.getDetailPlant(id);
    }

    @Given("get plant activity with invalid ID {string}")
    public void getPlantActivityWithInvalidID(String id) {
        temanPetaniAPI.getDetailPlant(id);
    }

    @When("Send get detail plant activity")
    public void sendGetDetailPlantActivity() {
        Response response = SerenityRest.when().get(TemanPetaniAPI.PLANTS_ID);
        JsonPath jsonpath = response.jsonPath();
        if(jsonpath.getString("data") != null) {
            Constant.ID_PLANT_ACTIVITY = jsonpath.getString("data.activities[0].id");
        } else {
            SerenityRest.when().get(TemanPetaniAPI.PLANTS_ID);
        }
    }

    @And("Validate failed get plant activity JSON Schema")
    public void validateFailedGetPlantActivityJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Plants/StatusMessageSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
