package model.enums;

import java.util.ArrayList;
import java.util.Arrays;

public enum OutputTypes {
    FILE("-f"),
    CONSOLE("-c");

    private String title;

    OutputTypes(String title) {
        if (title == null || title.equals("")) {
            this.title = "-c";
        } else {
            this.title = title;
        }
    }

    public String getTitle() {
        return title;
    }

    public static ArrayList<String> getAll() {
        return new ArrayList<String>(Arrays.asList("-f", "-c"));
    }
}
