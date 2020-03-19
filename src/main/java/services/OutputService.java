package services;

import model.ScrappedPage;
import model.WebScrapperState;

public class OutputService {

    public static void Output(WebScrapperState state, ScrappedPage page) {
        //todo write
    }

    private static void FileOutput(ScrappedPage page) { //todo rewrite
        if (page.getFilename() != null) {

        } else {

        }
    }

    private static void ConsoleOutput(ScrappedPage page) {
        System.out.println("Content: \n" + page.getContent());
    }

    public static void ConsoleHelp() { //todo rewrite
        System.out.println("\nUsage of Dana's web scraping program:\n"
                + "[-h] [<URL>] [<URL> -c] [<URL> -f] [<URL> -f <filename>]\n\n"
                + "-h\t\t\t- call this info\n"
                + "<URL>\t\t\t- download HTML / XML content from resource by this URL and output in console (by default)\n"
                + "<URL> -c\t\t- download HTML / XML content from resource by this URL and output in console\n"
                + "<URL> -f\t\t- download HTML / XML content from resource by this URL " +
                "and save it to file with filename equals to URL\n"
                + "<URL> -f <filename>\t- download HTML / XML content from resource by this URL " +
                "and save it to file with filename equals to filename\n");
    }
}
