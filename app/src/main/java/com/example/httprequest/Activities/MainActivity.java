package com.example.httprequest.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.httprequest.Model.Cities;
import com.example.httprequest.Model.City;
import com.example.httprequest.Model.Temperature;
import com.example.httprequest.Model.Town;
import com.example.httprequest.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String json = "{\"id\":0,\"name\":\"La cruz\"}";

        /* forma nativa para json*/
        try {
            JSONObject mJson = new JSONObject(json);
            String name = mJson.getString("name");
            int id = mJson.getInt("id");
            Temperature temperature = new Temperature(1,1,1,1,1,1);
            City city = new City(id,name,temperature);


           // Toast.makeText(this,"City:"+city.getId()+"---"+city.getName(),Toast.LENGTH_SHORT).show();

        }catch (JSONException e) {
            e.printStackTrace();
        }


        /* usando libreria GSON*/

        Gson gson = new Gson();
        City city = gson.fromJson(json,City.class);
        //Toast.makeText(this,"City: "+city.getId()+"-"+city.getName(),Toast.LENGTH_SHORT).show();

        /*Gson usando anotación expose en el atributo name*/
        Gson gson2 = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        city = gson2.fromJson(json,City.class);
        //Toast.makeText(this,"City: "+city.getId()+"-"+city.getName(),Toast.LENGTH_SHORT).show();



        /*Gson usando un JSON con un nodo hijo*/
        String json2 =
                "{" +
                        "id: 0,"+
                        "city: {"+
                                "id: 1,"+
                                "name: 'London'"+
                                "}"+
                        "}";


        Gson gson3 = new GsonBuilder().create();
        Town town = gson3.fromJson(json2,Town.class);
        //Toast.makeText(this,"City: "+town.getCity().getId()+"-"+town.getCity().getName(),Toast.LENGTH_SHORT).show();

        String json3 =
                "{" +
                        "id: 0,"+
                        "ciudades: [{"+
                            "id: 1,"+
                            "name: 'London'"+
                            "},"+
                            "{"+
                                "id: 2,"+
                                "name: 'Brazil'"+
                            "}]"+
                "}";
        Gson gson4 = new GsonBuilder().create();
        Cities cities = gson4.fromJson(json3,Cities.class);
    }
}
