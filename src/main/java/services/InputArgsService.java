package services;

import com.sun.tools.javac.util.List;
import model.WebScrapperState;
import model.enums.DocumentPartTypes;
import model.enums.OutputFileTypes;
import model.enums.OutputTypes;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputArgsService {

    public static WebScrapperState parse(String[] args) {
        DocumentPartTypes documentPartType = DocumentPartTypes.valueOf(
                List.from(args).stream()
                        .filter(x -> DocumentPartTypes.getAll().contains(x))
                        .collect(Collectors.toList()).get(0));

        OutputFileTypes outputFileType = OutputFileTypes.valueOf(
                List.from(args).stream()
                        .filter(x -> OutputFileTypes.getAll().contains(x))
                        .collect(Collectors.toList()).get(0));

        OutputTypes outputType = OutputTypes.valueOf(
                List.from(args).stream()
                        .filter(x -> OutputTypes.getAll().contains(x))
                        .collect(Collectors.toList()).get(0));

        String url = parseUrl(args[0]);
        String filename;

        switch (args.length) {

            case 1:
                filename = null;
                break;

            case 2:
            case 3:
            case 4:
            case 5:
                if (OutputTypes.getAll().contains(args[1]) || DocumentPartTypes.getAll().contains(args[1])) { // -c / -f / -text / -body / -head / -all
                    if (args.length == 2) {
                        filename = null;
                    } else {
                        if (OutputTypes.getAll().contains(args[1])) { // -c / -f
                            if (args[1].equals(OutputTypes.CONSOLE.getTitle())) { //CONSOLE -c
                                if (DocumentPartTypes.getAll().contains(args[2])) { // -text / -body / -head / -all
                                    filename = null;
                                } else {
                                    throw new IllegalArgumentException("After -c output type you can write only "
                                            + "scrapping document part argument! (-text / -body / -head / -all) "
                                            + "For help use command -h.");
                                }

                            } else { //FILE -f
                                if (args.length == 3) { // (-text / -body / -head / -all) OR (-txt / -html / -xml)
                                    if (DocumentPartTypes.getAll().contains(args[2]) || OutputTypes.getAll().contains(args[2])) {
                                        filename = null;
                                    } else {
                                        filename = args[2]; // filename
                                    }

                                } else if (args.length == 4) {
                                    if (DocumentPartTypes.getAll().contains(args[2])) { // -text / -body / -head / -all
                                        if (OutputTypes.getAll().contains(args[3])) {
                                            filename = null; // -txt / -html / -xml
                                        } else {
                                            filename = args[3]; // filename
                                        }
                                    } else if (OutputTypes.getAll().contains(args[2])) { // -txt / -html / -xml
                                        filename = args[3]; // filename
                                    } else {
                                        throw new IllegalArgumentException("After -f must be part of scrapping page "
                                                + "or file type argument before filename! For help use command -h.");
                                    }

                                } else { // args.length == 5
                                    if (DocumentPartTypes.getAll().contains(args[2])) { // -text / -body / -head / -all
                                        if (OutputTypes.getAll().contains(args[3])) { // -txt / -html / -xml
                                            filename = args[4]; // filename
                                        } else {
                                            throw new IllegalArgumentException("You must write arguments in order: "
                                                    + "url, -f, part of scrapping page argument, file type argument, " +
                                                    "filename! For help use command -h.");
                                        }
                                    } else {
                                        throw new IllegalArgumentException("You must write arguments in order: "
                                                + "url, -f, part of scrapping page argument, file type argument, " +
                                                "filename! For help use command -h.");
                                    }
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
                break;

            default:
                throw new IllegalArgumentException("You can’t input more than 5 parameters! For help use command -h.");
        }

        if (outputType.equals(OutputTypes.FILE)) {
            filename = parseFilename(filename, url, outputFileType);
        }

        return new WebScrapperState(documentPartType, outputType, outputFileType, filename, url);
    }

    private static String parseUrl(String url) {
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        if (Pattern.matches(regex, url)) {
            return url;
        } else {
            throw new IllegalArgumentException("Invalid URL! Please, write URL correctly. For help use command -h.");
        }
    }

    private static String parseFilename(String filename, String url, OutputFileTypes outputFileType) {
        if (filename == null) {
            return url + outputFileType.getType();
        } else {
            String regex = "^*" + outputFileType.getType() + "$";
            if (Pattern.matches(regex, filename)) {
                return filename;
            } else {
                return filename + outputFileType.getType();
            }
        }
    }
}
