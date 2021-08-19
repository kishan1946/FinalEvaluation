package jsonData;

public class JSONData {
    public String browser;
    public String city;
    public String url;
    public String userDetailsApi ;
    public String q ;
    public String units ;
    public String appid;
    public JSONData(String browser, String city, String url, String userDetailsApi, String q, String units, String appid){
        this.browser=browser;
        this.city=city;
        this.url=url;
        this.userDetailsApi=userDetailsApi;
        this.q=q;
        this.units=units;
        this.appid=appid;

    }

    public JSONData() {

    }
}
