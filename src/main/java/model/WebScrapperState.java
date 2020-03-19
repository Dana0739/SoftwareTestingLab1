package model;

import model.enums.DocumentPartTypes;
import model.enums.OutputFileTypes;
import model.enums.OutputTypes;

public class WebScrapperState {

    private final DocumentPartTypes documentPartType;

    private final OutputTypes outputType;

    private final OutputFileTypes outputFileType;

    private final String filename;

    private final String url;

    public WebScrapperState(DocumentPartTypes documentPartType, OutputTypes outputType,
                            OutputFileTypes outputFileType, String filename, String url) {
        this.documentPartType = documentPartType;
        this.outputType = outputType;
        this.outputFileType = outputFileType;
        this.filename = filename;
        this.url = url;
    }

    public DocumentPartTypes getDocumentPartType() {
        return documentPartType;
    }

    public OutputTypes getOutputType() {
        return outputType;
    }

    public OutputFileTypes getOutputFileType() {
        return outputFileType;
    }

    public String getFilename() {
        return filename;
    }

    public String getUrl() {
        return url;
    }
}
