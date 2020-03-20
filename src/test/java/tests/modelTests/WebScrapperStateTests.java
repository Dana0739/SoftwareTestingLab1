package tests.modelTests;

import model.WebScrapperState;
import model.enums.DocumentPartTypes;
import model.enums.OutputFileTypes;
import model.enums.OutputTypes;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebScrapperStateTests {

    private static final WebScrapperState webScrapperState = new WebScrapperState(DocumentPartTypes.ALL,
            OutputTypes.FILE, OutputFileTypes.HTML, "myFile.html", "https://myUrl.com");

    @Test
    public void getUrlTest() {
        assertEquals(webScrapperState.getUrl(), "https://myUrl.com");
    }

    @Test
    public void getFilenameTest() {
        assertEquals(webScrapperState.getFilename(), "myFile.html");
    }

    @Test
    public void getDocumentPartTypeTest() {
        assertEquals(webScrapperState.getDocumentPartType(), DocumentPartTypes.ALL);
    }

    @Test
    public void getOutputTypeTest() {
        assertEquals(webScrapperState.getOutputType(), OutputTypes.FILE);
    }

    @Test
    public void getOutputFileTypeTest() {
        assertEquals(webScrapperState.getOutputFileType(), OutputFileTypes.HTML);
    }
}
