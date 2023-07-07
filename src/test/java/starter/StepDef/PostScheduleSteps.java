package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import starter.TemanPetani.TemanPetaniAPI;
import starter.TemanPetani.TemanPetaniResponse;
import starter.Utils.Constant;

import java.io.File;

import static net.andreinc.mockneat.unit.user.Emails.emails;
import static net.andreinc.mockneat.unit.user.Names.names;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class PostScheduleSteps {
    @Steps
    TemanPetaniAPI temanPetaniAPI;

    @Given("post schedule templates with valid req body")
    public void postScheduleTemplatesWithValidReqBody() {
        JSONObject obj = new JSONObject();
        obj.put("name", "jadwal" + names().full(90).get());
        temanPetaniAPI.postSchedule(obj);
    }

    @When("Send post create schedule templates")
    public void sendPostCreateScheduleTemplates() {
        SerenityRest.when().post(temanPetaniAPI.TEMPLATES);
    }

    @And("Response body post create new user should be {string} and message contains {string}")
    public void responseBodyPostCreateNewUserShouldBeAndMessageContains(String status, String message) {
        SerenityRest.and()
                .body(TemanPetaniResponse.STATUS, equalTo(status))
                .body(TemanPetaniResponse.MESSAGE, containsString(message));
    }

    @And("Validate post create schedule templates JSON Schema")
    public void validatePostCreateScheduleTemplatesJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Templates/StatusMessageSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("post schedule templates with empty req body name")
    public void postScheduleTemplatesWithEmptyReqBodyName() {
        JSONObject obj = new JSONObject();
        obj.put("name", "");
        temanPetaniAPI.postSchedule(obj);
    }

    @Given("post schedule templates with invalid req body name")
    public void postScheduleTemplatesWithInvalidReqBodyName() {
        JSONObject obj = new JSONObject();
        obj.put("name", 0);
        temanPetaniAPI.postSchedule(obj);
    }
}
