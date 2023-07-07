package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import starter.TemanPetani.TemanPetaniAPI;
import starter.Utils.Constant;

import java.io.File;

import static net.andreinc.mockneat.unit.user.Emails.emails;
import static net.andreinc.mockneat.unit.user.Names.names;

public class PutUserStepDef {
    @Steps
    TemanPetaniAPI temanPetaniAPI;

    @Given("put user profile with valid path and valid json body")
    public void putUserProfileWithValidPathAndValidJsonBody() {
        JSONObject obj = new JSONObject();
        obj.put("fullname", names().full(90).get());
        obj.put("email", "admin@temanpetani.id");
        obj.put("password", "Admin123!");
        obj.put("phone", "01878980709");
        obj.put("address", "address" );
        obj.put("avatar", "url" );
        obj.put("bank", "bri" );
        obj.put("noRekening", "0213456" );
        temanPetaniAPI.putUserProfile(obj);
    }

    @When("Send put user profile")
    public void sendPutUserProfile() {
        SerenityRest.when().put(temanPetaniAPI.USERS_PROFILE);
    }

    @And("Validate put user profile JSON Schema")
    public void validatePutUserProfileJSONSchema() {
        File json = new File(Constant.JSON_SCHEMA_DIR + "UserProfile/StatusMessageUser.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("put user profile with invalid email req body")
    public void putUserProfileWithInvalidEmailReqBody() {
        JSONObject obj = new JSONObject();
        obj.put("fullname", names().full(90).get());
        obj.put("email", 0);
        obj.put("password", "Admin123!");
        obj.put("phone", "01878980709");
        obj.put("address", "address" );
        obj.put("avatar", "url" );
        obj.put("bank", "bri" );
        obj.put("noRekening", "0213456" );
        temanPetaniAPI.putUserProfile(obj);
    }

    @Given("put user profile with invalid password req body")
    public void putUserProfileWithInvalidPasswordReqBody() {
        JSONObject obj = new JSONObject();
        obj.put("fullname", names().full(90).get());
        obj.put("email", "admin@temanpetani.id");
        obj.put("password", 0);
        obj.put("phone", "01878980709");
        obj.put("address", "address" );
        obj.put("avatar", "url" );
        obj.put("bank", "bri" );
        obj.put("noRekening", "0213456" );
        temanPetaniAPI.putUserProfile(obj);
    }

    @Given("put user profile with invalid fullname req body")
    public void putUserProfileWithInvalidFullnameReqBody() {
        JSONObject obj = new JSONObject();
        obj.put("fullname", 0);
        obj.put("email", "admin@temanpetani.id");
        obj.put("password", "Admin123!");
        obj.put("phone", "01878980709");
        obj.put("address", "address" );
        obj.put("avatar", "url" );
        obj.put("bank", "bri" );
        obj.put("noRekening", "0213456" );
        temanPetaniAPI.putUserProfile(obj);
    }
}
