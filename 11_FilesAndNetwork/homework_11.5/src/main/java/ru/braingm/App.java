package ru.braingm;

import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    static String metroUrl = "https://www.moscowmap.ru/metro.html#lines";
    static File jsonFile = new File("src/main/resources/test.json");

    public static void main(String[] args) {
        try {
            JSONObject result = MetroParser.parse(metroUrl);

            FileWriter jsonWriter = new FileWriter(jsonFile);
            result.writeJSONString(jsonWriter);
            jsonWriter.flush();
            jsonWriter.close();

            JsonReader.readLinesSize(jsonFile.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}