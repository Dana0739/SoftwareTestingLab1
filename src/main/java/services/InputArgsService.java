package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.WebScrapperState;
import model.enums.DocumentPartTypes;
import model.enums.OutputFileTypes;
import model.enums.OutputTypes;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputArgsService {

    public static WebScrapperState parse(String[] args) {
        DocumentPartTypes documentPartType = DocumentPartTypes.getByTitle(getTitle(args, DocumentPartTypes.getAll()));
        OutputFileTypes outputFileType = OutputFileTypes.getByTitle(getTitle(args, OutputFileTypes.getAll()));
        OutputTypes outputType = OutputTypes.getByTitle(getTitle(args, OutputTypes.getAll()));
        String url = parseUrl(args[0]);
        String filename;

        if (args.length == 1) {
            filename = null;
        } else {
            if (OutputTypes.getAll().contains(args[1]) || DocumentPartTypes.getAll().contains(args[1])) { // -c / -f / -text / -body / -head / -all
                if (args.length == 2) {
                    filename = null;
                } else {
                    if (OutputTypes.getAll().contains(args[1])) { // -c / -f
                        if (args[1].equals(OutputTypes.CONSOLE.getTitle())) { //CONSOLE -c
                            filename = proceedContentTypeAfterConsole(args);
                        } else { //FILE -f
                            if (args.length == 3) {
                                filename = proceed3args(args);
                            } else if (args.length == 4) {
                                filename = proceed4args(args);
                            } else { // args.length == 5
                                filename = proceed5Args(args);
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("You can write other args only after "
                                + "output type command (-c or -f)! For help use command -h.");
                    }
                }
            } else {
                throw new IllegalArgumentException("You must write output type command or part of scrapping page "
                        + "after URL! For help use command -h.");
            }
        }

        if (outputType.equals(OutputTypes.FILE)) {
            filename = parseFilename(filename, url, outputFileType);
        }

        return new WebScrapperState(documentPartType, outputType, outputFileType, filename, url);
    }


    private static String getTitle(String[] args, ArrayList<String> allTypes) {
        return nullSafeGet(
                Arrays.stream(args)
                        .filter(allTypes::contains)
                        .collect(Collectors.toList()), 0);
    }


    private static String nullSafeGet(List<String> list, int i) {
        if (list.isEmpty()) return null;
        return list.get(i);
    }


    private static String parseUrl(String url) {
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        if (Pattern.matches(regex, url)) {
            return url;
        } else {
            throw new IllegalArgumentException("Invalid URL! Please, write URL correctly. For help use command -h.");
        }
    }


    private static String proceedContentTypeAfterConsole(String[] args) {
        if (DocumentPartTypes.getAll().contains(args[2])) { // -text / -body / -head / -all
            return null;
        } else {
            throw new IllegalArgumentException("After -c output type you can write only "
                    + "scrapping document part argument! (-text / -body / -head / -all) "
                    + "For help use command -h.");
        }
    }


    // (-text / -body / -head / -all) OR (-txt / -html / -xml)
    private static String proceed3args(String[] args) {
        if (DocumentPartTypes.getAll().contains(args[2]) || OutputFileTypes.getAll().contains(args[2])) {
            return null;
        } else {
            return args[2]; // filename
        }
    }


    private static String proceed4args(String[] args) {
        if (DocumentPartTypes.getAll().contains(args[2])) { // -text / -body / -head / -all
            if (OutputFileTypes.getAll().contains(args[3])) {
                return null; // -txt / -html / -xml
            } else {
                return args[3]; // filename
            }
        } else if (OutputFileTypes.getAll().contains(args[2])) { // -txt / -html / -xml
            return args[3]; // filename
        } else {
            throw new IllegalArgumentException("After -f must be part of scrapping page "
                    + "or file type argument before filename! For help use command -h.");
        }
    }


    private static String proceed5Args(String[] args) {
        String exceptionMessage = "You must write arguments in order: "
                + "url, -f, part of scrapping page argument, file type argument, " +
                "filename! For help use command -h.";

        if (DocumentPartTypes.getAll().contains(args[2]) && // -text / -body / -head / -all
            OutputFileTypes.getAll().contains(args[3])) { // -txt / -html / -xml
            return args[4]; // filename
        } else {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }


    private static String parseFilename(String filename, String url, OutputFileTypes outputFileType) {
        if (filename == null) {
            filename = url.replace("\\", "").replace("/", "");
        }
        String regex = ".*\\." + outputFileType.getType().replace(".", "") + "$";
        if (Pattern.matches(regex, filename)) {
            return filename;
        } else {
            return filename + outputFileType.getType();
        }
    }
}
