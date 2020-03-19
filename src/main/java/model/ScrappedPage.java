package model;

import org.jsoup.nodes.Document;

public class ScrappedPage {

    private final Document content; //todo String?? Byte?

    private final String filename;

    public ScrappedPage(String url, Document content) {
        this.content = content;
        this.filename = null;
    }

    public ScrappedPage(String url, Document content, String filename) {
        this.content = content;
        this.filename = filename;
    }

    public Document getContent() {
        return content;
    }

    public String getFilename() {
        return filename;
    }

}
