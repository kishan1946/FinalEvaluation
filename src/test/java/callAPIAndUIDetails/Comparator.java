package callAPIAndUIDetails;

import comparator.VarianceCalculator;
import initializer.JSONData;
import initializer.WebDriverManagerSetup;

public class Comparator {
    public String metricComparator(String name) throws Exception {
        CallAPIAndUIClass callAPIAndUIClass=new CallAPIAndUIClass();
        JSONData data=new JSONData();
        data= WebDriverManagerSetup.readJSONFile();
        switch (name){
            case "Temperature":
                return new VarianceCalculator().getVariance(Double.parseDouble(callAPIAndUIClass.getUITemp()),
                        Double.parseDouble(callAPIAndUIClass.getAPITemp()),Double.parseDouble(data.variance));

            case "Pressure":
                return new VarianceCalculator().getVariance(Double.parseDouble(callAPIAndUIClass.getUIPressure()),
                        Double.parseDouble(callAPIAndUIClass.getAPIPressure()),Double.parseDouble(data.pressureVariance));

            case "Wind":
                return new VarianceCalculator().getVariance(Double.parseDouble(callAPIAndUIClass.getUIWind()),
                        Double.parseDouble(callAPIAndUIClass.getAPIWind()),Double.parseDouble(data.windVariance));

            case "Humidity":
                return new VarianceCalculator().getVariance(Double.parseDouble(callAPIAndUIClass.getUIHumidity()),
                        Double.parseDouble(callAPIAndUIClass.getAPIHumidity()),Double.parseDouble(data.variance));

            default:
                throw new Exception("Invalid Metric");
        }
    }
}
