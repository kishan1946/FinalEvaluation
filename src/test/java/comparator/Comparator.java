package comparator;

import callAPIAndUIDetails.CallAPIAndUIClass;
import comparator.VarianceCalculator;
import jsonData.JSONData;
import org.testng.Reporter;
import uiAutomation.initializer.WebDriverManagerSetup;

public class Comparator {
    public String metricComparator(String name) throws Exception {
        CallAPIAndUIClass callAPIAndUIClass=new CallAPIAndUIClass();
        JSONData data=new JSONData();
        data= WebDriverManagerSetup.readJSONFile();
        switch (name){
            case "Temperature":
                double tempDifference=Math.abs(Double.parseDouble(callAPIAndUIClass.getUITemp())-Double.parseDouble(callAPIAndUIClass.getAPITemp()));
                Reporter.log("tempDifference : "+Double.toString(tempDifference));
                return new VarianceCalculator().getVariance(Double.parseDouble(callAPIAndUIClass.getUITemp()),
                        Double.parseDouble(callAPIAndUIClass.getAPITemp()),Double.parseDouble(data.variance));

            case "Pressure":
                double pressureDifference=Math.abs(Double.parseDouble(callAPIAndUIClass.getUIPressure())-Double.parseDouble(callAPIAndUIClass.getAPIPressure()));
                Reporter.log("pressureDifference : "+Double.toString(pressureDifference));
                return new VarianceCalculator().getVariance(Double.parseDouble(callAPIAndUIClass.getUIPressure()),
                        Double.parseDouble(callAPIAndUIClass.getAPIPressure()),Double.parseDouble(data.pressureVariance));

            case "Wind":
                double windDifference=Math.abs(Double.parseDouble(callAPIAndUIClass.getUIWind())-Double.parseDouble(callAPIAndUIClass.getAPIWind()));
                Reporter.log("windDifference : "+Double.toString(windDifference));
                return new VarianceCalculator().getVariance((5/18)*Double.parseDouble(callAPIAndUIClass.getUIWind()),
                        Double.parseDouble(callAPIAndUIClass.getAPIWind()),Double.parseDouble(data.windVariance));

            case "Humidity":
                double humidityDifference=Math.abs(Double.parseDouble(callAPIAndUIClass.getUIHumidity())-Double.parseDouble(callAPIAndUIClass.getAPIHumidity()));
                Reporter.log("humidityDifference : "+Double.toString(humidityDifference));
                return new VarianceCalculator().getVariance(Double.parseDouble(callAPIAndUIClass.getUIHumidity()),
                        Double.parseDouble(callAPIAndUIClass.getAPIHumidity()),Double.parseDouble(data.variance));

            default:
                throw new Exception("Invalid Metric");
        }
    }
}
