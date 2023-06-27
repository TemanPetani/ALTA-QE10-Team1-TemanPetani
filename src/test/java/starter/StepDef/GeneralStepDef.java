package starter.StepDef;

import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;

public class GeneralStepDef {
    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }


    @Then("Status code should be {int} Internal Server Error")
    public void statusCodeShouldBeInternalServerErr(int internalServerErr) {
        SerenityRest.then().statusCode(internalServerErr);
    }
}
