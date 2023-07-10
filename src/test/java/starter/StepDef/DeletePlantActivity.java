package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.TemanPetani.TemanPetaniAPI;
import starter.Utils.Constant;

public class DeletePlantActivity {
    @Steps
    TemanPetaniAPI temanPetaniAPI;
    @Given("Delete plant activity with valid ID")
    public void deletePlantActivityWithValidID() {
        temanPetaniAPI.deletePlants(Constant.ID_PLANT_DELETE);
    }

    @When("Send delete plant activity")
    public void sendDeletePlantActivity() {
        SerenityRest.when().delete(TemanPetaniAPI.PLANTS_ID);
    }

    @And("Validate delete plant activity JSON Schema")
    public void validateDeletePlantActivityJSONSchema() {
    }

    @Given("Delete plant activity with valid req body and exceed ID {int}")
    public void deletePlantActivityWithValidReqBodyAndExceedID(int id) {
        temanPetaniAPI.deletePlants(id);
    }

    @Given("Delete plant activity with valid req body and invalid ID {string}")
    public void deletePlantActivityWithValidReqBodyAndInvalidID(String id) {
        temanPetaniAPI.deletePlants(id);
    }
}
