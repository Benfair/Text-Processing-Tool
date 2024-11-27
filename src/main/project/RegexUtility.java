package main.project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtility {
    public static String findMatches(String text, String regex) {
        StringBuilder result = new StringBuilder("Finding Matches...\n");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean found = false;

        while (matcher.find()) {
            result.append(String.format("Match: %s at position [%d, %d]%n",
                    matcher.group(), matcher.start(), matcher.end()));
            found = true;
        }
        if (!found) {
            result.append("No match found.");
        }
        return result.toString();
    }

    public static String replaceMatches(String text, String regex, String replacement) {
        return text.replaceAll(regex, replacement);
    }
}
