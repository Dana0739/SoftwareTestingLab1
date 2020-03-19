package services;

import com.sun.tools.javac.util.List;
import model.WebScrapperState;
import model.enums.DocumentPartTypes;
import model.enums.OutputFileTypes;
import model.enums.OutputTypes;

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

        String filename = ;

        return WebScrapperState(documentPartType, outputType, outputFileType, filename, url);
    }

    private static String parseUrl(String url) {
        //regexp
        //exception
        return url;
    }
}
