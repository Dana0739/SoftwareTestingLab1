package model;

import lombok.Data;
import model.enums.DocumentPartTypes;
import model.enums.OutputFileTypes;
import model.enums.OutputTypes;

@Data
public class WebScrapperState {

    private final DocumentPartTypes documentPartType;

    private final OutputTypes outputType;

    private final OutputFileTypes outputFileType;

    private final String filename;

    private final String url;
}
