package ru.braingm;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonReader {
    public static void readLinesSize(String filePath){
        JSONParser parser = new JSONParser();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder sb = new StringBuilder();
            reader.lines().forEach(sb::append);
            JSONObject readJson = (JSONObject) parser.parse(sb.toString());
            JSONObject result = (JSONObject) readJson.get("stations");

            var keySet = result.keySet();
            for (Object key : keySet){
                JSONArray value = (JSONArray) result.get(key);
                System.out.println(value.size());
            }

        } catch (ParseException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
