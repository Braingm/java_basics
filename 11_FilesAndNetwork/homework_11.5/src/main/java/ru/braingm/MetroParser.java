package ru.braingm;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.nio.file.Paths;

public class MetroParser {
    public static JSONObject parse(String URL) throws IOException {
        Document doc;

//        try {
//            doc = Jsoup.connect(URL).maxBodySize(0).get();
//        } catch (HttpStatusException e){
        doc = Jsoup.parse(Paths.get("src/main/resources/metro.html").toFile(), "UTF-8");
//        }

        JSONObject outJson = new JSONObject();
        outJson.put("lines", parseLines(doc));
        outJson.put("stations", parseStations(doc));

        return outJson;
    }

    private static JSONArray parseLines(Document doc) {
        JSONArray lines = new JSONArray();
        var elementsLine = doc.body().select("#metrodata span.js-metro-line");
        elementsLine.forEach(element -> {
            JSONObject line = new JSONObject();
            line.put("number", element.attr("data-line"));
            line.put("name", element.text());

            lines.add(line);
        });

        return lines;
    }

    private static JSONObject parseStations(Document doc) {
        JSONObject stations = new JSONObject();

        var elementsStations = doc.body().select("div.js-metro-stations");
        elementsStations.forEach(element -> {
            JSONArray line = new JSONArray();
            stations.put(element.attr("data-line"), line);
            var stationsList = element.select("p");
            stationsList.forEach(element1 -> line.add(element1.select("span.name").text()));
        });

        return stations;
    }
}
