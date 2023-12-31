package apiManage.apiResonse;

import apiManage.apiRequest.GetAPIWeatherDetailsRequest;
import uiAutomation.initializer.WebDriverManagerSetup;
import jsonData.JSONData;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class ManageWeatherDetails {
    public Response apiCall() throws IOException, ParseException {
        GetAPIWeatherDetailsRequest getAPIWeatherDetails=new GetAPIWeatherDetailsRequest();
        WebDriverManagerSetup webDriverManagerSetup=new WebDriverManagerSetup();
        JSONData data=new JSONData();
        data= webDriverManagerSetup.readJSONFile();
        Response body=getAPIWeatherDetails.weatherDetails(data.userDetailsApi, data.q, data.units,data.appid);
        return body;
    }
    public String getTemp() throws IOException, ParseException {
        Response temp=apiCall();
        int index=temp.body().asPrettyString().indexOf("temp");
        return temp.body().asPrettyString().substring(index,index+15).replaceAll("[^.0-9]","").trim();
    }
    public String getWind() throws IOException, ParseException {
        Response wind=apiCall();
        int index=wind.body().asPrettyString().indexOf("speed");
        return wind.body().asPrettyString().substring(index,index+15).replaceAll("[^.0-9]","").trim();
    }
    public String getHumidity() throws IOException, ParseException {
        Response humidity=apiCall();
        int index=humidity.body().asPrettyString().indexOf("humidity");
        return humidity.body().asPrettyString().substring(index,index+15).replaceAll("[^.0-9]","").trim();
    }
    public String getPressure() throws IOException, ParseException {
        Response pressure=apiCall();
        int index=pressure.body().asPrettyString().indexOf("pressure");
        return pressure.body().asPrettyString().substring(index,index+15).replaceAll("[^.0-9]","").trim();
    }

    public void setData() throws IOException, ParseException {
        GetWeatherDetailsResponse getWeatherDetailsResponse=new GetWeatherDetailsResponse();
        getWeatherDetailsResponse.setTemp(getTemp());
        getWeatherDetailsResponse.setPressure(getPressure());
        getWeatherDetailsResponse.setHumidity(getHumidity());
        getWeatherDetailsResponse.setWind(getWind());
    }

}
