package tests.servicesTests;

import model.WebScrapperState;
import model.enums.DocumentPartTypes;
import model.enums.OutputFileTypes;
import model.enums.OutputTypes;
import org.junit.Test;
import services.InputArgsService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputArgsServiceTest {

    @Test
    public void parseTest_Url() {
        assertEquals(InputArgsService.parse(new String[]{"https://google.com"}),
                new WebScrapperState(DocumentPartTypes.ALL, OutputTypes.CONSOLE, OutputFileTypes.TXT, null, "https://google.com"));
    }

    @Test
    public void parseTest_Url_negative() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> InputArgsService.parse(new String[]{"wrong url"}));
        assertEquals(exception.getMessage(), "Invalid URL! Please, write URL correctly. For help use command -h.");
    }

    @Test
    public void parseTest_Url_f() {
        assertEquals(InputArgsService.parse(new String[]{"https://google.com", "-f"}),
                new WebScrapperState(DocumentPartTypes.ALL, OutputTypes.FILE, OutputFileTypes.TXT, "https:google.com.txt", "https://google.com"));
    }

    @Test
    public void parseTest_Url_body() {
        assertEquals(InputArgsService.parse(new String[]{"https://google.com", "-body"}),
                new WebScrapperState(DocumentPartTypes.BODY, OutputTypes.CONSOLE, OutputFileTypes.TXT, null, "https://google.com"));
    }

    @Test
    public void parseTest_Url_2nd_arg_negative() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> InputArgsService.parse(new String[]{"https://google.com", "something"}));
        assertEquals(exception.getMessage(), "You must write output type command or part of scrapping page after URL! For help use command -h.");
    }

    @Test
    public void parseTest_Url_3rd_arg_negative() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> InputArgsService.parse(new String[]{"https://google.com", "-all", "something"}));
        assertEquals(exception.getMessage(), "You can write other args only after output type command (-c or -f)! For help use command -h.");
    }

    @Test
    public void parseTest_Url_c_all() {
        assertEquals(InputArgsService.parse(new String[]{"https://google.com", "-c", "-all"}),
                new WebScrapperState(DocumentPartTypes.ALL, OutputTypes.CONSOLE, OutputFileTypes.TXT, null, "https://google.com"));
    }

    @Test
    public void parseTest_Url_c_3rd_arg_negative() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> InputArgsService.parse(new String[]{"https://google.com", "-c", "something"}));
        assertEquals(exception.getMessage(), "After -c output type you can write only scrapping document part argument! (-text / -body / -head / -all) For help use command -h.");
    }

    @Test
    public void parseTest_Url_f_text() {
        assertEquals(InputArgsService.parse(new String[]{"https://google.com", "-f", "-text"}),
                new WebScrapperState(DocumentPartTypes.TEXT, OutputTypes.FILE, OutputFileTypes.TXT, "https:google.com.txt", "https://google.com"));
    }

    @Test
    public void parseTest_Url_f_html() {
        assertEquals(InputArgsService.parse(new String[]{"https://mysite.html", "-f", "-html"}),
                new WebScrapperState(DocumentPartTypes.ALL, OutputTypes.FILE, OutputFileTypes.HTML, "https:mysite.html", "https://mysite.html"));
    }

    @Test
    public void parseTest_Url_f_filename() {
        assertEquals(InputArgsService.parse(new String[]{"https://mysite.html", "-f", "something"}),
                new WebScrapperState(DocumentPartTypes.ALL, OutputTypes.FILE, OutputFileTypes.TXT, "something.txt", "https://mysite.html"));
    }

    @Test
    public void parseTest_Url_f_head_html() {
        assertEquals(InputArgsService.parse(new String[]{"https://mysite.html", "-f", "-head", "-html"}),
                new WebScrapperState(DocumentPartTypes.HEAD, OutputTypes.FILE, OutputFileTypes.HTML, "https:mysite.html", "https://mysite.html"));
    }

    @Test
    public void parseTest_Url_f_head_filename() {
        assertEquals(InputArgsService.parse(new String[]{"https://mysite.html", "-f", "-head", "something"}),
                new WebScrapperState(DocumentPartTypes.HEAD, OutputTypes.FILE, OutputFileTypes.TXT, "something.txt", "https://mysite.html"));
    }

    @Test
    public void parseTest_Url_f_xml_filename() {
        assertEquals(InputArgsService.parse(new String[]{"https://mysite.html", "-f", "-xml", "something"}),
                new WebScrapperState(DocumentPartTypes.ALL, OutputTypes.FILE, OutputFileTypes.XML, "something.xml", "https://mysite.html"));
    }

    @Test
    public void parseTest_Url_f_3rd_arg_negative_filename() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> InputArgsService.parse(new String[]{"https://mysite.html", "-f", "negative", "something"}));
        assertEquals(exception.getMessage(), "After -f must be part of scrapping page or file type argument before filename! For help use command -h.");
    }

    @Test
    public void parseTest_Url_f_body_xml_filename() {
        assertEquals(InputArgsService.parse(new String[]{"https://mysite.html", "-f", "-body", "-xml", "something"}),
                new WebScrapperState(DocumentPartTypes.BODY, OutputTypes.FILE, OutputFileTypes.XML, "something.xml", "https://mysite.html"));
    }

    @Test
    public void parseTest_Url_f_3rd_arg_negative_something_something() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> InputArgsService.parse(new String[]{"https://mysite.html", "-f", "-txt", "something", "something"}));
        assertEquals(exception.getMessage(), "You must write arguments in order: url, -f, part of scrapping page argument, file type argument, filename! For help use command -h.");
    }

    @Test
    public void parseTest_Url_f_body_4rth_arg_negative_something() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> InputArgsService.parse(new String[]{"https://mysite.html", "-f", "-body", "negative", "something"}));
        assertEquals(exception.getMessage(), "You must write arguments in order: url, -f, part of scrapping page argument, file type argument, filename! For help use command -h.");
    }
}
