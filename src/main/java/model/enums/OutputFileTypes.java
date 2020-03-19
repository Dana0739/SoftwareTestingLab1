package model.enums;

import java.util.ArrayList;
import java.util.Arrays;

public enum OutputFileTypes {
    TXT("-txt"),
    HTML("-html"),
    XML("-xml");

    private String title;

    OutputFileTypes(String title) {
        if (title == null || title.equals("")) {
            this.title = "-txt";
        } else {
            this.title = title;
        }
    }

    public String getTitle() {
        return title;
    }

    public static ArrayList<String> getAll() {
        return new ArrayList<String>(Arrays.asList("-txt", "-html", "-xml"));
    }
}
