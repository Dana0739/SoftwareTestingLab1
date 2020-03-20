package model.enums;

import java.util.ArrayList;
import java.util.Arrays;

public enum DocumentPartTypes {
    ALL("-all"),
    HEAD("-head"),
    BODY("-body"),
    TEXT("-text");

    private String title;

    DocumentPartTypes(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static ArrayList<String> getAll() {
        return new ArrayList<>(Arrays.asList("-all", "-head", "-body", "-text"));
    }

    public static DocumentPartTypes getByTitle(String title) {
        if (title == null) return ALL;
        switch (title) {
            case "-head": return HEAD;
            case "-body": return BODY;
            case "-text": return TEXT;
            case "-all":
            case "":
                return ALL;
            default: return null;
        }
    }
}
