package services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WebScrapingService {
    public static String Scrap(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        doc.
    }
}
