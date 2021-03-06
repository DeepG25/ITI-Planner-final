package royal.com.itiplanner.models;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import royal.com.itiplanner.R;

public class PlacesApi {

    public ArrayList<String> autoComplete(String input){
        ArrayList<String> arrayList = new ArrayList();
        HttpURLConnection connection = null;
        StringBuilder jsonResult = new StringBuilder();
        try{
            StringBuilder sb = new StringBuilder("https://maps.googleapis.com/maps/api/place/autocomplete/json?");
            sb.append("input=" + input);
            sb.append("&key=AIzaSyCQXqjK34UVxzTQW2zH9oB3WimKrYVHGpo");

            URL url = new URL(sb.toString());
            connection = (HttpURLConnection)url.openConnection();
            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());

            int read;

            char[] buffer = new char[1024];
            while((read = inputStreamReader.read(buffer)) != -1)
            {
                jsonResult.append(buffer,0,read);
            }
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(connection != null)
            {
                connection.disconnect();
            }
        }

        try{
            JSONObject jsonObject = new JSONObject(jsonResult.toString());
            JSONArray prediction = jsonObject.getJSONArray("predictions");
            for (int i=0;i<prediction.length();i++){
                arrayList.add(prediction.getJSONObject(i).getString("description"));
                Log.d("Place" + i,arrayList.get(i));
            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        return arrayList;
    }

    public ArrayList<SearchPlace> SearchPlaceCustomize(String input){
        ArrayList<SearchPlace> arrayList = new ArrayList<SearchPlace>();

        HttpURLConnection connection = null;
        StringBuilder jsonResult = new StringBuilder();
        try{

            //connection = (HttpURLConnection)url.openConnection();
            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());

            int read;

            char[] buffer = new char[1024];
            while((read = inputStreamReader.read(buffer)) != -1)
            {
                jsonResult.append(buffer,0,read);
            }
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(connection != null)
            {
                connection.disconnect();
            }
        }

        try{
            JSONObject jsonObject = new JSONObject(jsonResult.toString());

        }
        catch (JSONException e){
            e.printStackTrace();
        }

        return arrayList;
    }
}
