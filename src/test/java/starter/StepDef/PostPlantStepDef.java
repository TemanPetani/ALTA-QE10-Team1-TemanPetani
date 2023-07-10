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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static net.andreinc.mockneat.unit.user.Names.names;

public class PostPlantStepDef {
    @Steps
    TemanPetaniAPI temanPetaniAPI;

    @Given("Post plant activity with valid req body")
    public void postPlantActivityWithValidReqBody() {
        JSONObject obj = new JSONObject();
        obj.put("templateId", 2);
        obj.put("name", "siram " + names().full(90).get());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date date = new Date();
        String currDate= dateFormat.format(date);
        obj.put("startDate", currDate);
        temanPetaniAPI.postPlantActivity(obj);
    }

    @And("Validate post plant activity JSON Schema")
    public void validatePostPlantActivityJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Plants/StatusMessageSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @When("Send post plant activity")
    public void sendPostPlantActivity() {
        SerenityRest.when().post(TemanPetaniAPI.PLANTS);
    }

    @Given("Post plant activity with empty req body templateId")
    public void postPlantActivityWithEmptyReqBodyTemplateId() {
        JSONObject obj = new JSONObject();
        obj.put("templateId", 0);
        obj.put("name", "siram " + names().full(90).get());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date date = new Date();
        String currDate= dateFormat.format(date);
        obj.put("startDate", currDate);
        temanPetaniAPI.postPlantActivity(obj);
    }

    @Given("Post plant activity with empty req body name")
    public void postPlantActivityWithEmptyReqBodyName() {
        JSONObject obj = new JSONObject();
        obj.put("templateId", 2);
        obj.put("name", "");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date date = new Date();
        String currDate= dateFormat.format(date);
        obj.put("startDate", currDate);
        temanPetaniAPI.postPlantActivity(obj);
    }

    @Given("Post plant activity with empty req body start date")
    public void postPlantActivityWithEmptyReqBodyStartDate() {
        JSONObject obj = new JSONObject();
        obj.put("templateId", 2);
        obj.put("name", "siram " + names().full(90).get());
        obj.put("startDate", null);
        temanPetaniAPI.postPlantActivity(obj);
    }

    @Given("Post plant activity with invalid req body template id")
    public void postPlantActivityWithInvalidReqBodyTemplateId() {
        JSONObject obj = new JSONObject();
        obj.put("templateId", "");
        obj.put("name", "siram " + names().full(90).get());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date date = new Date();
        String currDate= dateFormat.format(date);
        obj.put("startDate", currDate);
        temanPetaniAPI.postPlantActivity(obj);
    }

    @Given("Post plant activity with invalid req body name")
    public void postPlantActivityWithInvalidReqBodyName() {
        JSONObject obj = new JSONObject();
        obj.put("templateId", 2);
        obj.put("name", 0);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date date = new Date();
        String currDate= dateFormat.format(date);
        obj.put("startDate", currDate);
        temanPetaniAPI.postPlantActivity(obj);
    }

    @Given("Post plant activity with invalid format req body start date")
    public void postPlantActivityWithInvalidReqBodyStartDate() {
        JSONObject obj = new JSONObject();
        obj.put("templateId", 2);
        obj.put("name", "siram " + names().full(90).get());
        obj.put("startDate", "9 juli");
        temanPetaniAPI.postPlantActivity(obj);
    }

    @Given("post plant activity with exceed req body templateId")
    public void postPlantActivityWithExceedReqBodyTemplateId() {
        JSONObject obj = new JSONObject();
        obj.put("templateId", 100000);
        obj.put("name", "siram " + names().full(90).get());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date date = new Date();
        String currDate= dateFormat.format(date);
        obj.put("startDate", currDate);
        temanPetaniAPI.postPlantActivity(obj);
    }
}
