package edu.depaul.wberthou;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Main {

    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader();
        String json = reader.readFile("campus.json");


        Gson gson = new Gson();
        JsonObject j = new JsonObject();



    }

}