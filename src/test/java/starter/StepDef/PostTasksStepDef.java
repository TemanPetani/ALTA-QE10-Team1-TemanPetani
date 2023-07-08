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

public class PostTasksStepDef {
    @Steps
    TemanPetaniAPI temanPetaniAPI;
    @Given("post task templates with valid req body and ID")
    public void postTaskTemplatesWithValidReqBodyAndID() {
        JSONObject obj = new JSONObject();
        obj.put("name", "pupuk" + names().full(90).get());
        obj.put("startDays", 10 );
        temanPetaniAPI.postTask(Constant.ID_TEMPLATE, obj);
    }

    @When("Send post task templates")
    public void sendPostTaskTemplates() {
        SerenityRest.when().post(TemanPetaniAPI.TEMPLATES_ID_TASKS);
    }

    @And("Validate post create task templates JSON Schema")
    public void validatePostCreateTaskTemplatesJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Templates/StatusMessageSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("post task templates with valid req body and exceed ID {int}")
    public void postTaskTemplatesWithValidReqBodyAndExceedID(int id) {
        JSONObject obj = new JSONObject();
        obj.put("name", "pupuk" + names().full(90).get());
        obj.put("startDays", 10 );
        temanPetaniAPI.postTask(id, obj);
    }

    @Given("post task templates with valid req body and invalid ID {string}")
    public void postTaskTemplatesWithValidReqBodyAndInvalidID(String id) {
        JSONObject obj = new JSONObject();
        obj.put("name", "pupuk" + names().full(90).get());
        obj.put("startDays", 10 );
        temanPetaniAPI.postTask(id, obj);
    }

    @Given("post task templates with valid ID {int} and empty req body name")
    public void postTaskTemplatesWithValidIDAndEmptyReqBodyName(int id) {
        JSONObject obj = new JSONObject();
        obj.put("name", "");
        obj.put("startDays", 10 );
        temanPetaniAPI.postTask(id, obj);
    }

    @Given("post task templates with valid ID {int} and empty req body start day")
    public void postTaskTemplatesWithValidIDAndEmptyReqBodyStartDay(int id) {
        JSONObject obj = new JSONObject();
        obj.put("name", "pupuk" + names().full(90).get());
        obj.put("startDays", 0 );
        temanPetaniAPI.postTask(id, obj);
    }

    @Given("post task templates with valid ID {int} and invalid req body name")
    public void postTaskTemplatesWithValidIDAndInvalidReqBodyName(int id) {
        JSONObject obj = new JSONObject();
        obj.put("name", 0);
        obj.put("startDays", 10 );
        temanPetaniAPI.postTask(id, obj);
    }

    @Given("post task templates with valid ID {int} and invalid req body start day")
    public void postTaskTemplatesWithValidIDAndInvalidReqBodyStartDay(int id) {
        JSONObject obj = new JSONObject();
        obj.put("name", "pupuk" + names().full(90).get());
        obj.put("startDays", "" );
        temanPetaniAPI.postTask(id, obj);
    }
}
