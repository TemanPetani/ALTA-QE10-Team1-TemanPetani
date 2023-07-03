package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.TemanPetani.TemanPetaniAPI;
import starter.TemanPetani.TemanPetaniResponse;

import static org.hamcrest.Matchers.*;

public class GetUserProductStepDef {
    @Steps
    TemanPetaniAPI temanPetaniAPI;

    @Given("get user products with valid auth")
    public void getUserProductsWithValidAuth() {
        temanPetaniAPI.getUserProduct();
    }

    @When("Send get user products")
    public void sendGetUserProducts() {
        SerenityRest.when().get(TemanPetaniAPI.USERS_PRODUCTS);
    }

    @And("Response body get user status should be {string}, message contains {string}, and data product is exist")
    public void responseBodyGetUserStatusShouldBeMessageContainsAndDataProductIsExist(String status, String message) {
        SerenityRest.and()
                .body(TemanPetaniResponse.STATUS, equalTo(status))
                .body(TemanPetaniResponse.MESSAGE, containsString(message))
                .body(TemanPetaniResponse.DATA_PRODUCT, notNullValue());
    }

    @Given("get user products with empty auth")
    public void getUserProductsWithEmptyAuth() {
        temanPetaniAPI.getUserProductNoAuth();
    }

    @Given("get user product with invalid auth")
    public void getUserProductWithInvalidAuth() {
        temanPetaniAPI.getUserProductInvalidAuth();
    }

    @And("Validate success get user product JSON Schema")
    public void validateSuccessGetUserProductJSONSchema() {
    }

    @And("Validate failed get user product JSON Schema")
    public void validateFailedGetUserProductJSONSchema() {
    }
}
