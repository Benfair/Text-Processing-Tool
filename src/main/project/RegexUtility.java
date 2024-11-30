package main.project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtility {
    public static String findMatches(String text, String regex) {
        StringBuilder result = new StringBuilder("Finding Matches...\n");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        String match = null;

        while (matcher.find()) {
            count++;
            if (match == null) {
                match = matcher.group();
            }
        }

        if (count > 0) {
            result.append(String.format("Match: %s\nTotal Match(es) Found: %d", match, count));
        } else {
            result.append("No match found.");
        }
        return result.toString();
    }

    public static String replaceMatches(String text, String regex, String replacement) {
        return text.replaceAll(regex, replacement);
    }
}
