package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.specification.MultiPartSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.TemanPetani.TemanPetaniAPI;
import starter.Utils.Constant;

import java.io.File;

public class PutUserPictureStepDef {
    @Steps
    TemanPetaniAPI temanPetaniAPI;
    @Given("put user profile picture with valid req body")
    public void putUserProfilePictureWithValidReqBody() {
        File image = new File(Constant.FILES_DIR + "user-picture.jpg");
        temanPetaniAPI.putUserProfilePicture(image);
    }

    @When("Send put user profile picture")
    public void sendPutUserProfilePicture() {
        SerenityRest.when().put(temanPetaniAPI.USERS_PICTURE);
    }

    @And("Validate put user profile picture JSON Schema")
    public void validatePutUserProfilePictureJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "UserProfile/StatusMessageUser.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("put user profile picture with empty req body picture")
    public void putUserProfilePictureWithEmptyReqBodyPicture() {
        temanPetaniAPI.putUserProfilePictureEmpty();
    }

    @Given("put user profile picture with invalid req body picture")
    public void putUserProfilePictureWithInvalidReqBodyPicture() {
        temanPetaniAPI.putUserProfilePictureInvalid();
    }
}
