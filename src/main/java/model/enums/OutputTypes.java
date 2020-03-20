package model.enums;

import java.util.ArrayList;
import java.util.Arrays;

public enum OutputTypes {
    FILE("-f"),
    CONSOLE("-c");

    private String title;

    OutputTypes(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static ArrayList<String> getAll() {
        return new ArrayList<>(Arrays.asList("-f", "-c"));
    }

    public static OutputTypes getByTitle(String title) {
        if (title == null) return CONSOLE;
        switch (title) {
            case "-f": return FILE;
            case "-c":
            case "":
                return CONSOLE;
            default: return null;
        }
    }
}
