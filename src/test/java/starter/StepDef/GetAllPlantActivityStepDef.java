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
import starter.Utils.Constant;

import java.io.File;

public class GetAllPlantActivityStepDef {
    @Steps
    TemanPetaniAPI temanPetaniAPI;
    @Given("get all plant activity with valid auth")
    public void getAllPlantActivityWithValidAuth() {
        temanPetaniAPI.getPlant();
    }

    @When("Send get plant activity")
    public void sendGetPlantActivity() {
        Response response = SerenityRest.when().get(TemanPetaniAPI.PLANTS);
        JsonPath jsonpath = response.jsonPath();
        if(jsonpath.getString("data") != null) {
            int indexLast = jsonpath.getList("data").size() - 1;
            Constant.ID_PLANT = jsonpath.getString("data["+indexLast+"].id");
            Constant.ID_PLANT_DELETE = jsonpath.getString("data[0].id");
        } else {
            SerenityRest.when().get(TemanPetaniAPI.PLANTS);
        }
    }

    @And("Validate success get all plant activity JSON Schema")
    public void validateSuccessGetAllPlantActivityJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Plants/SuccessGetAllPlants.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("get all plant activity without auth")
    public void getAllPlantActivityWithoutAuth() {
        temanPetaniAPI.getPlantNoAuth();
    }

    @And("Validate failed get all plant activity JSON Schema")
    public void validateFailedGetAllPlantActivityJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Plants/FailedGetPlants.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("get all plant activity with invalid auth")
    public void getAllPlantActivityWithInvalidAuth() {
        temanPetaniAPI.getPlantInvalidAuth();
    }
}
