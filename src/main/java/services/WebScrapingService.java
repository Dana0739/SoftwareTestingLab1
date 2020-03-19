package services;

import model.ScrappedPage;
import model.WebScrapperState;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WebScrapingService {

    public static ScrappedPage Scrap(WebScrapperState state) throws IOException {
        Document doc = Jsoup.connect(state.getUrl()).get();
        doc.
    }

}
