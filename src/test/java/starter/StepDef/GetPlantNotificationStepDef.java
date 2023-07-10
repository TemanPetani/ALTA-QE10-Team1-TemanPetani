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

public class GetPlantNotificationStepDef {
    @Steps
    TemanPetaniAPI temanPetaniAPI;
    @Given("Get plant activity notif notif with valid auth")
    public void getPlantActivityNotifNotifWithValidAuth() {
        temanPetaniAPI.getPlantNotification();
    }

    @When("Send get plant activity notif")
    public void sendGetPlantActivityNotif() {
        SerenityRest.when().get(TemanPetaniAPI.PLANTS_NOTIFICATION);
    }

    @And("Validate success get plant activity notif JSON Schema")
    public void validateSuccessGetPlantActivityNotifJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Plants/SuccessGetPlantNotif.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get plant activity notif without auth")
    public void getPlantActivityNotifWithoutAuth() {
        temanPetaniAPI.getPlantNotificationNoAuth();
    }


    @And("Validate failed get plant activity notif JSON Schema")
    public void validateFailedGetPlantActivityNotifJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Plants/FailedGetPlants.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get plant activity notif with invalid auth")
    public void getPlantActivityNotifWithInvalidAuth() {
        temanPetaniAPI.getPlantNotificationInvalidAuth();
    }
}
