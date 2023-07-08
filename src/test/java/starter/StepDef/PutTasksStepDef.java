package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.json.simple.JSONObject;
import starter.TemanPetani.TemanPetaniAPI;
import starter.Utils.Constant;

import java.io.File;

import static net.andreinc.mockneat.unit.user.Names.names;

public class PutTasksStepDef {
    @Steps
    TemanPetaniAPI temanPetaniAPI;

    @Given("put task templates with valid req body and ID")
    public void putTaskTemplatesWithValidReqBodyAndID() {
        JSONObject obj = new JSONObject();
        obj.put("name", "siram" + names().full(90).get());
        obj.put("startDays", 10 );
        temanPetaniAPI.putTask(Constant.ID_TASK, obj);
    }

    @When("Send put task templates")
    public void sendPutTaskTemplates() {
        SerenityRest.when().put(TemanPetaniAPI.TEMPLATES_TASKS_ID);
    }

    @And("Validate put task templates JSON Schema")
    public void validatePutTaskTemplatesJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Templates/StatusMessageSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("put task templates with valid req body and exceed ID {int}")
    public void putTaskTemplatesWithValidReqBodyAndExceedID(int id) {
        JSONObject obj = new JSONObject();
        obj.put("name", "siram" + names().full(90).get());
        obj.put("startDays", 10 );
        temanPetaniAPI.putTask(id, obj);
    }

    @Given("put task templates with valid req body and invalid ID {string}")
    public void putTaskTemplatesWithValidReqBodyAndInvalidID(String id) {
        JSONObject obj = new JSONObject();
        obj.put("name", "siram" + names().full(90).get());
        obj.put("startDays", 10 );
        temanPetaniAPI.putTask(id, obj);
    }

    @Given("put task templates with valid ID {int} and invalid req body name")
    public void putTaskTemplatesWithValidIDAndInvalidReqBodyName(int id) {
        JSONObject obj = new JSONObject();
        obj.put("name", 0);
        obj.put("startDays", 10 );
        temanPetaniAPI.putTask(id, obj);
    }

    @Given("put task templates with valid ID {int} and invalid req body start days")
    public void putTaskTemplatesWithValidIDAndInvalidReqBodyStartDays(int id) {
        JSONObject obj = new JSONObject();
        obj.put("name", "siram" + names().full(90).get());
        obj.put("startDays", "" );
        temanPetaniAPI.putTask(id, obj);
    }

    @Given("put task templates with valid ID and register req body name")
    public void putTaskTemplatesWithValidIDAndRegisterReqBodyName() {
        JSONObject obj = new JSONObject();
        obj.put("name", "siram jagung t");
        obj.put("startDays", 10 );
        temanPetaniAPI.putTask(Constant.ID_TASK, obj);
    }
}
