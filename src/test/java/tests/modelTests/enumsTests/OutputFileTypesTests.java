package tests.modelTests.enumsTests;

import model.enums.OutputFileTypes;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputFileTypesTests {
    @Test
    public void OutputFileTypes_Txt_Test() {
        assertEquals(OutputFileTypes.TXT, OutputFileTypes.valueOf("TXT"));
    }

    @Test
    public void OutputFileTypes_Xml_Test() {
        assertEquals(OutputFileTypes.XML, OutputFileTypes.valueOf("XML"));
    }

    @Test
    public void OutputFileTypes_Html_Test() {
        assertEquals(OutputFileTypes.HTML, OutputFileTypes.valueOf("HTML"));
    }

    @Test
    public void getTitle_Txt_Test() {
        assertEquals(OutputFileTypes.TXT.getTitle(), "-txt");
    }

    @Test
    public void getTitle_Xml_Test() {
        assertEquals(OutputFileTypes.XML.getTitle(), "-xml");
    }

    @Test
    public void getTitle_Html_Test() {
        assertEquals(OutputFileTypes.HTML.getTitle(), "-html");
    }

    @Test
    public void getByTitle_Txt_Test() {
        assertEquals(OutputFileTypes.TXT, OutputFileTypes.getByTitle("-txt"));
    }

    @Test
    public void getByTitle_Txt_Null_Test() {
        assertEquals(OutputFileTypes.TXT, OutputFileTypes.getByTitle(null));
    }

    @Test
    public void getByTitle_Txt_Empty_Test() {
        assertEquals(OutputFileTypes.TXT, OutputFileTypes.getByTitle(""));
    }

    @Test
    public void getByTitle_Xml_Test() {
        assertEquals(OutputFileTypes.XML, OutputFileTypes.getByTitle("-xml"));
    }

    @Test
    public void getByTitle_Html_Test() {
        assertEquals(OutputFileTypes.HTML, OutputFileTypes.getByTitle("-html"));
    }

    @Test
    public void getAllTest() {
        assertEquals(OutputFileTypes.getAll(), new ArrayList<>(Arrays.asList("-txt", "-html", "-xml")));
    }
}
