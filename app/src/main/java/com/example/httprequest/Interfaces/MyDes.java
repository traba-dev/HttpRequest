package com.example.httprequest.Interfaces;

import com.example.httprequest.Model.Ciudad;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class MyDes implements JsonDeserializer<Ciudad> {


    @Override
    public Ciudad deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        String country = json.getAsJsonObject().get("sys").getAsJsonObject().get("country").getAsString();
        String name = json.getAsJsonObject().get("name").getAsString();
        int id = json.getAsJsonObject().get("id").getAsInt();



        Ciudad ciudad = new Ciudad(id,name,country);
        return ciudad;
    }
}
