package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.json.simple.JSONObject;
import starter.TemanPetani.TemanPetaniAPI;
import starter.TemanPetani.TemanPetaniResponse;
import starter.Utils.Constant;

import java.io.File;

import static net.andreinc.mockneat.unit.user.Names.names;
import static org.hamcrest.Matchers.*;

public class PutScheduleStepDef {
    @Steps
    TemanPetaniAPI temanPetaniAPI;
    @Given("put schedule templates with valid req body and ID")
    public void putScheduleTemplatesWithValidReqBodyAndID() {
        JSONObject obj = new JSONObject();
        obj.put("name", names().full(90).get());
        temanPetaniAPI.putSchedule(Constant.ID_TEMPLATE,obj);
    }

    @When("Send put schedule templates")
    public void sendPutScheduleTemplates() {
        SerenityRest.when().put(temanPetaniAPI.TASKS);
    }

    @And("Response body schedule status should be {string} and message contains {string}")
    public void responseBodyScheduleStatusShouldBeAndMessageContains(String status, String message) {
        SerenityRest.and()
                .body(TemanPetaniResponse.STATUS, equalTo(status))
                .body(TemanPetaniResponse.MESSAGE, containsString(message));
    }

    @And("Validate put schedule templates JSON Schema")
    public void validatePutScheduleTemplatesJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Templates/StatusMessageSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("put schedule templates with valid req body and exceed ID {int}")
    public void putScheduleTemplatesWithValidReqBodyAndExceedID(int id) {
        JSONObject obj = new JSONObject();
        obj.put("name", names().full(90).get());
        temanPetaniAPI.putSchedule(id,obj);
    }

    @Given("put schedule templates with valid req body and invalid ID {string}")
    public void putScheduleTemplatesWithValidReqBodyAndInvalidID(String id) {
        JSONObject obj = new JSONObject();
        obj.put("name", names().full(90).get());
        temanPetaniAPI.putSchedule(id,obj);
    }

    @Given("put schedule templates with valid ID and invalid req body name")
    public void putScheduleTemplatesWithValidIDAndInvalidReqBodyName() {
        JSONObject obj = new JSONObject();
        obj.put("name", 0);
        temanPetaniAPI.putSchedule(Constant.ID_TEMPLATE,obj);
    }
}
