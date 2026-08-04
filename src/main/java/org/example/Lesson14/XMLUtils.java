package org.example.Lesson14;

public class XMLUtils {

    public static String createEmptyElement(String tagName) {
        if (tagName == null || tagName.isEmpty()) {
            return "<invalid/>";
        } else {
            return "<" + tagName + ">" + "</" + tagName + ">";
        }
    }
}
