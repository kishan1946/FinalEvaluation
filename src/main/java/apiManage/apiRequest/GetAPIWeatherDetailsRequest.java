package apiManage.apiRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetAPIWeatherDetailsRequest {
    public Response weatherDetails(String userDetailsApi , String q, String units, String appid){
        Response userDetailsResponse = given().
                queryParam("q",q).
                queryParam("units", units).
                queryParam("appid", appid).
                contentType(ContentType.JSON).
                when().get(userDetailsApi);
//        new Gson().fromJson(userDetailsResponse.body().prettyPrint(), GetWeatherDetailsResponse.class);
//        userDetailsResponse.body().jsonPath().get();
        return userDetailsResponse;
    }

}
