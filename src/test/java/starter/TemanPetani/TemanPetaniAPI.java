package starter.TemanPetani;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constant;

import java.io.File;

public class TemanPetaniAPI {
    public static String LOGIN = Constant.BASE_URL+ "/login";
    public static String USERS = Constant.BASE_URL+ "/users";
    public static String USER_PROFILE = Constant.BASE_URL+ "/users/profile";
    public static String LIST_PRODUCT = Constant.BASE_URL+ "/users/products";
    public static String LIST_SOLD = Constant.BASE_URL+ "/users/sold";
    public static String LIST_ORDER = Constant.BASE_URL+ "/users/orders";

    @Step("Post login")
    public void postLogin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post User")
    public void postUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
