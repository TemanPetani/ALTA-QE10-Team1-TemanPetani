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

public class GetTasksStepDef {
    @Steps
    TemanPetaniAPI temanPetaniAPI;
    @Given("get all task templates with valid ID")
    public void getAllTaskTemplatesWithValidID() {
        temanPetaniAPI.getTask(Constant.ID_TEMPLATE);
    }

    @When("Send get task templates")
    public void sendGetTaskTemplates() {
        Response response = SerenityRest.when().get(TemanPetaniAPI.TASKS);
        JsonPath jsonpath = response.jsonPath();
        if(jsonpath.getString("data") != null) {
            String idTask = jsonpath.getString("data.activity[0].id");
            Constant.ID_TASK = idTask;
            String idTaskDel= jsonpath.getString("data.activity[2].id");
            Constant.ID_TASK_DELETE = idTaskDel;
        } else {
            SerenityRest.when().get(TemanPetaniAPI.TASKS);
        }
    }

    @And("Validate success get all task templates JSON Schema")
    public void validateSuccessGetAllTaskTemplatesJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Templates/SuccessTasks.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("get all task templates with exceed ID {int}")
    public void getAllTaskTemplatesWithExceedID(int id) {
        temanPetaniAPI.getTask(id);
    }

    @And("Validate failed get all task templates JSON Schema")
    public void validateFailedGetAllTaskTemplatesJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Templates/FailedTasks.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("get all task templates with invalid ID {string}")
    public void getAllTaskTemplatesWithInvalidID(String id) {
        temanPetaniAPI.getTask(id);
    }
}
