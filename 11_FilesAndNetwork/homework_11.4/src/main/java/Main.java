import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {
    private static String pageLink = "https://lenta.ru";

    @SneakyThrows
    public static void main(String[] args) {
        Document doc = Jsoup.connect(pageLink).get();

        var prt = doc.getElementsByTag("img");

        System.out.println(prt.isEmpty());
        System.out.println(prt.attr("src"));
    }
}
