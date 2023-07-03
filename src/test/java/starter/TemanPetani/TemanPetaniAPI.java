package starter.TemanPetani;

import io.restassured.http.ContentType;
import io.restassured.specification.MultiPartSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import starter.Utils.Constant;

import java.io.File;

import static com.sun.webkit.graphics.WCImage.getImage;
import static org.apache.commons.io.FileUtils.getFile;

public class TemanPetaniAPI {
    public static String LOGIN = Constant.BASE_URL+ "/login";
    public static String USERS = Constant.BASE_URL+ "/users";
    public static String USERS_PROFILE = Constant.BASE_URL+ "/users/profile";
    public static String USER_PROFILE_INVALID = Constant.BASE_URL+ "/usersss/profile";
    public static String USERS_PICTURE = Constant.BASE_URL+ "/users/picture";
    public static String USERS_PLANTS = Constant.BASE_URL+ "/users/plants";
    public static String USERS_PRODUCTS = Constant.BASE_URL+ "/users/products";

    @Step("Post login")
    public void postLogin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post User")
    public void postUser(JSONObject json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get List User")
    public void getListUser(){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN_ADMIN);
    }

    @Step("Get List User Invalid Auth")
    public void getListUserInvalidAuth(){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + "aaa");
    }

    @Step("Get User Plant Activity")
    public void getUserPlantActivity(){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN_ADMIN);
    }

    @Step("Get User Plant Activity No Auth")
    public void getUserPlantActivityNoAuth(){
        SerenityRest.given();
    }

    @Step("Get User Plant Activity Invalid Auth")
    public void getUserPlantActivityInvalidAuth(){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + "aaa");
    }

    @Step("Get User Product")
    public void getUserProduct(){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN_ADMIN);
    }

    @Step("Get User Product No Auth")
    public void getUserProductNoAuth(){
        SerenityRest.given();
    }

    @Step("Get User Product Invalid Auth")
    public void getUserProductInvalidAuth(){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + "aaa");
    }

    @Step("Put User Profile")
    public void putUserProfile(JSONObject json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN_ADMIN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put User Profile Picture")
    public void putUserProfilePicture(File multiPartImage) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN_USERS)
                .multiPart("picture", multiPartImage, "multipart/form-data");
    }

    @Step("Put User Profile Picture")
    public void putUserProfilePictureEmpty() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN_USERS)
                .multiPart("picture", "", "multipart/form-data");
    }

    @Step("Put User Profile Picture")
    public void putUserProfilePictureInvalid() {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN_USERS)
                .multiPart("picture", "ini picture", "multipart/form-data");
    }
}
