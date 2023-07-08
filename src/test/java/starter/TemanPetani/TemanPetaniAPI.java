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
    public static String TEMPLATES = Constant.BASE_URL+ "/templates";
    public static String TASKS = Constant.BASE_URL+ "/templates/{id}";
    public static String TEMPLATES_TASKS_ID = Constant.BASE_URL+ "/templates/tasks/{id}";
    public static String TEMPLATES_ID_TASKS = Constant.BASE_URL+ "/templates/{id}/tasks";
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

    @Step("Get Schedule")
    public void getSchedule(){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN_ADMIN);
    }

    @Step("Get User Schedule No Auth")
    public void getScheduleNoAuth(){
        SerenityRest.given();
    }

    @Step("Get User Schedule Invalid Auth")
    public void getScheduleInvalidAuth(){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + "aaa");
    }

    @Step("Get Task")
    public void getTask(Object id){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN_ADMIN)
                .pathParams("id", id);
    }

    @Step("Post Schedule")
    public void postSchedule(JSONObject json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN_ADMIN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Task")
    public void postTask(Object id, JSONObject json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN_ADMIN)
                .pathParams("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put Schedule")
    public void putSchedule(Object id, JSONObject json) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN_ADMIN)
                .pathParams("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete Schedule")
    public void deleteSchedule(Object id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN_ADMIN)
                .pathParams("id", id);
    }

    @Step("Put Task")
    public void putTask(Object id, JSONObject json){
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN_ADMIN)
                .pathParams("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete Task")
    public void deleteTask(Object id) {
        SerenityRest.given()
                .headers("Authorization", "Bearer " + Constant.TOKEN_ADMIN)
                .pathParams("id", id);
    }
}
