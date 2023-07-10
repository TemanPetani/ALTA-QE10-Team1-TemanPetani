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

public class PutPlantStepDef {
    @Steps
    TemanPetaniAPI temanPetaniAPI;
    @Given("Put plant activity with valid req body and valid ID")
    public void putPlantActivityWithValidReqBodyAndValidID() {
        JSONObject obj = new JSONObject();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date date = new Date();
        String currDate= dateFormat.format(date);
        obj.put("completedDate", currDate);
        temanPetaniAPI.putPlant(Constant.ID_PLANT_ACTIVITY, obj);
    }

    @When("Send put plant activity")
    public void sendPutPlantActivity() {
        SerenityRest.when().put(TemanPetaniAPI.PLANTS_ACTIVITY_ID);
    }

    @And("Validate plant activity JSON Schema")
    public void validatePlantActivityJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "Plants/StatusMessageSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Put plant activity with valid req body and exceed ID {int}")
    public void putPlantActivityWithValidReqBodyAndExceedID(int id) {
        JSONObject obj = new JSONObject();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date date = new Date();
        String currDate= dateFormat.format(date);
        obj.put("completedDate", currDate);
        temanPetaniAPI.putPlant(id, obj);
    }

    @Given("Put plant activity with valid req body and invalid ID {string}")
    public void putPlantActivityWithValidReqBodyAndInvalidID(String id) {
        JSONObject obj = new JSONObject();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date date = new Date();
        String currDate= dateFormat.format(date);
        obj.put("completedDate", currDate);
        temanPetaniAPI.putPlant(id, obj);
    }

    @Given("Put plant activity with valid ID and invalid req body completed date")
    public void putPlantActivityWithValidIDAndInvalidReqBodyCompletedDate() {
        JSONObject obj = new JSONObject();
        obj.put("completedDate", 0);
        temanPetaniAPI.putPlant(Constant.ID_PLANT_ACTIVITY, obj);
    }

    @Given("Put plant activity with valid ID and invalid format req body completed date")
    public void putPlantActivityWithValidIDAndInvalidFormatReqBodyCompletedDate() {
        JSONObject obj = new JSONObject();
        obj.put("completedDate", "9 Juli 2023");
        temanPetaniAPI.putPlant(Constant.ID_PLANT_ACTIVITY, obj);
    }
}
