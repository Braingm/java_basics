import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileOutputStream;

public class Main {
    private static String pageLink = "https://lenta.ru";

    @SneakyThrows
    public static void main(String[] args) {
        Document doc = Jsoup.connect(pageLink).get();

        var prt = doc.getElementsByTag("img");

        prt.eachAttr("src").stream().filter(s -> s.matches(".+\\.jpg"))
                .forEach(s -> {
                    try {

                        var parts = s.split("/");
                        var file = new File("src/main/resources/" + parts[parts.length - 1]);

                        var img = Jsoup.connect(s).ignoreContentType(true).execute();

                        var out = new FileOutputStream(file);
                        out.write(img.bodyAsBytes());
                        out.close();

                        System.out.println(s);

                    } catch (Exception ignored) {
                    }
                });
    }
}
