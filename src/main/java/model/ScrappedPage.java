package model;

import lombok.Data;

@Data
public class ScrappedPage {

    private final String content;

    private final String filename;

    public ScrappedPage(String content) {
        this.content = content;
        this.filename = null;
    }

    public ScrappedPage(String content, String filename) {
        this.content = content;
        this.filename = filename;
    }
}
