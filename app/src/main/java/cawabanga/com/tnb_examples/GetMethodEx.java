package cawabanga.com.tnb_examples;

import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;


import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpGet;

/**
 * Created by croatan on 8.3.2016. TNB_Examples.
 */
public class GetMethodEx {

    public String getInternetData() throws Exception {
        BufferedReader in = null;
        String data = null;
        try {
            HttpClient client = (HttpClient) new DefaultHttpClient();
            URI website = new URI("http://www.mybringback.com");
            HttpGet request = new HttpGet();
            request.setURI(website);
            HttpResponse response = client.execute(request);
            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer sb = new StringBuffer("");
            String l = "";
            String nl = System.getProperty("line.separator");
            while ((l = in.readLine()) != null){
                sb.append(l + nl);
            }
            in.close();
            data = sb.toString();
            return data;
        }finally {
            if (in != null){
                try {
                    in.close();
                    return data;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }


}
