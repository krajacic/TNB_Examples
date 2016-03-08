package cawabanga.com.tnb_examples;

/**
 * Created by croatan on 8.3.2016. TNB_Examples.
 */
public class XMLDataCollected {
    int temp = 0;
    String city = null;

    public void setCity(String c){
        city = c;

    }

    public void setTemp(int t){
        temp = t;
    }

    public String dataToString(){
        return "In " + city + " current temperature is " + temp + " degrees.";
    }
}
