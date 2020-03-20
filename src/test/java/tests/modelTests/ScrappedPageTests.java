package tests.modelTests;

import model.ScrappedPage;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ScrappedPageTests {
    private static final ScrappedPage scrapedPage = new ScrappedPage("content", "filename.txt");

    private static final ScrappedPage emptyScrapedPage = new ScrappedPage("");

    @Test
    public void getFilenameTest() {
        assertEquals(scrapedPage.getFilename(), "filename.txt");
    }

    @Test
    public void getContentTest() {
        assertEquals(scrapedPage.getContent(), "content");
    }

    @Test
    public void getEmptyFilenameTest() {
        assertNull(emptyScrapedPage.getFilename());
    }

    @Test
    public void getEmptyContentTest() {
        assertEquals(emptyScrapedPage.getContent(), "");
    }
}
