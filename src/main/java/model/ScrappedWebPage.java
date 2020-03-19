package model;

import org.jsoup.nodes.Document;

public class ScrappedWebPage {

    private final String url;

    private final Document content; //TODO String???

    private final String filename;

    public ScrappedWebPage (String url, Document content) {
        this.url = url;
        this.content = content;
        this.filename = null;
    }

    public ScrappedWebPage (String url, Document content, String filename) {
        this.url = url;
        this.content = content;
        this.filename = filename;
    }

    public Document getContent() {
        return content;
    }

    public String getFilename() {
        return filename;
    }

    public String getUrl() {
        return url;
    }
}
