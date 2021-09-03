package jsonData;

public class JSONData {
    public String browser;
    public String city;
    public String url;
    public String userDetailsApi ;
    public String q ;
    public String units ;
    public String appid;
    public String variance;
    public String pressureVariance;
    public String windVariance;
    public String minVariance;
    public JSONData(String browser, String city, String url, String userDetailsApi, String q,
                    String units, String appid, String variance, String pressureVariance, String windVariance,String minVariance){
        this.browser=browser;
        this.city=city;
        this.url=url;
        this.userDetailsApi=userDetailsApi;
        this.q=q;
        this.units=units;
        this.appid=appid;
        this.variance=variance;
        this.pressureVariance=pressureVariance;
        this.windVariance=windVariance;
        this.minVariance=minVariance;

    }

    public JSONData() {

    }
}
