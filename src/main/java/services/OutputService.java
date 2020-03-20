package services;

import model.ScrappedPage;
import model.WebScrapperState;
import model.enums.OutputTypes;

import java.io.FileWriter;
import java.io.IOException;

public class OutputService {

    public static void Output(WebScrapperState state, ScrappedPage page) {
        if (state.getOutputType().equals(OutputTypes.FILE)) {
            FileOutput(page);
        } else {
            ConsoleOutput(page);
        }
    }

    private static void FileOutput(ScrappedPage page) {
        try {
            FileWriter myWriter = new FileWriter(page.getFilename());
            myWriter.write(page.getContent());
            myWriter.close();
            System.out.println("Successfully wrote to the file: " + page.getFilename());
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void ConsoleOutput(ScrappedPage page) {
        System.out.println("\nContent: \n" + page.getContent());
    }

    public static void ConsoleHelp() {
        System.out.println("Usage of Dana's web scraping program:\n" +
                "\n" +
                "[-h]\n" +
                "[<URL> (-text / -body / -head / -all)]\n" +
                "[<URL> -c (-text / -body / -head / -all)]\n" +
                "[<URL> -f (-text / -body / -head / -all) (-txt / -html / -xml) (<output file name>)]\n" +
                "\n" +
                "-h                      - call this info\n" +
                "<URL>                   - download content from resource by this URL\n" +
                "\n" +
                "        (Output type commands)\n" +
                "-c                      - output in console (by default)\n" +
                "-f                      - save downloaded content to file with filename equals to URL\n" +
                "\n" +
                "        (Part type of downloading content arguments)\n" +
                "-text                   - downloading text data without html tags\n" +
                "-body                   - downloading html data from body\n" +
                "-head                   - downloading html data from head\n" +
                "-all                    - downloading whole html page\n" +
                "\n" +
                "        (Output file type arguments)\n" +
                "-txt                    - saving data in .txt file\n" +
                "-html                   - saving data in .html file\n" +
                "-xml                    - saving data in .xml file\n" +
                "\n" +
                "<output file name>      - save downloaded data to file with this name\n" +
                "\n" +
                "REMEMBER! The order is necessary!\n");
    }
}
