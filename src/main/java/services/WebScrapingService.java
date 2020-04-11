package services;

import model.ScrappedPage;
import model.WebScrapperState;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WebScrapingService {

    public static ScrappedPage scrap(WebScrapperState state) {
        try {

            Document doc = Jsoup.connect(state.getUrl()).get();

            String content = "";
            switch (state.getDocumentPartType()) {

                case ALL:
                    content = doc.html();
                    break;

                case BODY:
                    content = doc.body().html();
                    break;

                case HEAD:
                    content = doc.head().html();
                    break;

                case TEXT:
                    content = doc.text();
                    break;

            }

            if (state.getFilename() == null) {
                return new ScrappedPage(content);
            } else {
                return new ScrappedPage(content, state.getFilename());
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            throw new IllegalArgumentException("This URL address doesn't exist!");
        }
    }
}
