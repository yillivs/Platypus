package resources;

import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Http request Utility class
 */
public class HttpRequest {
    /**
     * Sends a post request with JSON as body
     * @param url destination URL
     * @param email email value of JSON
     * @param name name value of JSON
     * @param average  average value of JSON
     * @param femaleCS Female student IDS as part of the JSON object
     */
    public void sendPost(String url, String email, String name, int average, ArrayList<String> femaleCS){
        try {
            java.net.URL urlPath = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlPath.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setRequestProperty("Accept", "application/json");

            connection.setDoOutput(true);

            JSONObject json = new JSONObject();

            json.put("id",email);
            json.put("name", name);
            json.put("average", average);
            json.put("studentIds", femaleCS);


            OutputStream os = connection.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(os, "UTF-8");
            writer.write(json.toString());
            writer.flush();
            writer.close();
            os.close();

            System.out.println(connection.getResponseCode());
            System.out.println(connection.getResponseMessage());
        }
        catch(MalformedURLException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
