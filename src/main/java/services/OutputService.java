package services;

import model.ScrappedWebPage;

public class OutputService {
    public static void FileOutput(ScrappedWebPage page) {
        if (page.getFilename() != null) {

        } else {

        }
    }

    public static void ConsoleOutput(ScrappedWebPage page) {
        System.out.println("URL: " + page.getUrl());
        System.out.println("Content: \n" + page.getContent());
    }

    public static void ConsoleHelp() {
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
