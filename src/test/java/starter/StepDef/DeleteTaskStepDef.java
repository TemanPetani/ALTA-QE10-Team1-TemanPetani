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

public class DeleteTaskStepDef {
    @Steps
    TemanPetaniAPI temanPetaniAPI;
    @Given("delete task templates with valid ID")
    public void deleteTaskTemplatesWithValidID() {
        temanPetaniAPI.deleteTask(Constant.ID_TASK_DELETE);
    }

    @When("Send delete task templates")
    public void sendDeleteTaskTemplates() {
        SerenityRest.when().delete(TemanPetaniAPI.TEMPLATES_TASKS_ID);
    }

    @And("Validate delete task templates JSON Schema")
    public void validateDeleteTaskTemplatesJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Templates/StatusMessageSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("delete task templates with exceed ID {int}")
    public void deleteTaskTemplatesWithExceedID(int id) {
        temanPetaniAPI.deleteTask(id);
    }

    @Given("delete task templates with invalid ID {string}")
    public void deleteTaskTemplatesWithInvalidID(String id) {
        temanPetaniAPI.deleteTask(id);
    }
}
