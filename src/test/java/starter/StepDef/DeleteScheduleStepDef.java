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

public class DeleteScheduleStepDef {
    @Steps
    TemanPetaniAPI temanPetaniAPI;

    @Given("delete schedule templates with valid ID")
    public void deleteScheduleTemplatesWithValidID() {
        temanPetaniAPI.deleteSchedule(Constant.ID_TEMPLATE_DELETE);
    }

    @When("Send delete schedule templates")
    public void sendDeleteScheduleTemplates() {
        SerenityRest.when().delete(TemanPetaniAPI.TASKS);
    }

    @And("Validate delete schedule templates JSON Schema")
    public void validateDeleteScheduleTemplatesJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Templates/StatusMessageSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("delete schedule templates with exceed ID {int}")
    public void deleteScheduleTemplatesWithExceedID(int id) {
        temanPetaniAPI.deleteSchedule(id);
    }

    @Given("delete schedule templates with invalid ID {string}")
    public void deleteScheduleTemplatesWithInvalidID(String id) {
        temanPetaniAPI.deleteSchedule(id);
    }
}
