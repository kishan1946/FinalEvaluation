package apiManage.apiAutomation;

import apiManage.apiResonse.GetWeatherDetailsResponse;
import apiManage.apiResonse.ManageWeatherDetails;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class APIWeatherDetailsAutomation {

//    public static void apiDetails() throws IOException, ParseException {
//        ManageWeatherDetails manageWeatherDetails=new ManageWeatherDetails();
//        System.out.println(manageWeatherDetails.getTemp());
//        System.out.println(manageWeatherDetails.getPressure());
//        System.out.println(manageWeatherDetails.getHumidity());
//        System.out.println(manageWeatherDetails.getWind());
//    }

    public static void main(String[] args) throws IOException, ParseException {
//       apiDetails();
        ManageWeatherDetails manageWeatherDetails=new ManageWeatherDetails();
        GetWeatherDetailsResponse getWeatherDetailsResponse=new GetWeatherDetailsResponse();

        getWeatherDetailsResponse.setTemp(manageWeatherDetails.getTemp());
        getWeatherDetailsResponse.setPressure(manageWeatherDetails.getPressure());
        getWeatherDetailsResponse.setHumidity(manageWeatherDetails.getHumidity());
        getWeatherDetailsResponse.setWind(manageWeatherDetails.getWind());
//        manageWeatherDetails.setData();
        System.out.println("Temperature: "+getWeatherDetailsResponse.getTemp()+" °C");
        System.out.println("Pressure: "+getWeatherDetailsResponse.getPressure()+" mbar");
        System.out.println("Humodity: "+getWeatherDetailsResponse.getHumidity()+" %");
        System.out.println("Wind Speed: "+getWeatherDetailsResponse.getWind()+" km/h");

    }
}
