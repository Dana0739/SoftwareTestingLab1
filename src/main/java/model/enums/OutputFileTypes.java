package model.enums;

import java.util.ArrayList;
import java.util.Arrays;

public enum OutputFileTypes {
    TXT("-txt"),
    HTML("-html"),
    XML("-xml");

    private String title;

    OutputFileTypes(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return "." + title.substring(1, title.length() - 1);
    }

    public static ArrayList<String> getAll() {
        return new ArrayList<>(Arrays.asList("-txt", "-html", "-xml"));
    }

    public static OutputFileTypes getByTitle(String title) {
        if (title == null) return TXT;
        switch (title) {
            case "-html": return HTML;
            case "-xml": return XML;
            case "-txt":
            case "":
                return TXT;
            default: return null;
        }
    }
}
