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
        if (title == null || title.equals("")) {
            this.title = "-all";
        } else {
            this.title = title;
        }
    }

    public String getTitle() {
        return title;
    }

    public static ArrayList<String> getAll() {
        return new ArrayList<String>(Arrays.asList("-all", "-head", "-body", "-text"));
    }
}
