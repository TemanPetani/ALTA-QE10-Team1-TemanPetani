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

public class GetScheduleStepDef {
    @Steps
    TemanPetaniAPI temanPetaniAPI;

    @Given("get list schedule templates with valid auth")
    public void getListScheduleTemplatesWithValidAuth() {
        temanPetaniAPI.getSchedule();
    }

    @When("Send get schedule templates")
    public void sendGetScheduleTemplates() {
        Response response = SerenityRest.when().get(TemanPetaniAPI.TEMPLATES);
        JsonPath jsonpath = response.jsonPath();
        if(jsonpath.getString("data") != null) {
            String idTemplate = jsonpath.getString("data[0].id");
            Constant.ID_TEMPLATE = idTemplate;
            System.out.printf(idTemplate);
            String idTemplateDel= jsonpath.getString("data[1].id");
            Constant.ID_TEMPLATE_DELETE = idTemplateDel;
        } else {
            SerenityRest.when().get(TemanPetaniAPI.TEMPLATES);
        }
    }

    @And("Response body get user status should be {string}, message contains {string}, and data schedule is exist")
    public void responseBodyGetUserStatusShouldBeMessageContainsAndDataScheduleIsExist(String status, String message) {
        SerenityRest.and()
                .body(TemanPetaniResponse.STATUS, equalTo(status))
                .body(TemanPetaniResponse.MESSAGE, containsString(message))
                .body(TemanPetaniResponse.DATA_INDEX, notNullValue());
    }

    @And("Validate success get list schedule JSON Schema")
    public void validateSuccessGetListScheduleJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Templates/SuccessSchedule.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("get list schedule templates without auth")
    public void getListScheduleTemplatesWithoutAuth() {
        temanPetaniAPI.getScheduleNoAuth();
    }

    @And("Response body get schedule message contains {string}")
    public void responseBodyGetScheduleMessageContains(String message) {
        SerenityRest.and()
                .body(TemanPetaniResponse.MESSAGE, containsString(message));
    }

    @And("Validate failed get list schedule JSON Schema")
    public void validateFailedGetListScheduleJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Templates/FailedSchedule.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("get list schedule templates invalid auth")
    public void getListScheduleTemplatesInvalidAuth() {
        temanPetaniAPI.getScheduleInvalidAuth();
    }
}
